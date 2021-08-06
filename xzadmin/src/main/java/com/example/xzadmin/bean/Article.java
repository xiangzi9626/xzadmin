package com.example.xzadmin.bean;

import lombok.Data;

@Data
public class Article {
    private Integer id;

    private Integer cid;

    private String title;

    private Byte status;

    private String createTime;

    private String content;

    public Article() {
    }
}