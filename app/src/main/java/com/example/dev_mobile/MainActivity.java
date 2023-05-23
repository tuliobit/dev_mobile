package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase db = openOrCreateDatabase("dbTaco", Context.MODE_PRIVATE, null);

        executarAssetSQL();
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