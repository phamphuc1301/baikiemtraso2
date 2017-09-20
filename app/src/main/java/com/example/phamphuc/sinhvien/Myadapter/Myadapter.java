package com.example.phamphuc.sinhvien.Myadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.phamphuc.sinhvien.Model.tt_Sinhvien;
import com.example.phamphuc.sinhvien.R;

import java.util.ArrayList;

/**
 * Created by phamphuc on 9/20/17.
 */

public class Myadapter extends ArrayAdapter {
    TextView sdtlv,tenlv,gt;
    Activity activity;
    int resource;
    ArrayList<tt_Sinhvien> objects;
    public Myadapter(@NonNull Activity activity, @LayoutRes int resource, @NonNull ArrayList<tt_Sinhvien> objects) {
        super(activity, resource, objects);
        this.activity=activity;
        this.resource=resource;
        this.objects= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View v = inflater.inflate(this.resource,null);
        tenlv = v.findViewById(R.id.tenlv);
        sdtlv = v.findViewById(R.id.sdtlv);
        gt= v.findViewById(R.id.gtlv);
        tt_Sinhvien data= this.objects.get(position);
        tenlv.setText(data.getTen().toString());
        sdtlv.setText(data.getSdt().toString());
        gt.setText(data.getGioitinh().toString());
        return v;
    }
}
