package com.example.xzadmin.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Integer level;

    private String money;

    private String create_time;

    public User() {
    }
}