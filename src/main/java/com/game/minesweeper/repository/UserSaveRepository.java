package com.game.minesweeper.repository;

import com.game.minesweeper.entity.UserSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSaveRepository extends JpaRepository<UserSave, Long> {
    List<UserSave> findAllByIp(String ip);
}
