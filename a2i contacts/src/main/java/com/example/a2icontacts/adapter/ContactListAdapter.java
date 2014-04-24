package com.example.a2icontacts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a2icontacts.a2icontacts.ContactsEvent;
import com.example.a2icontacts.a2icontacts.R;
import com.example.a2icontacts.model.raw.A2IContact;

import java.util.List;

/**
 * Created by Farhan on 17/04/2014.
 */
public class ContactListAdapter extends ArrayAdapter<A2IContact> {

    private Context context;
    private int layoutResourceID;
    private ContactsEvent contactsEvent;

    public ContactListAdapter(Context context, int resource, List<A2IContact> objects, ContactsEvent event) {
        super(context, resource, objects);
        this.context = context;
        layoutResourceID = resource;
        contactsEvent = event;
    }

    @Override
    public int getViewTypeCount() {
        if (getCount() != 0) {
            return getCount();
        }
        return 1;
    }

    private class ViewHolder {
        TextView textViewName;
        TextView textViewPhoneNo;
        TextView textViewEmail;
        ImageButton imgBtnMsg;
        ImageButton imgBtnCall;
        ImageButton imgBtnEmail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        A2IContact contact = getItem(position);

        View inflatedView = LayoutInflater.from(context).inflate(layoutResourceID, parent, false);
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflatedView;
            holder = new ViewHolder();
            holder.textViewName = (TextView) convertView.findViewById(R.id.textview_contact_name);
            holder.textViewPhoneNo = (TextView) convertView.findViewById(R.id.textView_contact_no);
            holder.textViewEmail = (TextView) convertView.findViewById(R.id.textView_email);
            holder.imgBtnCall = (ImageButton) convertView.findViewById(R.id.imageButton_call_contact);
            holder.imgBtnMsg = (ImageButton) convertView.findViewById(R.id.imageButton_msg_contact);
            holder.imgBtnEmail = (ImageButton) convertView.findViewById(R.id.imageButton_email_contact);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewName.setText(contact.getName());
        holder.textViewPhoneNo.setText(contact.getMobile());
        holder.textViewEmail.setText(contact.getEmail());

        final ViewHolder finalViewHolder = holder;

        finalViewHolder.imgBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsEvent.onCall(finalViewHolder.textViewPhoneNo.getText().toString());
            }
        });
        finalViewHolder.imgBtnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsEvent.onMessage(finalViewHolder.textViewPhoneNo.getText().toString());
            }
        });
        finalViewHolder.imgBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsEvent.onEmail(finalViewHolder.textViewEmail.getText().toString());
            }
        });

        return convertView;
    }
}
