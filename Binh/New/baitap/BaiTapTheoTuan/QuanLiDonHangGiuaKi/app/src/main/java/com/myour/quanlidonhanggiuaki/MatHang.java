package com.myour.quanlidonhanggiuaki;

import org.w3c.dom.Text;

public class MatHang {
    private String maHG;
    private String tenHG;
    private String dacDiem;
    private String dvt;
    private int donGia;

    public MatHang(String maHG, String tenHG, String dacDiem, String dvt, int donGia) {
        this.maHG = maHG;
        this.tenHG = tenHG;
        this.dacDiem = dacDiem;
        this.dvt = dvt;
        this.donGia = donGia;
    }

    public MatHang() {
    }

    public String getMaHG() {
        return maHG;
    }

    public void setMaHG(String maHG) {
        this.maHG = maHG;
    }

    public String getTenHG() {
        return tenHG;
    }

    public void setTenHG(String tenHG) {
        this.tenHG = tenHG;
    }

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
