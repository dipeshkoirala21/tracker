package com.example.dipes.zeronetracker;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("student_id")
    @Expose
    private String studentId;
    @SerializedName("route_id")
    @Expose
    private Integer routeId;
    @SerializedName("station_id")
    @Expose
    private Integer stationId;
    @SerializedName("token")
    @Expose
    private Object token;
    @SerializedName("studentCheckinCheckout")
    @Expose
    private List<StudentCheckinCheckout> studentCheckinCheckout = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public List<StudentCheckinCheckout> getStudentCheckinCheckout() {
        return studentCheckinCheckout;
    }

    public void setStudentCheckinCheckout(List<StudentCheckinCheckout> studentCheckinCheckout) {
        this.studentCheckinCheckout = studentCheckinCheckout;
    }

}