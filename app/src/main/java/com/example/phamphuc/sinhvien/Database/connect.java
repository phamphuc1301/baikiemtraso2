package com.example.phamphuc.sinhvien.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.phamphuc.sinhvien.Model.tt_Sinhvien;

/**
 * Created by phamphuc on 9/19/17.
 */

public class connect {
    SQLiteDatabase database;
    DatabaseOpenHelper databaseOpenHelper;
    public  connect (Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
    }
    public SQLiteDatabase open(){
        database = databaseOpenHelper.getWritableDatabase();
        return database;
    }
    public void close(){
        databaseOpenHelper.close();
    }
}
