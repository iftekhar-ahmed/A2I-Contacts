package com.example.a2icontacts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a2icontacts.a2icontacts.R;
import com.example.a2icontacts.model.raw.A2ITeam;

import java.util.List;

/**
 * Created by Farhan on 24/04/2014.
 */
public class TeamListAdapter extends ArrayAdapter<A2ITeam> {

    private Context context;
    private int layoutResourceID;

    public TeamListAdapter(Context context, int resource, List<A2ITeam> objects) {
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
        TextView textViewTeamName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        A2ITeam a2ITeam = getItem(position);

        View inflatedView = LayoutInflater.from(context).inflate(layoutResourceID, parent, false);
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflatedView;
            holder = new ViewHolder();
            holder.textViewTeamName = (TextView) convertView.findViewById(R.id.textView_team_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewTeamName.setText(a2ITeam.get_name());

        return convertView;
    }
}
