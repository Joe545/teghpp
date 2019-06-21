package com.teghpp;

public class User {
    public String group, email, phone;

    public User() {
    }

    public User(String email, String group, String phone) {
        this.email = email;
        this.group = group;
        this.phone = phone;
    }
}
