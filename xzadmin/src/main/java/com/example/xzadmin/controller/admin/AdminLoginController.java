package com.example.xzadmin.controller.admin;

import com.example.xzadmin.bean.User;
import com.example.xzadmin.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("/admin_login")
    @ResponseBody
    public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("captcha") String captcha, HttpSession session) {
        return adminLoginService.adminLogin(username, password, captcha, session);
    }

    @GetMapping("/xzadmin/login")
    public String adminLoginHtml(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/admin/index";
        }
        return "admin/login";
    }

    @PostMapping("/admin/getLoginInfo")
    @ResponseBody
    public User getLoginInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }

    @PostMapping("/admin/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate();
        return "ok";
    }
}
