package com.example.a2icontacts.a2icontacts;

/**
 * Created by Farhan on 24/04/2014.
 */
public interface ContactsEvent {
    void onCall(String phoneNo);
    void onMessage(String phoneNo);
    void onEmail(String email);
}
