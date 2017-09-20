package com.example.phamphuc.sinhvien.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phamphuc.sinhvien.Model.tt_Sinhvien;

import java.util.ArrayList;

/**
 * Created by phamphuc on 9/19/17.
 */
public class Method {
    SQLiteDatabase database;
    public long add(tt_Sinhvien sinhvien,SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseOpenHelper.NAME,sinhvien.getTen().toString());
        contentValues.put(DatabaseOpenHelper.SDT,sinhvien.getSdt().toString());
        contentValues.put(DatabaseOpenHelper.GIOITINH,sinhvien.getGioitinh().toString());
        contentValues.put(DatabaseOpenHelper.SOTHICH,sinhvien.getSothich().toString());
        long kt = database.insert(DatabaseOpenHelper.TABLE_NAME,DatabaseOpenHelper.ID,contentValues);
        return kt;
    }
    public ArrayList<tt_Sinhvien> hienthi(SQLiteDatabase database){
        String sql = "SELECT * FROM "+DatabaseOpenHelper.TABLE_NAME;
        Cursor data = database.rawQuery(sql,null);

        ArrayList<tt_Sinhvien> datasv= new ArrayList<>();
        while (data.moveToNext()){
            tt_Sinhvien sinhvien = new tt_Sinhvien();
            sinhvien.set_id(data.getInt(0));
            sinhvien.setTen(data.getString(1));
            sinhvien.setSdt(data.getString(2));
            sinhvien.setGioitinh(data.getString(3));
            sinhvien.setSothich(data.getString(4));
            datasv.add(sinhvien);
            }
            return datasv;

    }
    public void xoa(SQLiteDatabase database,int position){
        String drop = "DELETE FROM tt_sinhvien where _id = "+position;
        database.execSQL(drop);
    }
}
