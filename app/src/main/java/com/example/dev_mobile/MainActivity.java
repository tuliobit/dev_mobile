package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    Button buttonA, buttonB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA=findViewById(R.id.buttonA);
        buttonB=findViewById(R.id.buttonB);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
    }
    public void abreFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonA:
                fragment= new FragmentoA();
                break;
            case R.id.buttonB:
                fragment = new FragmentoB();
                break;
        }
        abreFragment();
    }
}