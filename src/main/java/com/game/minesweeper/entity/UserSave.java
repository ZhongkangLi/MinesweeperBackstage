package com.game.minesweeper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="\"user_save\"")
public class UserSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String ip;
    private String mine_data1;
    private String mine_data2;
    private String mine_flag1;
    private String mine_flag2;
    private String haveDigged1;
    private String haveDigged2;
    private Integer time;
    private Integer remaingMines;
    private Timestamp createTime;
}
