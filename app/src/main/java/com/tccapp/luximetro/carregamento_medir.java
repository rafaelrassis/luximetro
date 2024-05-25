package com.tccapp.luximetro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class carregamento_medir extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView currentValueMediaTextView, maxValueMediaTextView, minValueMediaTextView, avgValueMediaTextView;

    private float maxValue = Float.MIN_VALUE;
    private float minValue = Float.MAX_VALUE;
    private float sumValue = 0;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregamento_medir);

        // Initialize TextViews
        currentValueMediaTextView = findViewById(R.id.currentValueMediaTextView);
        maxValueMediaTextView = findViewById(R.id.maxValueMediaTextView);
        minValueMediaTextView = findViewById(R.id.minValueMediaTextView);
        avgValueMediaTextView = findViewById(R.id.avgValueMediaTextView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null) {
            currentValueMediaTextView.setText("No light sensor found");
            maxValueMediaTextView.setText("No light sensor found");
            minValueMediaTextView.setText("No light sensor found");
            avgValueMediaTextView.setText("No light sensor found");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMeasurement();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMeasurement();
    }

    private void startMeasurement() {
        // Reset values
        maxValue = Float.MIN_VALUE;
        minValue = Float.MAX_VALUE;
        sumValue = 0;
        count = 0;

        // Start listening to sensor events
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stopMeasurement() {
        // Stop listening to sensor events
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float lightValue = event.values[0]; // Store the current sensor value

        // Update current value
        currentValueMediaTextView.setText(lightValue + " lx");

        // Update max, min, and sum values
        if (lightValue > maxValue) {
            maxValue = lightValue;
        }
        if (lightValue < minValue) {
            minValue = lightValue;
        }
        sumValue += lightValue;
        count++;

        // Calculate average
        float avgValue = sumValue / count;

        // Update UI with max, min, and avg values
        maxValueMediaTextView.setText("Valor máximo: " + maxValue + " lx");
        minValueMediaTextView.setText("Valor mínimo: " + minValue + " lx");
        avgValueMediaTextView.setText("Média: " + avgValue + " lx");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used
    }
}
