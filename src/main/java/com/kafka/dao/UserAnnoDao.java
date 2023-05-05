package com.kafka.dao;

import com.kafka.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserAnnoDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user values(null, #{username}, #{age}, #{address})")
    void insertUser(User user);

    @Update("update user set age = #{age}, username = #{username}, address = #{address} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);
}
