package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SimpleCalc extends AppCompatActivity {

    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);
    }

    public void calcular(View view) {
        String valor1 = ((EditText)findViewById(R.id.valor1)).getText().toString();
        String valor2 = ((EditText)findViewById(R.id.valor2)).getText().toString();

        resposta = findViewById(R.id.result);

        String tag = view.getTag().toString();

        if(valor1.equals("") || valor2.equals("") || valor1.equals(".") || valor1.equals("-") || valor2.equals(".") || valor2.equals("-")){
            resposta.setText("Valor inválido");
        } else {
            if (tag.equals("sum")) {
                resposta.setText(String.valueOf(parseDouble(valor1) + parseDouble(valor2)));
            } else if (tag.equals("dec")) {
                resposta.setText(String.valueOf(parseDouble(valor1) - parseDouble(valor2)));
            } else if (tag.equals("multi")) {
                resposta.setText(String.valueOf(parseDouble(valor1) * parseDouble(valor2)));
            } else if (tag.equals("div")) {
                if ((parseDouble(valor2)) == 0) {
                    resposta.setText("Divisão por zero");
                } else {
                    resposta.setText(String.valueOf(parseDouble(valor1) / parseDouble(valor2)));
                }
            }
        }

    }

    public void voltaMenu(View view) {
        finish();
    }
}