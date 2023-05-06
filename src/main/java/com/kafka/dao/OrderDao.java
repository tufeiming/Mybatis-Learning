package com.kafka.dao;

import com.kafka.pojo.Order;
import com.kafka.pojo.User;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();

    Order findById(Integer id);
}
