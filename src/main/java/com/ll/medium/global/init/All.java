package com.ll.medium.global.init;

import com.ll.medium.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class All {
    private final MemberService memberService;

    @Bean
    @Order(1)
    public ApplicationRunner initAll() {
        return args -> {
            if (memberService.findByUsername("system").isPresent()) return;

            memberService.join("system", "system");
            memberService.join("admin", "admin");
        };
    }
}