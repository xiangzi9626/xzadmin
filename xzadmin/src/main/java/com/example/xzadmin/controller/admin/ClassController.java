package com.example.xzadmin.controller.admin;

import com.example.xzadmin.bean.Class;
import com.example.xzadmin.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/class")
    @ResponseBody
    public Map<String, Object> list() {
        return classService.list();
    }

    @PostMapping("/class/dtree")
    @ResponseBody
    public Map<String, Object> dtree() {
        return classService.dtree();
    }

    @PostMapping("/class/add")
    @ResponseBody
    public String add(Class c) {
        return classService.add(c);
    }

    @PostMapping("/class/edit")
    @ResponseBody
    public String edit(Class c) {
        return classService.edit(c);
    }

    @PostMapping("/class/delete")
    @ResponseBody
    public String delete(Integer id) {
        return classService.delete(id);
    }

    @PostMapping("/class/getone")
    @ResponseBody
    public Map<String, Object> getone(Integer id) {
        return classService.getone(id);
    }
}
