package com.example.dipes.zeronetracker;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    List<APIData> postList;
    List<StudentCheckinCheckout> checkoutList;
    String var="";
    private CalendarView mCalendarView;
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendarView=  findViewById(R.id.calendarView);

        tv1=(TextView)findViewById(R.id.tv_bus_arrival) ;
        tv2=(TextView)findViewById(R.id.tv_check_in) ;
        tv3=(TextView)findViewById(R.id.tv_school_reach) ;
        tv4=(TextView)findViewById(R.id.tv_home_reach) ;

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            Calendar cal = Calendar.getInstance();
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
            Log.d("TAG",response.code()+"gj");
            Log.d("TAG",response.body().getStudentCheckinCheckout().size()+"gjgj");
            List<StudentCheckinCheckout> postList= new ArrayList<>();



//            APIData responseBody=response.body();

            String [] data = new String[postList.size()];


            for(int i=0; i<postList.size(); i++) {
                System.out.println(postList.get(i).toString());
                data[i] = postList.get(i).getCheckIn();
                data[i+1] = postList.get(i).getBusComing();
                data[i+2] = postList.get(i).getReachSchool();
                data[i+3] = postList.get(i).getReachHome();
//                Log.d("TAG",response.code()+var);
            }

        }

        @Override
        public void onFailure(Call<APIData> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

        }
    });



}}