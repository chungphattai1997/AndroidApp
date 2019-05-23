package com.moon.baitapmautuan6;

public class MonHoc {
    private  int imgMonHoc;
    private String sTen;
    private String sMaMH;
    private String iSoTiet;

    public MonHoc(int imgMonHoc, String sTen, String sMaMH, String iSoTiet) {
        this.imgMonHoc = imgMonHoc;
        this.sTen = sTen;
        this.sMaMH = sMaMH;
        this.iSoTiet = iSoTiet;
    }

    public MonHoc() {
    }

    public int getImgMonHoc() {
        return imgMonHoc;
    }

    public void setImgMonHoc(int imgMonHoc) {
        this.imgMonHoc = imgMonHoc;
    }

    public String getsTen() {
        return sTen;
    }

    public void setsTen(String sTen) {
        this.sTen = sTen;
    }

    public String getsMaMH() {
        return sMaMH;
    }

    public void setsMaMH(String sMaMH) {
        this.sMaMH = sMaMH;
    }

    public String getiSoTiet() {
        return iSoTiet;
    }

    public void setiSoTiet(String iSoTiet) {
        this.iSoTiet = iSoTiet;
    }
}
