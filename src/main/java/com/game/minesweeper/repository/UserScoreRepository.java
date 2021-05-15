package com.game.minesweeper.repository;

import com.game.minesweeper.entity.UserScore;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Long> {
    List<UserScore> findAllByOrderByScoreDesc();
}
