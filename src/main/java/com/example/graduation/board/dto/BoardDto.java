package com.example.graduation.board.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "board")
public class BoardDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;

    private String content;


    private LocalDateTime createdDate;


    private LocalDateTime updatedDate;

}
