package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("dbTaco", Context.MODE_PRIVATE, null);

        String sql = AssetUtils.loadStringFromAsset(Context, "taco_4_edicao.sql");
        String[] statements = sql.split(";");
        for (String statement : statements) {
            db.execSQL(statement);
        }
    }
}