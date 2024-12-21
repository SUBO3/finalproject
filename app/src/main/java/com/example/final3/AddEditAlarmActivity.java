package com.example.final3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditAlarmActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private boolean[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_alarm);

        timePicker = findViewById(R.id.time_picker);
        Button saveButton = findViewById(R.id.button_save);

        days = new boolean[7]; // 預設每週七天皆未選中

        saveButton.setOnClickListener(v -> {
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();


            Intent resultIntent = new Intent();
            resultIntent.putExtra("hour", hour);
            resultIntent.putExtra("minute", minute);
            resultIntent.putExtra("days", days);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}