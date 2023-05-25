package com.example.dev_mobile;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dev_mobile.controller.AlimentoController;
import com.example.dev_mobile.modelo.Alimento;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AlimentoController alimentoController;
    private RecyclerView recyclerView;
    private AlimentoAdapter alimentoAdapter;
    private List<Alimento> alimentos;
    private FloatingActionButton fabSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase db = openOrCreateDatabase("dbTaco", Context.MODE_PRIVATE, null);

        executarAssetSQL();

        alimentoController = new AlimentoController(this);
        alimentos = alimentoController.getAllAlimentos();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alimentoAdapter = new AlimentoAdapter(alimentos, new AlimentoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Alimento alimento) {
                Intent intent = new Intent(MainActivity.this, ActivityDetalhaAlimento.class);
                intent.putExtra("alimento_selecionado", alimento);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(alimentoAdapter);

        // Botao de pesquisa
        fabSearch = findViewById(R.id.fabSearch);
        fabSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inicializaBusca();
            }
        });
    }

    private void executarAssetSQL() { //"taco_4_edicao.sql"
        SQLiteOpenHelper dbHelper = new SQLiteOpenHelper(this, "dbTaco", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                //
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                //
            }
        };

        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("taco_4_edicao.sql");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            StringBuilder comandoSQL = new StringBuilder();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                comandoSQL.append(linha);

                if (linha.trim().endsWith(";")) {
                    String statement = comandoSQL.toString().trim();
                    Log.i(TAG, "executarAssetSQL: " + statement);
                    db.execSQL(statement);
                    comandoSQL.setLength(0);
                }
            }

            bufferedReader.close();
            db.close();
        } catch (IOException | SQLiteException e) {
            e.printStackTrace();
        }
    }

    private void inicializaBusca() {
        // TODO
        // Chamar outra activity com pesquisa?
        // Ou filtrar pela RecyclerView?
    }

}