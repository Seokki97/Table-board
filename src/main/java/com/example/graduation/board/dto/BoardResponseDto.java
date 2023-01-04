package com.example.graduation.board.dto;

import com.example.graduation.board.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String title;

    private String content;

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
