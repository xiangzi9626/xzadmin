package com.example.xzadmin.service.impl;

import com.example.xzadmin.bean.Class;
import com.example.xzadmin.bean.Dtree;
import com.example.xzadmin.mapper.ArticleMapper;
import com.example.xzadmin.mapper.ClassMapper;
import com.example.xzadmin.service.ClassService;
import com.example.xzadmin.util.DtreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Map<String, Object> list() {
        List<Class> data = classMapper.list();
        int count = classMapper.count();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", count);
        map.put("data", data);
        return map;
    }

    @Override
    public Map<String, Object> dtree() {
        Map<String, Object> map = new LinkedHashMap<>();
        List<Class> list = classMapper.list();
        List<Dtree> menuInfo = new ArrayList<>();
        for (Class c : list) {
            Dtree dtree = new Dtree();
            dtree.setId(Long.parseLong(c.getId() + ""));
            dtree.setParentId(Long.parseLong(c.getPid() + ""));
            dtree.setTitle(c.getTitle() + "");
            boolean b = true;
            for (int i = 0; i < list.size(); i++) {
                Class mjb = list.get(i);
                if (c.getId().equals(mjb.getPid()) || c.getPid().equals(0)) {
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
    public String add(Class c) {
        int add = classMapper.insert(c);
        if (add > 0) {
            return "ok";
        }
        return "添加失败请重试";
    }

    @Override
    public String edit(Class c) {
        int up = classMapper.update(c);
        if (up > 0) {
            return "ok";
        }
        return "提交失败请重试";
    }

    @Override
    public String delete(Integer id) {
        int childCount = classMapper.childCount(id);
        if (childCount > 0) {
            return "请先删除子分类";
        }
        int articleClassCount = articleMapper.getClassCount(id);
        if (articleClassCount > 0) {
            return "该分类下有内容不能删除";
        }
        int delete = classMapper.delete(id);
        if (delete > 0) {
            return "ok";
        }
        return "删除失败请重试";
    }

    @Override
    public Map<String, Object> getone(Integer id) {
        Class c1 = classMapper.getone(id);
        Integer pid = c1.getPid();
        String p_name = "顶级分类";
        if (pid != 0) {
            Class c2 = classMapper.getone(pid);
            p_name = c2.getTitle();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", c1.getId());
        map.put("pid", c1.getPid());
        map.put("title", c1.getTitle());
        map.put("p_name", p_name);
        return map;
    }
}
