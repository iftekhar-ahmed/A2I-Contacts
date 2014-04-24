package com.example.a2icontacts.helper;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mukla on 4/23/14.
 */
public class CSVReader {

    private InputStream inputStream;
    private String csvSpliteBy = ",";
    private Context context;


    public CSVReader(Context context) {
        this.context = context;
    }

    public void readAndInsertData(String textFile) {
        try {
            inputStream = context.getResources().getAssets().open(textFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            String line;

            DbInitializer dbInitializer = new DbInitializer(context);
            while ((line = reader.readLine()) != null) {
                dbInitializer.insertData(line.split(csvSpliteBy), textFile);
            }
        } catch (IOException ex) {
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }

    }

    public void insertEntities() {
        readAndInsertData(TextFileName.txtFileTeam);
        readAndInsertData(TextFileName.txtFileSubTeam);
        readAndInsertData(TextFileName.txtFileA2IContact);
    }
}
