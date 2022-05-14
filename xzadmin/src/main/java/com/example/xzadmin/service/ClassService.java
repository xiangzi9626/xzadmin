package com.example.xzadmin.service;

import com.example.xzadmin.bean.Class;

import java.util.Map;

public interface ClassService {
    Map<String, Object> list();

    Map<String, Object> dtree();

    String add(Class c);

    String edit(Class c);

    String delete(Integer id);

    Map<String, Object> getone(Integer id);
}
