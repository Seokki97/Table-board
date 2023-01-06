package com.example.graduation.board.domain;

import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.member.domain.Member;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "board")
@Entity(name = "board")
public final class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false, length = 60)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    /* @OneToMany(mappedBy = "board")
     private List<Comment> comments = new ArrayList<>();

     @OneToMany(mappedBy = "board")
     private List<Recommend> recommends = new ArrayList<>();*/
//내가 만약에 로그인을 했어,
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String writer;
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Builder
    public Board(Long id, String title, String content,
                 LocalDateTime createdDate, LocalDateTime updatedDate, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.writer = member.getNickname();
        this.member = member;
    }
/*
    public static Board creatBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board();
        board.title = boardRequestDto.getTitle();
        board.content = boardRequestDto.getContent();
        board.createdDate = boardRequestDto.getCreatedDate();
        return board;
    }*/

}
