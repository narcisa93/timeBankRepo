package com.timebank.dao;

import java.util.List;

import com.timebank.model.User;


public interface UserDao {

    void addUser (User user);
    void updateUser (User user);
    void deleteUser (int id);
    User getUser (int id);
    List getUsers();

}