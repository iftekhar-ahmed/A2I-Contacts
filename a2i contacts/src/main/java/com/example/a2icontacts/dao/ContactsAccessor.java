package com.example.a2icontacts.dao;

import com.example.a2icontacts.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan on 17/04/2014.
 */
public final class ContactsAccessor {

    static List<Contact> allContacts = new ArrayList<Contact>();

    static {
        allContacts.add(new Contact("Iftekhar", "+880 1746511662"));
        allContacts.add(new Contact("Mukul", "+880 1746511662"));
        allContacts.add(new Contact("Sharif", "+880 1746511662"));
        allContacts.add(new Contact("Sunny", "+880 1746511662"));
        allContacts.add(new Contact("Saeed", "+880 1746511662"));
        allContacts.add(new Contact("Sujon", "+880 1746511662"));
    }

    public static List<Contact> getAllContacts() {
        return allContacts;
    }
}
