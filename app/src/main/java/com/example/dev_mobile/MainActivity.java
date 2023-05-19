package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.dev_mobile.controller.NotaController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void novaNota (View v) {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id nota", 0);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaController notaController = new NotaController(this);
        ArrayList<String> dataset = notaController.listaNotas();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item1,
                android.R.id.text1,
                dataset
        );
        listView.setAdapter(adapter);
    }
}