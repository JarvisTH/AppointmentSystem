package com.jarvis.model;

public class Schedule {
    private int id;
    private int dr_id;
    private String doctorName;
    private int room_num;
    private String detail_time;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDr_id() {
        return dr_id;
    }

    public void setDr_id(int dr_id) {
        this.dr_id = dr_id;
    }

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
}
