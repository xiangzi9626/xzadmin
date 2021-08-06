package com.example.xzadmin.service;

import com.example.xzadmin.bean.Article;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Map;

public interface ArticleService {
    Map<String, Object> list(int page, int pagesize);

    java.lang.String setStatus(int id, int status);

    java.lang.String update(Article article);

    java.lang.String insert(Article article);

    java.lang.String delete(int id);

    Map<java.lang.String, Object> getone(int id);
}
