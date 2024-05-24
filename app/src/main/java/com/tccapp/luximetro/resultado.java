package com.tccapp.luximetro;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class resultado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Retrieve values passed by Carregamento activity

        String ambiente = getIntent().getStringExtra("ambiente");
        String idade = getIntent().getStringExtra("idade");
        float maxValue = getIntent().getFloatExtra("MAX_VALUE", 0.0f);
        float minValue = getIntent().getFloatExtra("MIN_VALUE", 0.0f);
        float avgValue = getIntent().getFloatExtra("AVG_VALUE", 0.0f);
        float currentValue = getIntent().getFloatExtra("currentValue", 0.0f); // Recuperando o valor atual do sensor

        // Initialize TextViews
        TextView maxValueTextView = findViewById(R.id.maxValueTextView);
        TextView minValueTextView = findViewById(R.id.minValueTextView);
        TextView avgValueTextView = findViewById(R.id.avgValueTextView);
        TextView ambienteTextView = findViewById(R.id.ambienteTextView);
        TextView idadeTextView = findViewById(R.id.idadeTextView);


        // Set values to TextViews
        maxValueTextView.setText("Max Value: " + maxValue);
        minValueTextView.setText("Min Value: " + minValue);
        avgValueTextView.setText("Average Value: " + avgValue);
        ambienteTextView.setText("Ambiente: " + ambiente);
        idadeTextView.setText("Idade: " + idade);

    }
}
