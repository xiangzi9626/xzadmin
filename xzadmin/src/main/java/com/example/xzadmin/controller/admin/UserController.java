package com.example.xzadmin.controller.admin;

import com.example.xzadmin.bean.User;
import com.example.xzadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    @ResponseBody
    public String add(User user) {
        return userService.add(user);
    }

    @PostMapping("/user/delete")
    @ResponseBody
    public String delete(Integer id) {
        return userService.delete(id);
    }

    @PostMapping("/user/edit")
    @ResponseBody
    public String edit(User user) {
        return userService.edit(user);
    }

    @RequestMapping("/admin/list")
    @ResponseBody
    public Map<String, Object> adminlist(Integer page, Integer limit) {
        return userService.adminList(3, (page - 1) * limit, limit);
    }

    @RequestMapping("/user/list")
    @ResponseBody
    public Map<String, Object> userlist(Integer page, Integer limit) {
        return userService.userList(3, (page - 1) * limit, limit);
    }

    @RequestMapping("/user/getone")
    @ResponseBody
    public User getone(Integer id) {
        return userService.getone(id);
    }

    @PostMapping("/updatepassword")
    @ResponseBody
    public String updatePassword(String oldPassword, String newPassword, HttpSession session) {
        return userService.updatePassword(session, oldPassword, newPassword);
    }
}
