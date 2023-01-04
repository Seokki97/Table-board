package com.example.graduation.board.controller;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.service.BoardService;
import com.example.graduation.member.domain.Member;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/writeBoard")
    public ResponseEntity<Long> writeBoard(@RequestBody BoardRequestDto boardRequestDto){
        boardService.writePost(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/findByTitle/{id}")
    public ResponseEntity<Long> findWithTitle(@RequestBody BoardRequestDto boardRequestDto){
        boardService.findPostWithTitle(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }
    @PostMapping("/findByContent/{id}")
    public ResponseEntity<Long> findWithContent(@RequestBody BoardRequestDto boardRequestDto){
        boardService.findPostWithContent(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @GetMapping("/showBoardList")
    public List<Board> showBoardList(){

        return boardService.showAllPostList();
    }
}
