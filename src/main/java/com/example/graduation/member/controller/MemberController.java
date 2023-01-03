package com.example.graduation.member.controller;

import com.example.graduation.member.config.SecurityUtil;
import com.example.graduation.member.domain.Member;
import com.example.graduation.member.dto.MemberDto;
import com.example.graduation.member.dto.MemberRequestDto;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.LoginService;
import com.example.graduation.member.service.SignUpSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RequestMapping("member")
@RestController
public class MemberController {

    private final SignUpSerivce signUpSerivce;
    private final LoginService loginService;
    private final MemberRepository memberRepository;


    @PostMapping("/signUp")
    public Long signUp(@RequestBody MemberRequestDto memberRequestDto) throws Exception{
        return signUpSerivce.signUp(memberRequestDto);
    }


    @PostMapping("/login")
    public MemberDto login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse httpServletResponse){
        return loginService.permitUserLogin(memberRequestDto,httpServletResponse);

    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse httpServletResponse){
        loginService.logoutMember(httpServletResponse);
    }

    @GetMapping("/userInfo")
    public String getUserInfo(){
        return SecurityUtil.getLoginUserName();
    }
}
