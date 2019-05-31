package com.example.nhom1;

import java.io.Serializable;

public class Session implements Serializable {
    private int Ses_id;
    private String Ses_Time;
    private String Ses_Title;
    private int Ses_addSes;
    public Session(){

    }

    public Session(int ses_id, String ses_Time, String ses_Title, int ses_addSes) {
        Ses_id = ses_id;
        Ses_Time = ses_Time;
        Ses_Title = ses_Title;
        Ses_addSes = ses_addSes;

    }

    public Session(String ses_Time, String ses_Title, int ses_addSes) {
        Ses_Time = ses_Time;
        Ses_Title = ses_Title;
        Ses_addSes = ses_addSes;
    }

    public int getSes_id() {
        return Ses_id;
    }

    public void setSes_id(int ses_id) {
        Ses_id = ses_id;
    }

    public String getSes_Time() {
        return Ses_Time;
    }

    public void setSes_Time(String ses_Time) {
        Ses_Time = ses_Time;
    }

    public String getSes_Title() {
        return Ses_Title;
    }

    public void setSes_Title(String ses_Title) {
        Ses_Title = ses_Title;
    }

    public int getSes_addSes() {
        return Ses_addSes;
    }

    public void setSes_addSes(int ses_addSes) {
        Ses_addSes = ses_addSes;
    }
}
