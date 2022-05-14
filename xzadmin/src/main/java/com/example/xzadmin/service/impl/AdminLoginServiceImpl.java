package com.example.xzadmin.service.impl;

import com.example.xzadmin.bean.User;
import com.example.xzadmin.mapper.UserMapper;
import com.example.xzadmin.service.AdminLoginService;
import com.example.xzadmin.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String adminLogin(String username, String password, String captcha, HttpSession session) {
        java.lang.String s_captcha = session.getAttribute("captcha").toString();
        if (!s_captcha.equalsIgnoreCase(captcha.trim())) {
            return "验证码错误";
        }
        User user = userMapper.login(username.trim(), username.trim(), MD5Util.getMD5Str(password));
        if (user != null) {
            session.setAttribute("user", user);
            return "ok";
        }
        return "账号或密码错误";
    }
}
