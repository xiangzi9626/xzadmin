package com.example.xzadmin.mapper;

import com.example.xzadmin.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where level<#{level} limit #{page},#{pagesize}")
    List<User> adminList(Integer level, Integer page, Integer pagesize);

    @Select("select * from user where level=#{level} limit #{page},#{pagesize}")
    List<User> userList(Integer level, Integer page, Integer pagesize);

    @Select("select * from user where id=#{id}")
    User getone(Integer id);

    @Select("select * from user where (username=#{username} or phone=#{phone}) and password=#{password}")
    User login(String username, String phone, String password);

    @Select("select count(*) from user where id!=#{id} and username=#{username}")
    int excludeUsername(Integer id, String username);

    @Select("select count(*) from user where id!=#{id} and phone=#{phone}")
    int excludePhone(Integer id, String phone);

    @Select("select count(*) from user where username=#{username}")
    int usernameCount(String username);

    @Select("select count(*) from user where phone=#{phone}")
    int phoneCount(String phone);

    @Select("select count(*) from user where level<#{level}")
    int adminCount(Integer level);

    @Select("select count(*) from user where level=#{level}")
    int userCount(Integer level);

    @Delete("delete from user where id=#{id}")
    int delete(Integer id);

    @Insert("insert into user(username,password,phone,level,create_time) values(#{username},#{password},#{phone},#{level},#{create_time})")
    int insert(User user);

    @Update("update user set username=#{username},password=#{password},phone=#{phone} where id=#{id}")
    int update(User user);

    @Update("update user set password=#{password} where id=#{id}")
    int updatePassword(Integer id, String password);
}