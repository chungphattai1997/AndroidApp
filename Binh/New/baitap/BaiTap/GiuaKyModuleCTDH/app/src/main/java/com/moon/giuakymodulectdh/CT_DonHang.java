package com.moon.giuakymodulectdh;

public class CT_DonHang {
    private Integer SODDH;
    private String MAHG;
    private Integer SLDAT;

    public CT_DonHang(Integer SODDH, String MAHG, Integer SLDAT) {
        this.SODDH = SODDH;
        this.MAHG = MAHG;
        this.SLDAT = SLDAT;
    }

    public CT_DonHang() {
    }

    public Integer getSODDH() {
        return SODDH;
    }

    public void setSODDH(Integer SODDH) {
        this.SODDH = SODDH;
    }

    public String getMAHG() {
        return MAHG;
    }

    public void setMAHG(String MAHG) {
        this.MAHG = MAHG;
    }

    public Integer getSLDAT() {
        return SLDAT;
    }

    public void setSLDAT(Integer SLDAT) {
        this.SLDAT = SLDAT;
    }
}
