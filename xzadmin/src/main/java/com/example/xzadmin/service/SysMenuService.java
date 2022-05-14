package com.example.xzadmin.service;

import com.example.xzadmin.bean.MenuVo;

import java.util.Map;

public interface SysMenuService {
    MenuVo selectOne(Integer id);

    Map<String, Object> menuLeft();

    Map<String, Object> menuList();

    Map<String, Object> menuTree();

    String insert(MenuVo menu);

    String edit(MenuVo menu);

    String delete(Integer id);

    String setStatus(Integer id, Integer status);
}
