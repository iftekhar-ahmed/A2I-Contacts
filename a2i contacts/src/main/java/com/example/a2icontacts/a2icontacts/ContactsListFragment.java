package com.example.a2icontacts.a2icontacts;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.a2icontacts.adapter.ContactsAdapter;
import com.example.a2icontacts.dao.ContactsAccessor;
import com.example.a2icontacts.model.Contact;

import java.util.List;

public class ContactsListFragment extends ListFragment implements AdapterView.OnItemSelectedListener, ContactsEvent {

    private ContactsAdapter contactsAdapter;
    private List<Contact> contacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contacts = ContactsAccessor.getAllContacts();
        contactsAdapter = new ContactsAdapter(getActivity(), R.layout.list_item_contacts, contacts, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setListAdapter(contactsAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i(this.getTag(), "list item tapped");
        Toast.makeText(getActivity(), "You have selected " + contacts.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCall(String phoneNo) {

    }

    @Override
    public void onMessage(String phoneNo) {

    }

    @Override
    public void onEmail(String email) {

    }
}
