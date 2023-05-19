package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase banco;
    private EditText etCodigo, etNome, etNota;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etNome = (EditText) findViewById(R.id.etNome);

        banco = this.openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS alunos (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR)");

        banco.execSQL("INSERT INTO alunos (nome) VALUES ('Teste 1' )");
        banco.execSQL("INSERT INTO alunos (nome) VALUES ('Teste 2' )");
        banco.execSQL("INSERT INTO alunos (nome) VALUES ('Tetse 3' )");

        showAlunos();
    }

    public void showAlunos() {
        Cursor cursor = banco.rawQuery("SELECT id, nome FROM alunos ", null);
        cursor.moveToFirst();
        ArrayList<String> itens = new ArrayList<>();
        do {
            String s = cursor.getString( cursor.getColumnIndex("nome") );
            Log.i(" Resultado Sql :",s );
            itens.add(s);
        }while (cursor.moveToNext()) ;
        ListView list;
        list = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        list.setAdapter(adapter);
    }
    public void insereAluno() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", etNome.getText().toString());
        this.banco.insert("alunos", null, contentValues);
    }

    public void insereNota() {
        ContentValues contentValues = new ContentValues();
//        contentValues.put("nome", f.getNome());
        this.banco.insert("alunos", null, contentValues);
    }
}