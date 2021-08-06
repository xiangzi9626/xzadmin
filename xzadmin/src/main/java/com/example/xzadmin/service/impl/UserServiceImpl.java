package com.example.xzadmin.service.impl;

import com.example.xzadmin.bean.User;
import com.example.xzadmin.mapper.UserMapper;
import com.example.xzadmin.service.UserService;
import com.example.xzadmin.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> adminList(Integer level, Integer page, Integer pagesize) {
        List<User> data = userMapper.adminList(level, page, pagesize);
        int count = userMapper.adminCount(level);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", data);
        return map;
    }

    @Override
    public Map<java.lang.String, Object> userList(Integer level, Integer page, Integer pagesize) {
        List<User> data = userMapper.userList(level, page, pagesize);
        int count = userMapper.userCount(level);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", data);
        return map;
    }

    @Override
    public java.lang.String delete(Integer id) {
        int del = userMapper.delete(id);
        if (del > 0) {
            return "ok";
        }
        return "删除失败请重试";
    }

    @Override
    public java.lang.String edit(User user) {
        String username = user.getUsername().trim();
        String phone = user.getPhone().trim();
        String password = user.getPassword();
        if (username.length() < 4 || username.length() > 20) {
            return "请输入4-20位用户名";
        }
        if (password.trim().length() > 0) {
            if (password.length() < 6 || password.length() > 30) {
                return "请输入6-30位密码";
            }
        }
        int usernameCount = userMapper.excludeUsername(user.getId(), username);
        if (usernameCount > 0) {
            return "用户名已存在不可用";
        }
        if (!Pattern.matches("^[1-9][0-9]{10}$", phone)) {
            return "请输入11位手机号";
        }
        int phoneCount = userMapper.excludePhone(user.getId(), phone);
        if (phoneCount > 0) {
            return "手机号已存在不可用";
        }
        user.setUsername(username);
        if (password.trim().equals("")) {
            User u = userMapper.getone(user.getId());
            user.setPassword(u.getPassword());
        } else {
            user.setPassword(MD5Util.getMD5Str(password));
        }
        user.setPhone(phone);
        int edit = userMapper.update(user);
        if (edit > 0) {
            return "ok";
        }
        return "提交失败请重试";
    }

    @Override
    public java.lang.String add(User user) {
        String username = user.getUsername().trim();
        String phone = user.getPhone().trim();
        String password = user.getPassword();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.lang.String date = sdf.format(new Date());
        if (username.length() < 4 || username.length() > 20) {
            return "请输入4-20位用户名";
        }
        if (password.length() < 6 || password.length() > 30) {
            return "请输入6-30位密码";
        }
        int usernameCount = userMapper.usernameCount(username);
        if (usernameCount > 0) {
            return "用户名已存在不可用";
        }
        if (!Pattern.matches("^[1-9][0-9]{10}$", phone)) {
            return "请输入11位手机号";
        }
        int phoneCount = userMapper.phoneCount(phone);
        if (phoneCount > 0) {
            return "手机号已存在不可用";
        }
        user.setUsername(username);
        user.setPassword(MD5Util.getMD5Str(password));
        user.setPhone(phone);
        user.setCreate_time(date);
        int add = userMapper.insert(user);
        if (add > 0) {
            return "ok";
        }
        return "提交失败请重试";
    }

    @Override
    public User getone(Integer id) {
        return userMapper.getone(id);
    }

    @Override
    public String updatePassword(HttpSession session, String oldPassword, String newPassword) {
        User user = (User) session.getAttribute("user");
        if (!MD5Util.getMD5Str(oldPassword).equals(user.getPassword())) {
            return "原始密码错误";
        }
        if (newPassword.length() < 6 || newPassword.length() > 30) {
            return "请输入6-30位新密码";
        }
        int up = userMapper.updatePassword(user.getId(), MD5Util.getMD5Str(newPassword));
        if (up > 0) {
            User u = userMapper.getone(user.getId());
            session.setAttribute("user", u);
            return "ok";
        }
        return "提交失败请重试";
    }
}
