package com.example.graduation.member.service;

import com.example.graduation.member.domain.Member;
import com.example.graduation.member.dto.MemberRequestDto;
import com.example.graduation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpSerivce {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //이메일 중복 확인
    public void isDuplicateEmail(MemberRequestDto memberRequestDto) throws Exception {
        if (memberRepository.findByEmail(memberRequestDto.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다");
        }
    }

    //닉네임 중복 확인
    public void isDuplicateNickname(MemberRequestDto memberRequestDto) throws Exception {
        if (memberRepository.findByNickname(memberRequestDto.getNickname()).isPresent()) {
            throw new Exception("이미 존재하는 이메일입니다");
        }
    }

    @Transactional
    public Long signUp(MemberRequestDto memberRequestDto) throws Exception {
        //중복검사
        isDuplicateEmail(memberRequestDto);
        isDuplicateNickname(memberRequestDto);
        //멤버 저장 후 비밀번호 암호화
        Member member = memberRepository.save(memberRequestDto.toEntity());
        member.encodePassword(passwordEncoder);

        return member.getId();
    }
}
