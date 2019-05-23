package com.example.batap3;

public class FootballLegend {
    private String name;
    private String born;
    private int avatar;
    private int flag;

    public FootballLegend(String name, String born, int avatar, int flag) {
        super();
        this.name = name;
        this.born = born;
        this.avatar = avatar;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
