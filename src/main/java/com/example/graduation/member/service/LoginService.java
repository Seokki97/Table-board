package com.example.graduation.member.service;

import com.example.graduation.member.domain.Member;
import com.example.graduation.member.dto.MemberRequestDto;
import com.example.graduation.member.jwt.JwtTokenService;
import com.example.graduation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    //email로 유저 찾기

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
    public void isExistMemberEmail(String email){
        if(!memberRepository.existsByEmail(email)){
            throw new IllegalArgumentException("가입되지 않은 아이디입니다.");
        }
    }
    public String permitUserLogin(MemberRequestDto memberRequestDto){
        isExistMemberEmail(memberRequestDto.getEmail());
        Member member = memberRepository.findByEmail(memberRequestDto.getEmail()).get();
        String finalPassword = member.getPassword();

        if(!passwordEncoder.matches(memberRequestDto.getPassword(), finalPassword)){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenService.createToken(memberRequestDto.getEmail());
    }

}
