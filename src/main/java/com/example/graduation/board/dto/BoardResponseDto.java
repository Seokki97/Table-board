package com.example.graduation.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String title;

    private String content;
}
