package com.example.xzadmin.mapper;

import com.example.xzadmin.bean.MenuVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    @Select("select * from system_menu where id=#{id}")
    MenuVo selectOne(Integer id);

    @Select("select count(*) from system_menu where pid=#{pid}")
    int childCount(Integer pid);

    @Select("select * from system_menu where status=#{status}")
    List<MenuVo> menuLeft(int status);

    @Select("select * from system_menu")
    List<MenuVo> menuList();

    @Insert("insert into system_menu(pid,href,title,icon,target,sort,status) values(#{pid},#{href},#{title},#{icon},#{target},#{sort},#{status})")
    int insert(MenuVo menu);

    @Delete("delete from system_menu where id=#{id}")
    int delete(Integer id);

    @Update("update system_menu set href=#{href},title=#{title},icon=#{icon},target=#{target},sort=#{sort} where id=#{id}")
    int update(MenuVo menu);

    @Update("update system_menu set status=#{status} where id=#{id}")
    int setStatus(Integer id, Integer status);
}