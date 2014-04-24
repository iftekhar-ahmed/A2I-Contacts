package com.example.a2icontacts.helper;

import android.content.Context;

import com.example.a2icontacts.model.A2IContact;
import com.example.a2icontacts.model.SubTeam;
import com.example.a2icontacts.model.Team;

/**
 * Created by mukla on 4/23/14.
 */
public class DbInitializer {
    private Context context;

    public DbInitializer(Context context) {
        this.context = context;
    }

    public void insertData(String[] csvData, String textFile) {
        if (textFile.equals(TextFileName.txtFileA2IContact)) {
            for (int data = 0; data < csvData.length; data++) {
                A2IContact a2IContact = new A2IContact();
                a2IContact.setMobile(csvData[0]);
                a2IContact.setName(csvData[1]);
                a2IContact.setEmail(csvData[2]);
                a2IContact.setDesignation(csvData[3]);
                a2IContact.setSubTeamId(Long.parseLong(csvData[4]));

                DbManager.getInstance().addA2IContact(a2IContact);
            }

        } else if (textFile.equals(TextFileName.txtFileSubTeam)) {
            for (int data = 0; data < csvData.length; data++) {
                SubTeam subTeam = new SubTeam();
                subTeam.set_id(Long.parseLong(csvData[0]));
                subTeam.set_name(csvData[1]);
                subTeam.set_teamId(Long.parseLong(csvData[2]));
                DbManager.getInstance().addSubTeam(subTeam);
            }

        } else if (textFile.equals(TextFileName.txtFileTeam)) {
            for (int data = 0; data < csvData.length; data++) {
                Team team = new Team();
                team.set_id(Long.parseLong(csvData[0]));
                team.set_name(csvData[1]);
                DbManager.getInstance().addTeam(team);
            }

        }
    }

}
