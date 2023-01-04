package com.example.graduation.board.dto;

import com.example.graduation.board.domain.Board;
import com.example.graduation.member.domain.Member;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "member")
@Data
public class BoardRequestDto {

    private Long id;

    private String title;

    private String content;


    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;



    @Builder
    public BoardRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
