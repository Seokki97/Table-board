package com.example.graduation.board.domain;


import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.member.domain.Member;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "board")
@Table(name = "board")
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false, length = 60)
    private String title;

    @NotNull
    @Column(nullable = false, length = 255)
    private String content;

   /* @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<Recommend> recommends = new ArrayList<>();*/

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Builder
    public Board(Long id, String title, String content,
                 LocalDateTime createdDate, LocalDateTime updatedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;

    }

    public static Board creatBoard(BoardRequestDto boardRequestDto){
        Board board = new Board();
        board.title = boardRequestDto.getTitle();
        board.content = boardRequestDto.getContent();
        board.setCreatedDate(LocalDateTime.now());
        return board;
    }
}
