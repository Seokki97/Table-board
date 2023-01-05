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


    @PostMapping("/write")
    public ResponseEntity<Long> writeBoard(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.writePost(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/title")
    public ResponseEntity<Long> findWithTitle(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.findPostWithTitle(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/content")
    public ResponseEntity<Long> findWithContent(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.findPostWithContent(boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @GetMapping("/board-list")
    public ResponseEntity<List<Board>> showBoardList() {

        return ResponseEntity.ok().body(boardService.showAllPostList());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Board> showPost(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(boardService.showPost(id));
    }

    @PutMapping("/modifying/{id}")
    public ResponseEntity<Board> modifiedPost(@PathVariable("id") Long id, @RequestBody BoardRequestDto boardRequestDto){
       return ResponseEntity.ok().body(boardService.modifiedPost(id,boardRequestDto));
    }

}
