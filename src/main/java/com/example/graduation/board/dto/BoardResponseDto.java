package com.example.graduation.board.dto;

import com.example.graduation.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String title;

    private String content;


    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public BoardResponseDto(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .createdDate(createdDate)
                .updatedDate(updatedDate)
                .build();
    }
}
