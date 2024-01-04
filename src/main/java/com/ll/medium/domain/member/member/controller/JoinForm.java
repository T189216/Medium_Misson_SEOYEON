package com.ll.medium.domain.member.member.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Boolean isPaid;
}