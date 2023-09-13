package com.demo.dao;

import com.demo.model.User;

import java.util.List;

public interface UserDAO {
    User findById(long userId);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(long userId);
}
