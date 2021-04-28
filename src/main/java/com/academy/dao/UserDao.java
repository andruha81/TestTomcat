package com.academy.dao;

import com.academy.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final List<User> users = new ArrayList<>();
    private static UserDao singleton;

    private UserDao() {
        users.add(new User("Andrei", "Khaustau", 39, "andruha", "a123"));
        users.add(new User("Misha", "Stepovikov", 31, "misha", "m123"));
        users.add(new User("Dima", "Danilov", 40, "dima", "d123"));
        users.add(new User("Sasha", "Fatykhov", 47, "sasha", "s123"));
    }

    public static UserDao getInstance() {
        if (singleton == null) {
            singleton = new UserDao();
        }
        return singleton;
    }

    public List<User> getUsers() {
        return users;
    }
}
