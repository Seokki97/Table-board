package com.example.graduation.board.domain;


import com.example.graduation.member.domain.Member;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "board")
@Table(name = "board")
@Data
public class TableBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 60)
    private String title;

    @Column(nullable = false, length = 255)
    private String content;

    @ManyToOne
    private Member member;


}
