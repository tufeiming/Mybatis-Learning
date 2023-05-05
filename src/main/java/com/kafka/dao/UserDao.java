package com.kafka.dao;

import com.kafka.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);

    User findByUser(User user);

    User findByMap(Map<String, Object> map);

    List<User> findByCondition(@Param("id") Integer id, @Param("username") String username);

    List<User> findByIds(@Param("ids") Integer[] ids);

    List<User> selectChoose(User user);

    void insertUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}