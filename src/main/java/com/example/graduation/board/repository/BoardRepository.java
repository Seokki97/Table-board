package com.example.graduation.board.repository;

import com.example.graduation.board.domain.TableBoard;
import com.example.graduation.member.dto.MemberRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<TableBoard, Long> {
    Optional<TableBoard> findByTitle(String title);

    Optional<TableBoard> findByContent(String content);

    Optional<MemberRequestDto> findByNickname(String nickname);
}
