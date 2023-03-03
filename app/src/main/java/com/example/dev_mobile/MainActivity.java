package com.example.dev_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edPeso, edAltura;
    TextView tvResultado;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
        imageView = findViewById(R.id.imageView);
        tvResultado = findViewById(R.id.tvResultado);

    }

    public void calculaIMC(View view) {
        double peso, altura, imc;
        peso = Double.parseDouble(edPeso.getText().toString());
        altura = Double.parseDouble(edAltura.getText().toString());
        imc = peso / (altura+altura);

        tvResultado.setText(Double.toString(imc));

        if (imc > 25) {
            imageView.setImageResource(R.drawable.obesidade1);
        }
    }
}