package com.example.graduation.member.controller;

import com.example.graduation.member.config.SecurityConfig;
import com.example.graduation.member.config.SecurityUtil;
import com.example.graduation.member.dto.MemberRequestDto;
import com.example.graduation.member.service.LoginService;
import com.example.graduation.member.service.SignUpSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RequestMapping("member")
@RestController
public class MemberController {

    private final SignUpSerivce signUpSerivce;
    private final LoginService loginService;

    @PostMapping("/signUp")
    public Long signUp(@RequestBody MemberRequestDto memberRequestDto) throws Exception {
        return signUpSerivce.signUp(memberRequestDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberRequestDto memberRequestDto) {
        return loginService.permitUserLogin(memberRequestDto);

    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        new SecurityContextLogoutHandler()
                .logout(httpServletRequest, httpServletResponse, SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok().body(true);
    }

    @GetMapping("/userInfo")
    public String getUserInfo() {
        return SecurityUtil.getLoginUserName();
    }
}
