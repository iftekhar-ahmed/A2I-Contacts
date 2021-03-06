package com.example.a2icontacts.a2icontacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.a2icontacts.adapter.ContactListAdapter;
import com.example.a2icontacts.dao.ContactsAccessor;
import com.example.a2icontacts.model.raw.A2IContact;

import java.util.ArrayList;
import java.util.List;

public class ContactsListFragment extends ListFragment implements ContactsEvent {

    private ContactListAdapter contactsAdapter;
    private List<A2IContact> contacts;
    private List<A2IContact> contactsGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contacts = ContactsAccessor.geta2iContacts();
        contactsAdapter = new ContactListAdapter(getActivity(), R.layout.list_item_contacts, contacts, this);
        contactsGroup = new ArrayList<A2IContact>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setListAdapter(contactsAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                A2IContact contact = (A2IContact) getListAdapter().getItem(position);
                if (checked) {
                    contactsGroup.add(contact);
                } else {
                    contactsGroup.remove(contact);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.cab_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_group_sms:
                        List<String> phones = new ArrayList<String>();
                        for (A2IContact contact : contactsGroup) {
                            phones.add(contact.getMobile());
                        }
                        onMessage(phones.toArray(new String[]{}));
                        break;
                    case R.id.action_group_email:
                        List<String> emails = new ArrayList<String>();
                        for (A2IContact contact : contactsGroup) {
                            emails.add(contact.getEmail());
                        }
                        onEmail(emails.toArray(new String[]{}));
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    @Override
    public void onCall(String phoneNo) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNo));
        getActivity().startActivity(intent);
    }

    @Override
    public void onMessage(String... phoneNo) {
        StringBuilder sb = new StringBuilder();
        for (String phone : phoneNo) {
            sb.append(phone);
            sb.append(";");
        }
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("address", sb.toString());
        sendIntent.putExtra("sms_body", "");
        sendIntent.setType("vnd.android-dir/mms-sms");
        getActivity().startActivity(sendIntent);
    }

    @Override
    public void onEmail(String... email) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(intent, ""));
    }
}
