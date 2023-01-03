package com.example.graduation.board.controller;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.service.BoardService;
import com.example.graduation.member.domain.Member;
import lombok.RequiredArgsConstructor;
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
    public String writeBoard(@RequestBody BoardRequestDto boardRequestDto, Member member){
        boardService.writePost(boardRequestDto, member);
        return "na";
    }

}
