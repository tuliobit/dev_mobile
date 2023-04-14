package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FrutaController frutaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        frutaController = new FrutaController();
        FrutaAdapter frutaAdapter = new FrutaAdapter(this, R.layout.item_lista, frutaController.FRUTAS);

        recyclerView.setAdapter(frutaAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), frutaAdapter.mDataSet[position].getNome(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }
}