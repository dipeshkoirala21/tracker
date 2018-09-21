package com.example.dipes.zeronetracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    String BASE_URL="http://103.213.31.238/tracker_backend/public/api/v1/student/";

    @GET("all?")
    Call<List<APIData>> getJsons();

    @GET("all?")
    Call<APIData> gethistorydetails(@Query("student_id") String student_id, @Query("date") String date);


}
