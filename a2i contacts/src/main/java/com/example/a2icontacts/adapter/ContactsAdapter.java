package com.example.a2icontacts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.a2icontacts.a2icontacts.R;
import com.example.a2icontacts.model.Contact;

import java.util.List;

/**
 * Created by Farhan on 17/04/2014.
 */
public class ContactsAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int layoutResourceID;

    public ContactsAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        layoutResourceID = resource;
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
        QuickContactBadge qcb;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contact contact = getItem(position);

        View inflatedView = LayoutInflater.from(context).inflate(layoutResourceID, parent, false);
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflatedView;
            holder = new ViewHolder();
            holder.textViewName = (TextView) convertView.findViewById(R.id.textview_contact_name);
            holder.textViewPhoneNo = (TextView) convertView.findViewById(R.id.textView_contact_no);
            holder.qcb = (QuickContactBadge) convertView.findViewById(R.id.contact_badge);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewName.setText(contact.getName());
        holder.textViewPhoneNo.setText(contact.getPhone_no());
        holder.qcb.setBackgroundResource(R.drawable.ic_launcher);

        return convertView;
    }
}
