package com.example.phamphuc.sinhvien.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by phamphuc on 9/19/17.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    //thong tin database
    public static final String DATABASE_NAME ="Sinhvien";
    public static final int DATABASE_VER = 3;

    //Thong tin table
    public static final String TABLE_NAME ="tt_sinhvien";
    public static final String ID ="_id";
    public static final String NAME ="name";
    public static final String SDT ="sdt";
    public static final String GIOITINH ="gioitinh";
    public static final String SOTHICH ="sothich";


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    String sql = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                                                +NAME+" TEXT,"
                                                +SDT+" TEXT,"
                                                +GIOITINH+" TEXT,"
                                                +SOTHICH+" TEXT)";
        DB.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        String dropsql = "DROP TABLE IF exists "+TABLE_NAME;
        DB.execSQL(dropsql);
        onCreate(DB);
    }
}
