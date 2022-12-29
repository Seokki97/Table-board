package com.example.graduation.member.service;

import com.example.graduation.member.domain.Member;
import com.example.graduation.member.jwt.JwtTokenService;
import com.example.graduation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String isValidMemberIdAndPassword(String email, String password){
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 아이디입니다."));

        String finalPassword = member.getPassword();
        //멤버스한테서 받은 패스워드하고 passwordencoder를 비교해서 같은지 확인하는거잖아
        if(passwordEncoder.matches(password,finalPassword)){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        List<String> roles = new ArrayList<>();
        roles.add(member.getRole().name());
        return jwtTokenService.createToken(member.getEmail(),roles);
    }

}
