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

    public int alterarNota(Nota n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", n.getTitulo());
        contentValues.put("texto", n.getTexto());
        return db.update("notas", contentValues, "id=?", new String[]{String.valueOf(n.getId())});
    }

    public int deleteNota(int id) {
        return db.delete("notas", "id=?", new String[]{String.valueOf(id)});
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Nota n = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            arrayList.add(n);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public Nota getNotaById(int id) {
        Cursor cursor = db.rawQuery("SELECT * FROM notas WHERE id = ?", new String[]{String.valueOf(id)});
        if (cursor!= null && cursor.moveToFirst()) {
            return new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        return null;
    }
}
