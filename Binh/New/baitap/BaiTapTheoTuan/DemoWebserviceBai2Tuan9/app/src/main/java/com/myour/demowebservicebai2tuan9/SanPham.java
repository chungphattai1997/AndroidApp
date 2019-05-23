package com.myour.demowebservicebai2tuan9;

public class SanPham {
    private String masp;
    private String tensp;
    private String HinhAnh;

    public SanPham(String masp, String tensp, String hinhAnh) {
        this.masp = masp;
        this.tensp = tensp;
        this.HinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "masp"+masp+"/n tensp"+tensp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.HinhAnh = hinhAnh;
    }
}
