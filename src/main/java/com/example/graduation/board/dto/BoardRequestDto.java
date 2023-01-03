package com.example.graduation.board.dto;

import com.example.graduation.board.domain.Board;
import com.example.graduation.member.domain.Member;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;

@Table(name = "member")
@Data
public class BoardRequestDto {

    private Long id;

    private String title;

    private String content;
    @Builder
    public BoardRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(Member member){
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
