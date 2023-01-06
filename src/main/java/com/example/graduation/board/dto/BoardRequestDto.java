package com.example.graduation.board.dto;

import com.example.graduation.board.domain.Board;
import com.example.graduation.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;
import java.time.LocalDateTime;


@Table(name = "member")
@Data
public class BoardRequestDto {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private Long memberId;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


    @Builder
    public BoardRequestDto(Long memberId ,String title, String content ) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    public Board toEntity(Member member) {
        return Board.builder()
                .member(member)
                .id(id)
                .title(title)
                .createdDate(createdDate)
                .content(content)
                .build();
    }
}
