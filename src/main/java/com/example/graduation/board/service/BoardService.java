package com.example.graduation.board.service;

import com.example.graduation.board.domain.Board;
import com.example.graduation.board.dto.BoardRequestDto;
import com.example.graduation.board.dto.BoardResponseDto;
import com.example.graduation.board.repository.BoardRepository;
import com.example.graduation.member.config.SecurityUtil;
import com.example.graduation.member.domain.Member;
import com.example.graduation.member.repository.MemberRepository;
import com.example.graduation.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    public Board writePost(BoardRequestDto boardRequestDto, Member member){
        System.out.println(SecurityUtil.getLoginUserName());
        memberRepository.findByEmail(SecurityUtil.getLoginUserName())
                .orElseThrow(() -> new IllegalArgumentException("로그인한 유저 정보가 없습니다"));
        Board board = Board.creatBoard(boardRequestDto, member);
        return boardRepository.save(board);

    }
}
