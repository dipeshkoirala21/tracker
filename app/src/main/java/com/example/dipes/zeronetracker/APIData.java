package com.example.dipes.zeronetracker;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class APIData {
    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public Integer name;
    @SerializedName("student_id")
    public Integer student_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<CheckinCheckout> getData() {
        return data;
    }

    public void setData(List<CheckinCheckout> data) {
        this.data = data;
    }

    @SerializedName("route_id")
    public Integer route_id;
    @SerializedName("token")
    private  String token;

    @SerializedName("studentCheckinCheckout")
    public List<CheckinCheckout> data = new ArrayList<>();


    public class CheckinCheckout {


        @SerializedName("id")
        public Integer id;
        @SerializedName("day")
        public String day;
        @SerializedName("check_in")
        public Integer check_in;
        @SerializedName("check_out")
        public String check_out;

        @SerializedName("reach_home")
        public String reach_home;
        @SerializedName("bus_coming")
        public String bus_coming;
        @SerializedName("reach_school")
        public String reach_school;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public Integer getCheck_in() {
            return check_in;
        }

        public void setCheck_in(Integer check_in) {
            this.check_in = check_in;
        }

        public String getCheck_out() {
            return check_out;
        }

        public void setCheck_out(String check_out) {
            this.check_out = check_out;
        }

        public String getReach_home() {
            return reach_home;
        }

        public void setReach_home(String reach_home) {
            this.reach_home = reach_home;
        }

        public String getBus_coming() {
            return bus_coming;
        }

        public void setBus_coming(String bus_coming) {
            this.bus_coming = bus_coming;
        }

        public String getReach_school() {
            return reach_school;
        }

        public void setReach_school(String reach_school) {
            this.reach_school = reach_school;
        }
    }
}

