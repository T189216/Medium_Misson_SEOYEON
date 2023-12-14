package com.ll.medium.domain.member.member.controller;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.service.MemberService;
import com.ll.medium.global.rq.Rq.Rq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @GetMapping("/join")
    public String showJoin() {
        return "domain/member/member/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm) {
        Member member = memberService.join(joinForm.getUsername(), joinForm.getPassword());

        return rq.redirect(
                "/",
                "%s님 환영합니다. 로그인 후 이용해주세요.".formatted(member.getUsername())
        );
    }
}