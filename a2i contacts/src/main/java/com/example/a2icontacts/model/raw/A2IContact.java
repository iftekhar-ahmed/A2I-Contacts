package com.example.a2icontacts.model.raw;

/**
 * Created by mukla on 4/24/14.
 */
public class A2IContact {
    private String mobile;
    private String name;
    private String email;

    public A2IContact(String mobile, String name, String email) {
        this.mobile = mobile;
        this.name = name;
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
