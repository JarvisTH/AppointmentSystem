package com.jarvis.model;

public class Register {
    private int id;
    private int patient_id;
    private int keShi_id;
    private int dr_id;
    private String keshi_name;
    private String dr_name;
    private int room_num;
    private String detail_time;

    public int getRoom_num() {
        return room_num;
    }

    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }

    public String getDetail_time() {
        return detail_time;
    }

    public void setDetail_time(String detail_time) {
        this.detail_time = detail_time;
    }

    public String getKeshi_name() {
        return keshi_name;
    }

    public void setKeshi_name(String keshi_name) {
        this.keshi_name = keshi_name;
    }

    public String getDr_name() {
        return dr_name;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getKeShi_id() {
        return keShi_id;
    }

    public void setKeShi_id(int keShi_id) {
        this.keShi_id = keShi_id;
    }

    public int getDr_id() {
        return dr_id;
    }

    public void setDr_id(int dr_id) {
        this.dr_id = dr_id;
    }
}
