package com.ll.medium.global.init;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.service.MemberService;
import com.ll.medium.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
@Slf4j
@RequiredArgsConstructor
public class NotProd {
    private final MemberService memberService;
    private final PostService postService;

    @Bean
    @Order(2)
    public ApplicationRunner initNotProd() {
        return args -> {
            if (memberService.findByUsername("user1").isPresent()) return;

            Member User1 = memberService.join("user1", "1234", true).getData();
            Member User2 = memberService.join("user2", "1234", true).getData();
            Member User3 = memberService.join("user3", "1234", false).getData();
            Member User4 = memberService.join("user4", "1234", false).getData();

            postService.write(User1, "제목 1", "내용 1", true, false);
            postService.write(User1, "제목 2", "내용 2", true, true);
            postService.write(User1, "제목 3", "내용 3", false, false);

            postService.write(User2, "제목 4", "내용 4", false, true);
            postService.write(User2, "제목 5", "내용 5", true, true);

            IntStream.rangeClosed(6, 110).forEach(i -> {
                postService.write(User3, "제목 " + i, "내용 " + i, true, false);
            });
            IntStream.rangeClosed(111, 210).forEach(i -> {
                postService.write(User3, "제목 " + i, "내용 " + i, true, true);
            });
        };
    }
}