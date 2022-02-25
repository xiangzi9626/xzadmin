package com.example.xzadmin.controller;

import com.example.xzadmin.mapper.ArticleMapper;
import com.example.xzadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping("/article/list")
    @ResponseBody
    public Map<String, Object> list(Integer pageIndex, Integer pageSize) {
        Integer count = articleMapper.count();
        List<Map<java.lang.String, Object>> res = articleMapper.list((pageIndex - 1) * pageSize, pageSize);
        Map<java.lang.String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("data", res);
        System.out.print(pageIndex + "页码");
        return map;
    }
}
