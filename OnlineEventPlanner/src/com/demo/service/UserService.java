package com.demo.service;

import com.demo.model.User;

import java.util.List;

public interface UserService {
    User findById(long userId);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(long userId);
}
