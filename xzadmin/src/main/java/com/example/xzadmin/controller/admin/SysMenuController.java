package com.example.xzadmin.controller.admin;

import com.example.xzadmin.bean.MenuVo;
import com.example.xzadmin.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/menu/init")
    @ResponseBody
    public Map<String, Object> menuLeft() {
        return sysMenuService.menuLeft();
    }

    @GetMapping("/menu/list")
    @ResponseBody
    public Map<String, Object> menuList() {
        return sysMenuService.menuList();
    }

    @PostMapping("/menu/dtree")
    @ResponseBody
    public Map<String, Object> menuTree() {
        return sysMenuService.menuTree();
    }

    @PostMapping("/menu/add")
    @ResponseBody
    public String add(MenuVo menu) {
        menu.setStatus(1);
        return sysMenuService.insert(menu);
    }

    @PostMapping("/menu/delete")
    @ResponseBody
    public String delete(Integer id) {
        return sysMenuService.delete(id);
    }

    @PostMapping("/menu/edit")
    @ResponseBody
    public String edit(MenuVo menu) {
        return sysMenuService.edit(menu);
    }

    @PostMapping("/menu/status")
    @ResponseBody
    public String setStatus(Integer id, Integer status) {
        return sysMenuService.setStatus(id, status);
    }

    @PostMapping("/menu/getone")
    @ResponseBody
    public MenuVo getone(Integer id) {
        return sysMenuService.selectOne(id);
    }
}