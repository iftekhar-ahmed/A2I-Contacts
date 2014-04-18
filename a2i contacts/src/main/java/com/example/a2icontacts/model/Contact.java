package com.example.a2icontacts.model;

/**
 * Created by Farhan on 17/04/2014.
 */
public class Contact {

    public String getName() {
        return name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    private String name;
    private String phone_no;

    public Contact(String name, String phone_no) {
        this.name = name;
        this.phone_no = phone_no;
    }

}
