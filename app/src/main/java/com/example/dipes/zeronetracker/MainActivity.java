package com.example.dipes.zeronetracker;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<APIData> dataList;
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendarView=  findViewById(R.id.calendarView);
//        Calendar rightNow = Calendar.getInstance();
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = 1+month;
                Toast.makeText(getApplicationContext(), ""+year+"-"+month+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();


            }
        });


        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<APIData> call = apiInterface.gethistorydetails("S10-1", "2018-08-01");
        call.enqueue(new Callback<APIData>() {
            @Override
            public void onResponse(Call<APIData> call, Response<APIData> response) {
                Log.d("TAG",response.code()+"");

            }
            @Override
            public void onFailure(Call<APIData> call, Throwable t) {

            }
        });
    }
}
