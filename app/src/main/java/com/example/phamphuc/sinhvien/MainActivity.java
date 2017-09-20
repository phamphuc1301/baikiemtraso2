package com.example.phamphuc.sinhvien;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.phamphuc.sinhvien.Database.Method;
import com.example.phamphuc.sinhvien.Database.connect;
import com.example.phamphuc.sinhvien.Database.DatabaseOpenHelper;
import com.example.phamphuc.sinhvien.Model.tt_Sinhvien;

public class MainActivity extends AppCompatActivity {
    EditText ten, sdt;
    RadioButton nam, nu;
    CheckBox cahat, thethao, hdk;
    Button them, xem;
    tt_Sinhvien sinhvien;
    Method method;
    connect cc;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ten = (EditText) findViewById(R.id.ten);
        sdt = (EditText) findViewById(R.id.sdt);
        nam = (RadioButton) findViewById(R.id.nam);
        nu = (RadioButton) findViewById(R.id.nu);
        cahat = (CheckBox) findViewById(R.id.cahat);
        thethao = (CheckBox) findViewById(R.id.thethao);
        hdk = (CheckBox) findViewById(R.id.hdk);
        them = (Button) findViewById(R.id.them);
        xem = (Button) findViewById(R.id.xem);
        cc= new connect(this);

        DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(this);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = cc.open();
                sinhvien = new tt_Sinhvien();
                String sothich = "";
                sinhvien.setTen(ten.getText().toString());
                sinhvien.setSdt(sdt.getText().toString());
                if (nam.isChecked()) {
                    sinhvien.setGioitinh("Nam");
                } else sinhvien.setGioitinh("Nữ");
                if (cahat.isChecked()) {
                    sothich += "Ca hát, ";
                }
                if (thethao.isChecked()) {
                    sothich += "Thể thao, ";
                }
                if (hdk.isChecked()) {
                    sothich += "Hoạt động khác";
                }
                sinhvien.setSothich(sothich);
                method = new Method();
                long kt = method.add(sinhvien,database);

                Toast.makeText(getApplicationContext(), "Them thanh cong "+String.valueOf(kt) ,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
                ten.setText("");
                sdt.setText("");
            }
        });
        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),Show_activity.class);
                startActivity(a);

            }
        });
    }

}
