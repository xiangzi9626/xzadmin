package com.example.xzadmin.service.impl;

import com.example.xzadmin.bean.Article;
import com.example.xzadmin.mapper.ArticleMapper;
import com.example.xzadmin.service.ArticleService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Map<String, Object> list(int page, int pagesize) {
        List<Map<java.lang.String, Object>> data = articleMapper.list(page, pagesize);
        int count = articleMapper.count();
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", data);
        return map;
    }


    @Override
    public java.lang.String setStatus(int id, int status) {
        int set = articleMapper.setStatus(id, status);
        if (set > 0) {
            return "ok";
        }
        return "操作失败,请重试";
    }

    @Override
    public java.lang.String update(Article article) {
        int up = articleMapper.update(article);
        if (up > 0) {
            return "ok";
        }
        return "提交失败,请重试";
    }

    @Override
    public java.lang.String insert(Article article) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.lang.String date = sdf.format(new Date());
        article.setStatus((byte) 1);
        article.setCreateTime(date);
        int insert = articleMapper.insert(article);
        if (insert > 0) {
            return "ok";
        }
        return "添加失败请重试";
    }

    @Override
    public java.lang.String delete(int id) {
        int del = articleMapper.delete(id);
        if (del > 0) {
            return "ok";
        }
        return "删除失败,请重试";
    }

    @Override
    public Map<java.lang.String, Object> getone(int id) {
        return articleMapper.getone(id);
    }
}
