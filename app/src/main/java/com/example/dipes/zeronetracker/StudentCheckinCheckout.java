package com.example.dipes.zeronetracker;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentCheckinCheckout extends APIData {

    @SerializedName("sid")
    @Expose
    private Integer id;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("check_in")
    @Expose
    private String checkIn;
    @SerializedName("check_out")
    @Expose
    private String checkOut;
    @SerializedName("reach_home")
    @Expose
    private String reachHome;
    @SerializedName("bus_coming")
    @Expose
    private String busComing;
    @SerializedName("reach_school")
    @Expose
    private String reachSchool;
    @SerializedName("hist_station")
    @Expose
    private List<HistStation> histStation = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer sid) {
        this.id= id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getReachHome() {
        return reachHome;
    }

    public void setReachHome(String reachHome) {
        this.reachHome = reachHome;
    }

    public String getBusComing() {
        return busComing;
    }

    public void setBusComing(String busComing) {
        this.busComing = busComing;
    }

    public String getReachSchool() {
        return reachSchool;
    }

    public void setReachSchool(String reachSchool) {
        this.reachSchool = reachSchool;
    }

    public List<HistStation> getHistStation() {
        return histStation;
    }

    public void setHistStation(List<HistStation> histStation) {
        this.histStation = histStation;
    }

}



