package com.example.graduation.board.service;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;

import com.example.graduation.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public Board writePost(BoardRequestDto boardRequestDto){
        Board board = Board.creatBoard(boardRequestDto);
        LocalDate.now();
        return boardRepository.save(board);

    }
}
