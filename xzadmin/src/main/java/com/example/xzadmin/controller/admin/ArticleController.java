package com.example.xzadmin.controller.admin;

import com.example.xzadmin.bean.Article;
import com.example.xzadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article")
    @ResponseBody
    public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return articleService.list((page - 1) * limit, limit);
    }

    @PostMapping("/article/getone")
    @ResponseBody
    public Map<java.lang.String, Object> getone(int id) {
        Map<java.lang.String, Object> map = articleService.getone(id);
        return map;
    }

    @PostMapping("/article/status")
    @ResponseBody
    public java.lang.String setStatus(int id, int status) {
        return articleService.setStatus(id, status);
    }

    @PostMapping("/article/delete")
    @ResponseBody
    public java.lang.String delete(int id) {
        return articleService.delete(id);
    }

    @PostMapping("/article/edit")
    @ResponseBody
    public java.lang.String edit(Article article) {
        return articleService.update(article);
    }

    @PostMapping("/article/add")
    @ResponseBody
    public java.lang.String add(Article article) {
        return articleService.insert(article);
    }
}
