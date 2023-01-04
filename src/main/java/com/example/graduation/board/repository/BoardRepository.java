package com.example.graduation.board.repository;

import com.example.graduation.board.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByTitle(String title);

    Optional<Board> findByContent(String content);

    Optional<Board> findById(Long id);

    boolean existsByTitle(String title);

    boolean existsByContent(String content);

    boolean existsById(Long id);

}
