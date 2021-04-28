package com.academy.entities;

import lombok.Getter;

@Getter
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String login;
    private final String password;

    public User(String firstName, String lastName, int age, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.password = password;
    }
}
