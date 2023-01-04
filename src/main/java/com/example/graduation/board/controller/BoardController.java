package com.example.graduation.board.controller;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.service.BoardService;
import com.example.graduation.member.domain.Member;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/content")
    public ResponseEntity<Long> writeBoard(@RequestBody BoardRequestDto boardRequestDto){
        boardService.writePost(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

}
