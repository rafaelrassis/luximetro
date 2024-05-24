package com.tccapp.luximetro;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class cozinha extends AppCompatActivity {

    private TextView maxValueTextView, minValueTextView, avgValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cozinha);

        maxValueTextView = findViewById(R.id.maxValueTextView);
        minValueTextView = findViewById(R.id.minValueTextView);
        avgValueTextView = findViewById(R.id.avgValueTextView);

        // Get the values from the Intent
        float maxValue = getIntent().getFloatExtra("MAX_VALUE", 0);
        float minValue = getIntent().getFloatExtra("MIN_VALUE", 0);
        float avgValue = getIntent().getFloatExtra("AVG_VALUE", 0);

        // Display the values
        maxValueTextView.setText("Max Value: " + maxValue);
        minValueTextView.setText("Min Value: " + minValue);
        avgValueTextView.setText("Average Value: " + avgValue);
    }
}