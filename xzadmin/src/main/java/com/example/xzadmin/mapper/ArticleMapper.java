package com.example.xzadmin.mapper;

import com.example.xzadmin.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    @Select("select article.*,class.title as class_name from article left join class on article.cid=class.id order by id desc limit #{page},#{pagesize}")
    List<Map<String, Object>> list(int page, int pagesize);

    @Update("update article set status=#{status} where id=#{id}")
    int setStatus(int id, int status);

    @Update("update article set cid=#{cid},title=#{title},content=#{content} where id=#{id}")
    int update(Article article);

    @Insert("insert into article(cid,title,content,status,create_time) values(#{cid},#{title},#{content},#{status},#{createTime})")
    int insert(Article article);

    @Delete("delete from article where id=#{id}")
    int delete(int id);

    @Select("select count(*) from article")
    int count();

    @Select("select article.*,class.title as class_name from article left join class on article.cid=class.id where article.id=#{id}")
    Map<String, Object> getone(int id);

    @Select("select count(*) from article where cid=#{cid}")
    int getClassCount(int cid);
}
