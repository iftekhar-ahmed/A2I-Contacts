package com.example.a2icontacts.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.a2icontacts.model.A2IContact;
import com.example.a2icontacts.model.Contact;
import com.example.a2icontacts.model.SubTeam;
import com.example.a2icontacts.model.Team;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukla on 4/22/14.
 */
public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "ContactDb.sqlite";
    private static final int DATABASE_VERSION = 1;

    private Dao<Contact, String> contactDao = null;
    private Dao<A2IContact, String> a2iContactDao = null;
    private Dao<SubTeam, String> subTeamDao = null;
    private Dao<Team, String> teamDao = null;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Contact.class);
            TableUtils.createTable(connectionSource, A2IContact.class);
            TableUtils.createTable(connectionSource, SubTeam.class);
            TableUtils.createTable(connectionSource, Team.class);

        } catch (SQLException e) {
            Log.e(DbHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        List<String> allSql = new ArrayList<String>();
        try {
            switch(oldVersion)
            {
                case 1:
                    //allSql.add("alter table AdData add column `new_col` VARCHAR");
                    //allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql) {
                sqLiteDatabase.execSQL(sql);
            }
        }
        catch (Exception e){
            Log.e(DbHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Contact, String> getContactDao() {
        if (null == contactDao) {
            try {
                contactDao = getDao(Contact.class);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contactDao;
    }

    public Dao<A2IContact, String> getA2IContactDao() {
        if (null == a2iContactDao) {
            try {
                a2iContactDao = getDao(A2IContact.class);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return a2iContactDao;
    }

    public Dao<SubTeam, String> getSubTeamDao() {
        if (null == subTeamDao) {
            try {
                subTeamDao = getDao(SubTeam.class);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return subTeamDao;
    }

    public Dao<Team, String> getTeamDao() {
        if (null == teamDao) {
            try {
                teamDao = getDao(Team.class);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teamDao;
    }
}

