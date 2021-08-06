package com.example.xzadmin.mapper;

import com.example.xzadmin.bean.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("select * from class order by id desc")
    List<Class> list();

    @Select("select count(*) from class where pid=#{pid}")
    int childCount(Integer pid);

    @Select("select * from class where id=#{id}")
    Class getone(Integer id);

    @Select("select count(*) from class")
    int count();

    @Insert("insert into class(pid,title) values(#{pid},#{title})")
    int insert(Class c);

    @Update("update class set pid=#{pid},title=#{title} where id=#{id}")
    int update(Class c);

    @Delete("delete from class where id=#{id}")
    int delete(Integer id);
}