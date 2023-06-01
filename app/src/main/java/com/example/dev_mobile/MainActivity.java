package com.example.dev_mobile;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SimplePaint simplePaintView;
    Button btnLimpar, btnFormato, btnCor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaintView = findViewById(R.id.simplePaintView);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFormato = findViewById(R.id.btnFormato);
        btnCor = findViewById(R.id.btnCor);

        btnLimpar.setOnClickListener(this);
        btnFormato.setOnClickListener(this);
        btnCor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLimpar:
                simplePaintView.limparCanvas();
                break;
            case R.id.btnFormato:
                mostraSelecionadorFormato();
                break;
            case R.id.btnCor:
                mostraSelecionadorCor();
                break;
        }
    }

    private void mostraSelecionadorFormato() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione um formato");

        final String[] shapes = { "Linha", "Circulo", "Quadrado" };

        builder.setItems(shapes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SimplePaint.Shape formatoSelecionado = SimplePaint.Shape.LINE;
                switch (which) {
                    case 0:
                        formatoSelecionado = SimplePaint.Shape.LINE;
                        break;
                    case 1:
                        formatoSelecionado = SimplePaint.Shape.CIRCLE;
                        break;
                    case 2:
                        formatoSelecionado = SimplePaint.Shape.SQUARE;
                        break;
                }

                simplePaintView.setFormatoSelecionado(formatoSelecionado);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostraSelecionadorCor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione uma cor");

        final String[] cores = { "Vermelho", "Verde", "Azul" };

        builder.setItems(cores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedColor = Color.RED;
                switch (which) {
                    case 0:
                        selectedColor = Color.RED;
                        break;
                    case 1:
                        selectedColor = Color.GREEN;
                        break;
                    case 2:
                        selectedColor = Color.BLUE;
                        break;
                }

                simplePaintView.setCorSelecionada(selectedColor);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

