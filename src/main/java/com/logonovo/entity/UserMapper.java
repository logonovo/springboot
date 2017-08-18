package com.logonovo.entity;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by logonovo on 2017/3/12.
 */
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(name,pwd,des,status,icon,email,createdate,phone,token) " +
            "VALUES(#{name}, #{pwd}, #{des},#{status}, #{icon}, #{email},#{createdate}, #{phone}, #{token})")
    @Results({
            @Result(property = "createdate", column = "createDate")
    })
    void insert(UserEntity user);

    @Update("UPDATE users SET name=#{name},WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
