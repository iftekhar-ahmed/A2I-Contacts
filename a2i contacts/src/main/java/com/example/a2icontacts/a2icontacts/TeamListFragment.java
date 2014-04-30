package com.example.a2icontacts.a2icontacts;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a2icontacts.adapter.TeamListAdapter;
import com.example.a2icontacts.dao.ContactsAccessor;
import com.example.a2icontacts.model.raw.A2ITeam;

import java.util.List;

public class TeamListFragment extends ListFragment {

    private TeamListAdapter teamListAdapter;
    private List<A2ITeam> teams;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teams = ContactsAccessor.getA2ITeams();
        teamListAdapter = new TeamListAdapter(getActivity(), R.layout.list_item_teams, teams);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setListAdapter(teamListAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String teamName = ((TextView) v.findViewById(R.id.textView_team_name)).getText().toString();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.root_fragment, new ContactsListFragment());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
