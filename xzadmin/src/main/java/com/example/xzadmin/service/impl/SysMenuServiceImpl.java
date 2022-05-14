package com.example.xzadmin.service.impl;

import com.example.xzadmin.bean.Dtree;
import com.example.xzadmin.bean.MenuVo;
import com.example.xzadmin.mapper.SysMenuMapper;
import com.example.xzadmin.service.SysMenuService;
import com.example.xzadmin.util.DtreeUtil;
import com.example.xzadmin.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public MenuVo selectOne(Integer id) {
        return sysMenuMapper.selectOne(id);
    }

    @Override
    public Map<String, Object> menuLeft() {
        Map<String, Object> map = new LinkedHashMap<>();
        Map<String, Object> home = new HashMap<>();
        Map<String, Object> logo = new HashMap<>();
        List<MenuVo> menulist = sysMenuMapper.menuLeft(1);
       /* Gson gson=new Gson();
       String menuInfo=gson.toJson(menulist);*/
        home.put("title", "首页");
        home.put("href", "/layuimini-2/page/welcome.html");//控制器路由,自行定义
        logo.put("title", "后台管理系统");
        logo.put("image", "/layuimini-2/images/logo.png");//静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", home);
        map.put("logoInfo", logo);
        map.put("menuInfo", TreeUtil.toTree(menulist, 0L));
        return map;
    }

    @Override
    public Map<String, Object> menuList() {
        List<MenuVo> data = sysMenuMapper.menuList();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", data.size());
        map.put("data", data);
        return map;
    }

    @Override
    public Map<String, Object> menuTree() {
        Map<String, Object> map = new LinkedHashMap<>();
        List<MenuVo> menuList = sysMenuMapper.menuList();
        List<Dtree> menuInfo = new ArrayList<>();
        for (MenuVo e : menuList) {
            Dtree dtree = new Dtree();
            if (e.getTitle().equals("菜单管理")) {
                continue;
            }
            dtree.setId(Long.parseLong(e.getId() + ""));
            dtree.setParentId(Long.parseLong(e.getPid() + ""));
            dtree.setTitle(e.getTitle() + "");
            boolean b = true;
            for (int i = 0; i < menuList.size(); i++) {
                MenuVo mjb = menuList.get(i);
                if (e.getId().equals(mjb.getPid()) || e.getPid().equals(0)) {
                    b = false;
                    dtree.setLast(b);
                    break;
                }
                dtree.setLast(b);
            }
            menuInfo.add(dtree);
        }
        Map<String, Object> status = new HashMap<>();
        status.put("code", 200);
        status.put("message", "操作成功");
        map.put("status", status);
        map.put("data", DtreeUtil.toTree(menuInfo, 0L));
        return map;
    }

    @Override
    public String insert(MenuVo menu) {
        int add = sysMenuMapper.insert(menu);
        if (add > 0) {
            return "ok";
        }
        return "添加失败请重试";
    }

    @Override
    public String edit(MenuVo menu) {
        int edit = sysMenuMapper.update(menu);
        if (edit > 0) {
            return "ok";
        }
        return "提交失败请重试";
    }

    @Override
    public String delete(Integer id) {
        int childCount = sysMenuMapper.childCount(id);
        if (childCount > 0) {
            return "请先删除子菜单";
        }
        int del = sysMenuMapper.delete(id);
        if (del > 0) {
            return "ok";
        }
        return "删除失败请重试";
    }

    @Override
    public String setStatus(Integer id, Integer status) {
        int set = sysMenuMapper.setStatus(id, status);
        if (set > 0) {
            return "ok";
        }
        return "操作失败请重试";
    }
}
