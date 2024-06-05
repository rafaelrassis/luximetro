package com.tccapp.luximetro;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Carregamento extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView currentValueTextView, maxValueTextView, minValueTextView, avgValueTextView;
    private TextView ambienteTextView, idadeTextView;
    private Button startButton;

    private float maxValue = Float.MIN_VALUE;
    private float minValue = Float.MAX_VALUE;
    private float sumValue = 0;
    private int count = 0;
    private float lightValue;

    private Handler handler = new Handler();
    private Runnable stopMeasurementRunnable = new Runnable() {
        @Override
        public void run() {
            // Stop listening to sensor events
            sensorManager.unregisterListener(Carregamento.this);


// Retrieve environment and age from MainActivity
            Intent intent = getIntent();
            String ambiente = intent.getStringExtra("local");
            String idade = intent.getStringExtra("idade");

            // Initialize TextViews
            ambienteTextView = findViewById(R.id.ambienteTextView);
            idadeTextView = findViewById(R.id.idadeTextView);


            ambienteTextView.setText("Ambiente: " + ambiente);
            idadeTextView.setText("Idade: " + idade);



            // Calculate average
            float avgValue = sumValue / count;

            // Update UI with max, min, and avg values
            maxValueTextView.setText("Max Value: " + maxValue);
            minValueTextView.setText("Min Value: " + minValue);
            avgValueTextView.setText("Average Value: " + avgValue);

            // Send the values to resultado activity
            Intent resultIntent = new Intent(Carregamento.this, resultado.class);
            resultIntent.putExtra("ambiente", ambiente);
            resultIntent.putExtra("idade", idade);
            resultIntent.putExtra("MAX_VALUE", maxValue);
            resultIntent.putExtra("MIN_VALUE", minValue);
            resultIntent.putExtra("AVG_VALUE", avgValue);
            resultIntent.putExtra("currentValue", lightValue);
            startActivity(resultIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregamento);
        try {

// Retrieve environment and age from MainActivity
        Intent intent = getIntent();
        String ambiente = intent.getStringExtra("local");
        String idade = intent.getStringExtra("idade");

        // Initialize TextViews
        ambienteTextView = findViewById(R.id.ambienteTextView);
        idadeTextView = findViewById(R.id.idadeTextView);


        ambienteTextView.setText("Ambiente: " + ambiente);
        idadeTextView.setText("Idade: " + idade);


        // Initialize TextViews
        currentValueTextView = findViewById(R.id.currentValueTextView);
        maxValueTextView = findViewById(R.id.maxValueTextView);
        minValueTextView = findViewById(R.id.minValueTextView);
        avgValueTextView = findViewById(R.id.avgValueTextView);

        // Initialize start button
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMeasurement(); // Inicia a medição quando o botão é clicado
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null) {
            currentValueTextView.setText("No light sensor found");
            maxValueTextView.setText("No light sensor found");
            minValueTextView.setText("No light sensor found");
            avgValueTextView.setText("No light sensor found");
            startButton.setEnabled(false); // Desabilita o botão se não houver sensor de luz
        }
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com a exceção aqui, por exemplo, exibir uma mensagem de erro para o usuário
            Toast.makeText(getApplicationContext(), "Erro! .", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, erroapp.class);
            startActivity(intent);
        }

    }

    private void startMeasurement() {
        try {
        // Reset values
        maxValue = Float.MIN_VALUE;
        minValue = Float.MAX_VALUE;
        sumValue = 0;
        count = 0;

        // Start listening to sensor events
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Schedule stop of measurement after 3 seconds
        handler.postDelayed(stopMeasurementRunnable, 3000);

        // Disable start button to prevent multiple measurements
        startButton.setEnabled(false);
    } catch (Exception e) {
        e.printStackTrace();
        // Lidar com a exceção aqui, por exemplo, exibir uma mensagem de erro para o usuário
        Toast.makeText(getApplicationContext(), "Erro! .", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, erroapp.class);
        startActivity(intent);
    }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        try {
        lightValue = event.values[0]; // Armazenando o valor atual do sensor

        // Update current value
        currentValueTextView.setText(lightValue + " lx");

        // Update max, min, and sum values
        if (lightValue > maxValue) {
            maxValue = lightValue;
        }
        if (lightValue < minValue) {
            minValue = lightValue;
        }
        sumValue += lightValue;
        count++;
    } catch (Exception e) {
        e.printStackTrace();
        // Lidar com a exceção aqui, por exemplo, exibir uma mensagem de erro para o usuário
        Toast.makeText(getApplicationContext(), "Erro! .", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, erroapp.class);
        startActivity(intent);
    }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used
    }


}
