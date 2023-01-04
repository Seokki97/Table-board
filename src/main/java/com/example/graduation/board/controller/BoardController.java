package com.example.graduation.board.controller;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.dto.BoardResponseDto;
import com.example.graduation.board.service.BoardService;
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
    public ResponseEntity<Long> writeBoard(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.writePost(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/findByTitle")
    public ResponseEntity<Long> findWithTitle(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.findPostWithTitle(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/findByContent")
    public ResponseEntity<Long> findWithContent(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.findPostWithContent(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @GetMapping("/showBoardList")
    public List<Board> showBoardList() {

        return boardService.showAllPostList();
    }

    @GetMapping("/showPost/{id}")
    public Board showPost(@PathVariable("id") Long id) {

        return boardService.showPost(id);
    }

    @PutMapping("/updatePost/{id}")
    public Board modifiedPost(@PathVariable("id") Long id, @RequestBody BoardRequestDto boardRequestDto){
       return boardService.modifiedPost(id,boardRequestDto);
    }
}
