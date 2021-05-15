package com.game.minesweeper.controller;

import com.game.minesweeper.entity.UserScore;
import com.game.minesweeper.repository.UserScoreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserScoreController {
    private final UserScoreRepository userScoreRepository;

    public UserScoreController(UserScoreRepository userScoreRepository) {
        this.userScoreRepository = userScoreRepository;
    }
    @GetMapping("/getTop")
    @ResponseBody
    public List<UserScore> get(){
        List<UserScore> userScores = userScoreRepository.findAllByOrderByScoreDesc();
        return userScores;
    }

    @PostMapping("/uploadScore")
    @ResponseBody
    public UserScore uploadScore(String user_ip, int score){
        UserScore userScore = new UserScore();
        userScore.setUser_ip(user_ip);
        userScore.setScore(score);
        return userScoreRepository.save(userScore);
    }
}
