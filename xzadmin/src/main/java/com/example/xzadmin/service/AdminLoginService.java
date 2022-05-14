package com.example.xzadmin.service;

import javax.servlet.http.HttpSession;

public interface AdminLoginService {
    String adminLogin(String username, String password, String captcha, HttpSession session);
}
