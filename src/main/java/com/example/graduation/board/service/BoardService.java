package com.example.graduation.board.service;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.dto.BoardResponseDto;
import com.example.graduation.board.repository.BoardRepository;

import com.example.graduation.member.domain.Member;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    private final MemberRepository memberRepository;

    private final LoginService loginService;
    public Board writePost(Long memberId, BoardRequestDto boardRequestDto) {

        //멤버아이디를 모르는데 어케찾아?
        Member member = memberRepository.findById(memberRepository.findById(memberId).get().getId()).get();
        boardRequestDto.setCreatedDate(LocalDateTime.now());
        Board board = boardRepository.save(boardRequestDto.toEntity(member));
        return board;
    }

    //해당 제목과 일치하는 board 반환
    public Board findPostWithTitle(BoardRequestDto boardRequestDto) {
        if (!boardRepository.existsByTitle(boardRequestDto.getTitle())) {
            throw new IllegalArgumentException("해당 제목과 일치한 게시물이 없습니다.");
        }
        System.out.println("왜안떠");
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

    //게시글 수정 //updatedDate도 추가해야함 //멤버아이디도 있어야함
    public Board modifiedPost(Long id,Long memberId, BoardRequestDto boardRequestDto) {
        Board board = showPost(id);
        //보드를 받아옴 //엔티티 클래스에서 setter 사용을 지양하자! -> 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 구분하기 어려워짐
        if(!memberRepository.existsById(memberRepository.findById(memberId).get().getId())){
            throw new IllegalArgumentException("로그인 상태가 아닙니다.");
        }
        Member member = memberRepository.findById(memberRepository.findById(memberId).get().getId()).get();
        BoardResponseDto boardResponseDto = new BoardResponseDto(board.getId(), boardRequestDto.getTitle(), boardRequestDto.getContent());
        boardResponseDto.setCreatedDate(board.getCreatedDate()); // 생성일자는 유지해놔야하기 때문에
        boardResponseDto.setUpdatedDate(LocalDateTime.now());
        Board modifiedBoard = boardResponseDto.toEntity(member);
        boardRepository.save(modifiedBoard);
        return modifiedBoard;
    }

    //게시글 삭제
    public void deletePost(Long id,Long memberId){
        if(!memberRepository.existsById(memberRepository.findById(memberId).get().getId())){
            throw new IllegalArgumentException("로그인 상태가 아닙니다.");
        }
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물을 찾을 수 없습니다"));

        boardRepository.delete(board);
    }


}
