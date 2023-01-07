package com.example.graduation.board.controller;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
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

    //로그인안된애는 예외처리해줘야함
    @PostMapping("/write/{member_id}")
    public ResponseEntity<Long> writeBoard(@RequestBody BoardRequestDto boardRequestDto, @PathVariable("member_id") Long memberId) {
        boardService.writePost(memberId, boardRequestDto);
        return ResponseEntity.ok().body(boardRequestDto.getId());
    }

    @PostMapping("/title")
    public ResponseEntity<Board> findWithTitle(@RequestBody BoardRequestDto boardRequestDto) {

        return ResponseEntity.ok().body(boardService.findPostWithTitle(boardRequestDto));
    }

    @PostMapping("/content")
    public ResponseEntity<Board> findWithContent(@RequestBody BoardRequestDto boardRequestDto) {

        return ResponseEntity.ok().body(boardService.findPostWithContent(boardRequestDto));
    }

    @GetMapping("/board-list")
    public ResponseEntity<List<Board>> showBoardList() {

        return ResponseEntity.ok().body(boardService.showAllPostList());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Board> showPost(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(boardService.showPost(id));
    }

    @PutMapping("/modifying/{id}/{memberId}")
    public ResponseEntity<Board> modifiedPost(@PathVariable("id") Long id, @PathVariable("memberId") Long memberId
            , @RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.ok().body(boardService.modifiedPost(id, memberId, boardRequestDto));
    }

    @DeleteMapping("/deletion/{id}/{memberId}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id, @PathVariable("memberId") Long memberId) {
        boardService.deletePost(id, memberId);
        return ResponseEntity.ok().body(true);
    }
}
