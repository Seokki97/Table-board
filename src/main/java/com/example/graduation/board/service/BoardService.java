package com.example.graduation.board.service;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board writePost(BoardRequestDto boardRequestDto) {
        Board board = Board.creatBoard(boardRequestDto);
        LocalDate.now();
        return boardRepository.save(board);

    }

    //해당 제목과 일치하는 board 반환
    public Board findPostWithTitle(BoardRequestDto boardRequestDto) {
        if (!boardRepository.existsByTitle(boardRequestDto.getTitle())) {
            throw new IllegalArgumentException("해당 제목과 일치한 게시물이 없습니다.");
        }
        return boardRepository.findByTitle(boardRequestDto.getTitle()).get();
    }

    //해당 내용과 일치하는 board 반환
    public Board findPostWithContent(BoardRequestDto boardRequestDto) {
        if (!boardRepository.existsByContent(boardRequestDto.getContent())) {
            throw new IllegalArgumentException("해당 내용과 일치한 게시물이 없습니다");
        }
        return boardRepository.findByContent(boardRequestDto.getContent()).get();
    }

    //게시글 리스트 전체조회
    public List<Board> showAllPostList() {
        List<Board> boardList = boardRepository.findAll();

        return boardList;
    }

    //게시글 단일 조회 -> 게시물 제목을 클릭하면 해당 게시물의 내용을 보내주면됨
    public Board showPost(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 개시글을 찾을 수 없습니다"));
        return board;
    }
    //게시글 수정

    //게시글 삭제


}
