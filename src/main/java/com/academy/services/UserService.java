package com.academy.services;

import com.academy.dao.UserDao;
import com.academy.entities.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;
    private static UserService singleton;

    private UserService() {
        userDao = UserDao.getInstance();
    }

    public static UserService getInstance() {
        if (singleton == null) {
            singleton = new UserService();
        }
        return singleton;
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public boolean checkLoginPassword(String login, String password) {
        return userDao.getUsers()
                .stream()
                .anyMatch(x -> x.getLogin().equals(login) && x.getPassword().equals(password));
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public void addUser(String firstName, String lastName, int age, String login, String password) {
        userDao.addUser(firstName, lastName, age, login, password);
    }
}
