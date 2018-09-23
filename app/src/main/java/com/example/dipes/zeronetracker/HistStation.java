package com.example.dipes.zeronetracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistStation extends APIData {

    @SerializedName("hid")
    @Expose
    private Integer id;
    @SerializedName("day_configure_id")
    @Expose
    private Integer dayConfigureId;
    @SerializedName("hstation_id")
    @Expose
    private Integer stationId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("time")
    @Expose
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer hid) {
        this.id= id;
    }

    public Integer getDayConfigureId() {
        return dayConfigureId;
    }

    public void setDayConfigureId(Integer dayConfigureId) {
        this.dayConfigureId = dayConfigureId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
