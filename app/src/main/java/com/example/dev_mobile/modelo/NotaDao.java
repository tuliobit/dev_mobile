package com.example.dev_mobile.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase db;
    public NotaDao(Context c) {
        db = c.openOrCreateDatabase("dbNotas", c.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo varchar, " +
                "texto varchar);");
    }

    public Nota inserirNota(Nota n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        int i = (int) db.insert("notas", null, contentValues);
        n.setId(i);
        return n;
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayList = new ArrayList<>();
        while (cursor.isAfterLast()) {

            arrayList.add( new Nota(
                    cursor.getInt(cursor.getColumnIndex("id"),
                    cursor.getString("titulo"),
                    cursor.getString("texto")
                    )));
        }
    }
}
