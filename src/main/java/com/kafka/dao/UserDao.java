package com.kafka.dao;

import com.kafka.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);
}