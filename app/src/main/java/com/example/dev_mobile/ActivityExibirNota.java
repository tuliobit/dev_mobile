package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev_mobile.controller.NotaController;
import com.example.dev_mobile.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {
    EditText etTitulo, etTexto;
    NotaController notaController;
    Button btnEditar, btnExcluir;
    int id_nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);

        notaController = new NotaController(getApplicationContext());
        etTitulo = findViewById(R.id.etTitulo);
        etTexto = findViewById(R.id.etTexto);
        btnEditar = findViewById(R.id.btnEditar);
        btnExcluir = findViewById(R.id.btnExcluir);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            id_nota = (int) b.get("id_nota");
        }

        if (id_nota > 0) {
            Nota n = notaController.buscaNotaPorId(id_nota);
            etTitulo.setText(n.getTitulo());
            etTexto.setText(n.getTexto());

            findViewById(R.id.layoutNovaNota).setVisibility(View.GONE);
            findViewById(R.id.layoutNotaExistente).setVisibility(View.VISIBLE);

            btnEditar.setOnClickListener(v -> editarNota(v, id_nota));
            btnExcluir.setOnClickListener(v -> excluirNota(v, id_nota));
        } else {
            findViewById(R.id.layoutNovaNota).setVisibility(View.VISIBLE);
            findViewById(R.id.layoutNotaExistente).setVisibility(View.GONE);
        }
    }

    public void salvarNota(View v) {
        Nota n = notaController.cadastrarNovaNota( new Nota(etTitulo.getText().toString(), etTexto.getText().toString()));
        Toast.makeText(this, Integer.toString(n.getId()), Toast.LENGTH_SHORT).show();
        finish();
    }

    public void editarNota(View v, int id_nota) {
        int qtd = notaController.editarNota( new Nota(id_nota, etTitulo.getText().toString(), etTexto.getText().toString() ) );
        Toast.makeText(this, "Qtd. registros afetados: " + Integer.toString(qtd), Toast.LENGTH_SHORT).show();
        finish();
    }

    public void excluirNota(View v, int id_nota) {
        int qtd = notaController.deletarNota( id_nota );
        Toast.makeText(this, "Qtd. registros afetados: " + Integer.toString(qtd), Toast.LENGTH_SHORT).show();
        finish();
    }
}