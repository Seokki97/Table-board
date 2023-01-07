package com.example.graduation.member.dto;


import com.example.graduation.member.domain.Member;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;

@Table(name = "member")
@Data
public class MemberRequestDto {
    private Long id;

    private String email;

    private String nickname;

    private String password;

    @Builder
    public MemberRequestDto(Long id, String email, String nickname, String password) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
