package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel("电影实体类")
public class Movie {@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "电影ID")
    private int id;
    @ApiModelProperty(value = "电影名")
    private String name;
    @ApiModelProperty(value = "评分")
    private String score;
    @ApiModelProperty(value = "简介")
    @Column(columnDefinition = "TEXT")
    private String jian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getJian() {
        return jian;
    }

    public void setJian(String jian) {
        this.jian = jian;
    }
}
