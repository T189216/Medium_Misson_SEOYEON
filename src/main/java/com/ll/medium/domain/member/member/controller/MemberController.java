package com.ll.medium.domain.member.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/join")
    public String showJoin() {
        return "domain/member/member/join";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm) {

        return "redirect:/";
    }
}