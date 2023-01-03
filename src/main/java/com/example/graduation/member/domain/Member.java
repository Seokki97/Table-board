package com.example.graduation.member.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "member")
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false, length = 60)
    private String email;
    @NotNull
    @Column(nullable = false, length = 60)
    private String nickname;
    @NotNull
    @Column(nullable = false, length = 255)
    private String password;

    //패스워드 암호화
    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }

    @Builder
    public Member(Long id, String email, String nickname, String password){
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

}
