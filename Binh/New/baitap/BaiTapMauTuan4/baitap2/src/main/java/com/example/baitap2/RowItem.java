package com.example.baitap2;

public class RowItem {
    private int icon;
    private String title;
    private String detail;

    public RowItem(int icon, String title, String detail) {
        super();
        this.icon = icon;
        this.title = title;
        this.detail = detail;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
