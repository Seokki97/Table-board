package com.example.graduation.member.dto;


import lombok.*;


@Data
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;

    private String email;

    private String nickname;

    private String password;
}
