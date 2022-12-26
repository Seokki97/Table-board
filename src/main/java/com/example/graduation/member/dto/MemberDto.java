package com.example.graduation.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data //@toString + @getter
// + @setter @Requireargconstructor @equeals,hashcode
@Table(name = "member")
public class MemberDto {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String email;

    private String nickname;

    private String password;


}
