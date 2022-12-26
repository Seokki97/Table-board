package com.example.graduation.member.controller;

import com.example.graduation.member.dto.MemberRequestDto;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.SignUpSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/mamber")
@RestController
public class MemberController {

    private final SignUpSerivce signUpSerivce;
    private final MemberRepository memberRepository;


    @PostMapping("/join")
    public Long join(@RequestBody MemberRequestDto memberRequestDto) throws Exception{
        return signUpSerivce.signUp(memberRequestDto);
    }
}
