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

public class MainActivity extends AppCompatActivity {
    List<APIData> postList;
    List<StudentCheckinCheckout> checkoutList;
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
//                int counter;
//                if (questionsCount > 0) {
//                    String questiontext = list.get(counter).getQuestion();
//                    question.setText(questiontext);
//                    counter++;
//                }

            }
        });


        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<APIData>> call = apiInterface.gethistorydetails("S10-1", "2018-08-01");
      call.enqueue(new Callback<List<APIData>>() {
          @Override
          public void onResponse(Call<List<APIData>> call, Response<List<APIData>> response) {
              Log.d("TAG",response.code()+"");
              List<APIData> postList = response.body();
//              ArrayList<JSONObject> postList = new ArrayList<JSONObject>();
//              JSONArray jArray = (JSONArray) APIData;
//              if (postList != null) {
//                  for (int i=0;i<jArray.length();i++){
//                      postList.add(jArray.getString(i));
//                  }
//              }

          }




          @Override
          public void onFailure(Call<List<APIData>> call, Throwable t) {
              Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
          }
      });
    }
}
