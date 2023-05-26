package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvLightSensor;
    SensorManager mSensorManager;
    Sensor mSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLightSensor = findViewById(R.id.tvLightSensor);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                int sensorType = sensorEvent.sensor.getType();
                tvLightSensor.setText(Float.toString(sensorType));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}