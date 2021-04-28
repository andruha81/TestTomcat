package com.academy.services;

import com.academy.dao.UserDao;
import com.academy.entities.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = UserDao.getInstance();

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public boolean checkLoginPassword(String login, String password) {
        return userDao.getUsers()
                .stream()
                .anyMatch(x -> x.getLogin().equals(login) && x.getPassword().equals(password));
    }
}
