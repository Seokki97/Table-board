package com.example.graduation.board.service;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board writePost(BoardRequestDto boardRequestDto) {
        boardRequestDto.setCreatedDate(LocalDateTime.now());
        Board board = Board.creatBoard(boardRequestDto);
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
    //게시글 수정 //updatedDate도 추가해야함
    public Board modifiedPost(Long id, BoardRequestDto boardRequestDto){
        //로직은 -> 먼저 findById로 받음 -> set으로 수정 -> updateddate적용 -> save
        Board board = showPost(id);
        //보드를 받아옴 //엔티티 클래스에서 setter 사용을 지양하자! -> 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 구분하기 어려워짐

        return board;
    }

    //게시글 삭제


}
