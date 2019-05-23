package com.example.ql_ddh_baocaogk;

public class KhachHang {
    private String ma, ten;

    public KhachHang(){

    }

    public KhachHang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }


    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
