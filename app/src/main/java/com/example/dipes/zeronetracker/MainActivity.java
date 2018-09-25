package com.example.dipes.zeronetracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public List<StudentCheckinCheckout> postList;
//    List<StudentCheckinCheckout> checkoutList;
//    public  String m;
    private CalendarView mCalendarView;
    TextView tv1,tv2,tv3,tv4;
//    int i;
    String selectedDate;
//    String matchedDate;


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
                selectedDate=year+"-0"+month+"-"+dayOfMonth; 
                studentData(selectedDate);


            }
        });
        
}

    private void studentData(String selectedDate) {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<APIData> call = apiInterface.gethistorydetails("S10-1", selectedDate);
    call.enqueue(new Callback<APIData>() {
        @Override
        public void onResponse(Call<APIData> call, Response<APIData> response) {
            Log.d("TAG", response.code() + "gj");
            Log.d("TAG", response.body().getStudentCheckinCheckout().size() + "gjgj");

            postList = response.body().getStudentCheckinCheckout();
//            System.out.println(postList.get(0).getDay() + "date came");j

            String [] data = new String[postList.size()];

//            for (int i = 0; i < postList.size(); i++) {
//                String m = postList.get(i).getCheckIn();
////                Log.v("M" + i, m);
////                data.add(postList.ge(i) + ",");
////                Log("JSON-ARRAY-->" + image_urls.add(folio.getString(i)));
//            }

            for(int i=0; i<postList.size(); i++) {
               // System.out.println(postList.get(i).getDay());
//                data[i] = String.valueOf(postList.get(i).getDay());
//                data[i] = postList.get(i).getType();
//                data[i] = postList.get(i).getCheckIn();
//                data[i] = postList.get(i).getCheckOut();
//                data[i] = postList.get(i).getReachHome();
//                data[i] = postList.get(i).getBusComing();
//                data[i] = postList.get(i).getReachSchool();
//                data[i] = String.valueOf(postList.get(i).getHistStation());

                if((postList.get(i).getDay()).equalsIgnoreCase(selectedDate)){
                    System.out.println("matched f");
                    tv1.setText(postList.get(i).getBusComing());
                    tv2.setText(postList.get(i).getCheckIn());
                    tv3.setText(postList.get(i).getReachSchool());
                    tv4.setText(postList.get(i).getReachHome());

                }else{
                    System.out.println("not matched "+postList.get(i).getDay()+" "+ selectedDate);

                }
            }



        }


//            String [] data = new String[postList.size()];
//
//
//            for(int i=0; i<postList.size(); i++) {
//                System.out.println(postList.get(i).toString());
//                data[i] = postList.get(i).getCheckIn();
//                data[i+1] = postList.get(i).getBusComing();
//                data[i+2] = postList.get(i).getReachSchool();
//                data[i+3] = postList.get(i).getReachHome();
////                Log.d("TAG",response.code()+var);
//            }



        @Override
        public void onFailure(Call<APIData> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

        }
    });
    }
}