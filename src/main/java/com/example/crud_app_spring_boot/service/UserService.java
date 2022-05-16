package com.example.crud_app_spring_boot.service;

import com.example.crud_app_spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void save(User user);
    User getById(int id);
    void deleteById(int id);
}
