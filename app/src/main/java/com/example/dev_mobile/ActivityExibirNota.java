package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev_mobile.controller.NotaController;
import com.example.dev_mobile.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {
    EditText etTitulo, etTexto;
    NotaController notaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);

        notaController = new NotaController(getApplicationContext());
        etTitulo = findViewById(R.id.etTitulo);
        etTexto = findViewById(R.id.etTexto);
    }

    public void salvarNota(View v) {
        Nota n = notaController.cadastrarNovaNota( new Nota(etTitulo.getText().toString(), etTexto.getText().toString()));
        Toast.makeText(this, Integer.toString(n.getId()), Toast.LENGTH_SHORT).show();
        finish();
    }
}