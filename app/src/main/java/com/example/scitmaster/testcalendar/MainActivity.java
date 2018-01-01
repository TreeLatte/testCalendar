package com.example.scitmaster.testcalendar;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendar;
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private int beforeDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (MaterialCalendarView) findViewById(R.id.calendarView);
        scrollView = (ScrollView)findViewById(R.id.data_scroll_view);
        linearLayout = (LinearLayout)findViewById(R.id.scroll_in_layout);
        beforeDay = -1;
        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int nowDay = date.getDay();
                LinearLayout dataLinearView = (LinearLayout) View.inflate(MainActivity.this,R.layout.activity_dayview,null);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.scroll_in_layout);
                TextView tempView = (TextView)dataLinearView.findViewById(R.id.textMoney);
                if(beforeDay == nowDay){
                    tempView.setText("$4달라!");
                    switch (linearLayout.getChildCount() % 7){

                        case 0:
                            dataLinearView.setBackgroundColor(Color.rgb(240,128,128));
                            break;
                        case 1:
                            dataLinearView.setBackgroundColor(Color.rgb(255,165,0));
                            break;
                        case 2:
                            dataLinearView.setBackgroundColor(Color.rgb(240,230,140));
                            break;
                        case 3:
                            dataLinearView.setBackgroundColor(Color.rgb(50,205,50));
                            break;
                        case 4:
                            dataLinearView.setBackgroundColor(Color.rgb(0,191,255));
                            break;
                        case 5:
                            dataLinearView.setBackgroundColor(Color.rgb(0,0,128));
                            break;
                        case 6:
                            dataLinearView.setBackgroundColor(Color.rgb(128,0,128));
                            break;
                    }
                    linearLayout.addView(dataLinearView);
                }
                else{
                    linearLayout.removeAllViews();
                }
                beforeDay = nowDay;
            }
        });

    }


}
