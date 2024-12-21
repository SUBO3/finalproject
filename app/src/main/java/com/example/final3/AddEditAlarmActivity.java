package com.example.final3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
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

        CheckBox[] checkBoxes = new CheckBox[]{
                findViewById(R.id.checkbox_sunday),
                findViewById(R.id.checkbox_monday),
                findViewById(R.id.checkbox_tuesday),
                findViewById(R.id.checkbox_wednesday),
                findViewById(R.id.checkbox_thursday),
                findViewById(R.id.checkbox_friday),
                findViewById(R.id.checkbox_saturday)
        };


        days = new boolean[7]; // 預設每週七天皆未選中

        saveButton.setOnClickListener(v -> {
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();


            for (int i = 0; i < checkBoxes.length; i++) {
                days[i] = checkBoxes[i].isChecked();
            }


            Intent resultIntent = new Intent();
            resultIntent.putExtra("hour", hour);
            resultIntent.putExtra("minute", minute);
            resultIntent.putExtra("days", days);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}