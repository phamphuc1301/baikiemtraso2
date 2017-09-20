package com.example.phamphuc.sinhvien.Model;

/**
 * Created by phamphuc on 9/19/17.
 */

public class tt_Sinhvien {

    int _id;
    String ten;
    String sdt;
    String gioitinh;
    String sothich;

    public tt_Sinhvien(String ten, String sdt, String gioitinh, String sothich) {
        this.ten = ten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.sothich = sothich;
    }

    public tt_Sinhvien() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSothich() {
        return sothich;
    }

    public void setSothich(String sothich) {
        this.sothich = sothich;
    }


}
