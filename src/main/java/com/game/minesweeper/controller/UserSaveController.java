package com.game.minesweeper.controller;

import com.game.minesweeper.entity.UserSave;
import com.game.minesweeper.repository.UserSaveRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;


@RestController
public class UserSaveController {
    private final UserSaveRepository userSaveRepository;

    public UserSaveController(UserSaveRepository userSaveRepository) {
        this.userSaveRepository = userSaveRepository;
    }

    @GetMapping("/getList")
    @ResponseBody
    public List<UserSave> getList(String ip){
        List<UserSave> userSaves = userSaveRepository.findAllByIp(ip);
        return userSaves;
    }

    @GetMapping("/get")
    @ResponseBody
    public UserSave get(Long id){
        Optional<UserSave> userSave = userSaveRepository.findById(id);
        if (userSave.isPresent()){
            return userSave.get();
        }else {
            return null;
        }
    }

    @PostMapping("/save")
    @ResponseBody
    public UserSave save(String ip, String mine_data1, String mine_flag1, String haveDigged1,
                         String mine_data2, String mine_flag2, String haveDigged2,
                         Integer time, Integer remaingMines){

        UserSave userSave = new UserSave();
        System.out.println(mine_data1);
        userSave.setIp(ip);
        userSave.setMine_data1(mine_data1);
        userSave.setMine_flag1(mine_flag1);
        userSave.setHaveDigged1(haveDigged1);
        userSave.setMine_data2(mine_data2);
        userSave.setMine_flag2(mine_flag2);
        userSave.setHaveDigged2(haveDigged2);
        userSave.setTime(time);
        userSave.setRemaingMines(remaingMines);
        userSave.setCreateTime(new Timestamp(new java.util.Date().getTime()));

        return userSaveRepository.save(userSave);
    }

}
