package com.example.a2icontacts.helper;

import android.content.Context;
import com.example.a2icontacts.model.A2IContact;
import com.example.a2icontacts.model.Contact;
import com.example.a2icontacts.model.SubTeam;
import com.example.a2icontacts.model.Team;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mukla on 4/22/14.
 */
public class DbManager{
    static private DbManager instance;

        static public void init(Context ctx) {
            if (null==instance) {
                instance = new DbManager(ctx);
            }
        }

        static public DbManager getInstance() {
            return instance;
        }

        private DbHelper helper;
        private DbManager(Context ctx) {
            helper = new DbHelper(ctx);
        }

        private DbHelper getHelper() {
            return helper;
        }

        public List<Contact> getAllContacts() {
            List<Contact> contactList = null;
            try {
                contactList = getHelper().getContactDao().queryForAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return contactList;
        }

        public Contact getContactWithMobile(String donorMobile){
            Contact contact = null;
            try {
                contact = getHelper().getContactDao().queryForId(donorMobile);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return contact;
        }

        public void addContact(Contact contact) {
            try {
                getHelper().getContactDao().create(contact);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateDonor(Contact contact) {
            try {
                getHelper().getContactDao().update(contact);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public void addA2IContact(A2IContact a2iContact) {
        try {
            getHelper().getA2IContactDao().create(a2iContact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<A2IContact> getAllA2IContacts() {
        List<A2IContact> a2iContactList = null;
        try {
            a2iContactList = getHelper().getA2IContactDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a2iContactList;
    }


    public void addSubTeam(SubTeam subTeam) {
        try {
            getHelper().getSubTeamDao().create(subTeam);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SubTeam> getAllSubTeams() {
        List<SubTeam> subTeamList = null;
        try {
            subTeamList = getHelper().getSubTeamDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subTeamList;
    }

    public void addTeam(Team team) {
        try {
            getHelper().getTeamDao().create(team);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Team> getAllTeams() {
        List<Team> teamList = null;
        try {
            teamList = getHelper().getTeamDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }
}
