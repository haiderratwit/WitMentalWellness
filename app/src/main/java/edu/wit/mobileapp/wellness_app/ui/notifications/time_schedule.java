package edu.wit.mobileapp.wellness_app.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import edu.wit.mobileapp.wellness_app.R;

public class time_schedule extends AppCompatActivity implements TimePicker.OnTimeChangedListener {

    String month_name = "";
    int hour_choice, minute_choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_schedule);

        Bundle bundle = this.getIntent().getExtras();
        int year = bundle.getInt("Year");
        int month = bundle.getInt("Month");
        int day = bundle.getInt("Day");

        switch (month){
            case 1:
                month_name = "January";
                break;
            case 2:
                month_name = "February";
                break;
            case 3:
                month_name = "March";
                break;
            case 4:
                month_name = "April";
                break;
            case 5:
                month_name = "May";
                break;
            case 6:
                month_name = "June";
                break;
            case 7:
                month_name = "July";
                break;
            case 8:
                month_name = "August";
                break;
            case 9:
                month_name = "September";
                break;
            case 10:
                month_name = "October";
                break;
            case 11:
                month_name = "November";
                break;
            case 12:
                month_name = "December";
                break;
        }

        String dateString = String.format("%d-%d-%d", year, month, day);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Then get the day of week from the Date based on specific locale.
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        TextView day_picker = (TextView) findViewById(R.id.current_day);
        day_picker.setText(dayOfWeek + ", " + month_name + ", " + day );


        TimePicker timePicker = (TimePicker)findViewById(R.id.time_picker);
        hour_choice = timePicker.getHour();
        minute_choice = timePicker.getMinute();
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                hour_choice = hour;
                minute_choice = minute;
            }
        });

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.confirm);
        Button confirmbtn = (Button) linearLayout.findViewById(R.id.confirm_button);
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"vand@wit.edu"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmed appointment with Center of Wellness");
                intent.putExtra(Intent.EXTRA_TEXT,
                        "Confirm time: \n\t" + dayOfWeek + " " + month_name + " " + day +
                                " at " + hour_choice + ":" + minute_choice +
                                " at Wellness Center with Counselor ... for user ...");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent,"Send mail ..."));
            }
        });
    }


    @Override
    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
        hour_choice = i;
        minute_choice = i1;
    }
}