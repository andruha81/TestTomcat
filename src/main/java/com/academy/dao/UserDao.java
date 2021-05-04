package com.academy.dao;

import com.academy.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final List<User> users = new ArrayList<>();
    private static UserDao singleton;

    private UserDao() {
        users.add(new User(1, "Andrei", "Khaustau", 39, "andruha", "a123"));
        users.add(new User(2, "Misha", "Stepovikov", 31, "misha", "m123"));
        users.add(new User(3, "Dima", "Danilov", 40, "dima", "d123"));
        users.add(new User(4, "Sasha", "Fatykhov", 47, "sasha", "s123"));
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

    public void deleteUserById(int id) {
        users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .ifPresent(users::remove);
    }

    public void addUser(String firstName, String lastName, int age, String login, String password) {
        int lastId = users.stream()
                .mapToInt(User::getId)
                .max().orElse(0);
        users.add(new User(lastId + 1, firstName, lastName, age, login, password));
    }
}
