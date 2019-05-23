package com.example.baitap4;

public class Music {
    private int avatar;
    private String name;
    private String singer;
    private String time;
    private int arrow;

    public Music(int avatar, String name, String singer, String time, int arrow) {
        super();
        this.avatar = avatar;
        this.name = name;
        this.singer = singer;
        this.time = time;
        this.arrow = arrow;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
