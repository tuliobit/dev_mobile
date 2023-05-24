package com.example.dev_mobile;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.example.dev_mobile.controller.AlimentoController;
import com.example.dev_mobile.modelo.Alimento;

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
                // Handle item click event, navigate to a new activity or fragment to display detailed information
                // Pass the selected Alimento object to the new activity or fragment
            }
        });
        recyclerView.setAdapter(alimentoAdapter);
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

}