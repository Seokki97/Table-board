package com.example.graduation.member.dto;

import com.example.graduation.member.domain.Member;
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

    public MemberDto(Member member){
        this.id = member.getId();
        this.email=member.getEmail();
        this.nickname = member.getNickname();
        this.password = member.getPassword();

    }

}
