package com.example.dev_mobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dev_mobile.controller.NotaController;
import com.example.dev_mobile.modelo.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
    }

    public void novaNota (View v) {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id_nota", 0);
        startActivity(intent);
    }

    public void verNota(int id) {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id_nota", id);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaController notaController = new NotaController(this);
//        ArrayList<String> dataset = notaController.listaTitulosNotas();
        ArrayList<Nota> dataset = notaController.listaNotas();

        ArrayAdapter<Nota> adapter = new ArrayAdapter<Nota>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dataset
        ) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Nota nota = getItem(position);
                if (nota != null) {
                    TextView textView = view.findViewById(android.R.id.text1);
                    textView.setText(nota.getTitulo());
                    view.setTag(nota.getId());
                }
                return view;
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            int itemId = (int) view.getTag();
            verNota(itemId);
        });
    }
}