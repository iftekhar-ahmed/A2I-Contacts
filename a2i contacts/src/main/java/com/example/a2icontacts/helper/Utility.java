package com.example.a2icontacts.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by mukla on 4/24/14.
 */
public class Utility {
    private static final String IS_DB_CREATED = "isDbCreated";
    public static void storeDbOperation(Context activity){
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_DB_CREATED, true);
        editor.commit();
    }
    public static boolean isDbCreated(Context activity){
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        return preferences.getBoolean(IS_DB_CREATED, false);
    }

}
