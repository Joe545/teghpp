package com.teghpp;

public class User {
    public String group, email, phone;

    public User() {
    }

    public User(String group, String email, String phone) {
        this.email = email;
        this.group = group;
        this.phone = phone;
    }
}
