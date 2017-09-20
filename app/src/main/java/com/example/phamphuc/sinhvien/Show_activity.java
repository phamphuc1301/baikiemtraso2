package com.example.phamphuc.sinhvien;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phamphuc.sinhvien.Database.Method;
import com.example.phamphuc.sinhvien.Database.connect;
import com.example.phamphuc.sinhvien.Model.tt_Sinhvien;
import com.example.phamphuc.sinhvien.Myadapter.Myadapter;

import java.util.ArrayList;

public class Show_activity extends AppCompatActivity {
    Myadapter myadapter;
    ArrayList<tt_Sinhvien> sinhvien;
    ListView listView;
    Method method;
    connect cc;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activity);
        listView = (ListView) findViewById(R.id.listview);
        cc = new connect(this);
        sqLiteDatabase =cc.open();
        method = new Method();
        sinhvien = new ArrayList<>();
        sinhvien= method.hienthi(sqLiteDatabase);

        myadapter= new Myadapter(this,R.layout.lv_sinhvien,sinhvien);
        listView.setAdapter(myadapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = sinhvien.get(i).get_id();
                method.xoa(sqLiteDatabase,id);
                myadapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
