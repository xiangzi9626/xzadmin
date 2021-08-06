package com.example.xzadmin.service;

import com.example.xzadmin.bean.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {
    Map<String, Object> adminList(Integer level, Integer page, Integer pagesize);

    Map<String, Object> userList(Integer level, Integer page, Integer pagesize);

    String delete(Integer id);

    String edit(User user);

    String add(User user);

    User getone(Integer id);

    String updatePassword(HttpSession session, String oldPassword, String newPassword);
}
