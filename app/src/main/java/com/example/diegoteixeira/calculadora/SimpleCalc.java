package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class SimpleCalc extends AppCompatActivity {

    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);
    }

    private boolean typeValor(double valor) {
        if(valor % 1 == 0){
            return true;
        } else {
            return false;
        }
    }

    private int arredondar(String v1, String v2) {
        int index1 = v1.indexOf(".");
        int index2 = v2.indexOf(".");
        int t1 = 0;
        int t2 = 0;

        if(index1 != -1) {
            t1 = v1.length() - 1 - index1;
        }

        if(index2 != -1) {
            t2 = v2.length() - 1 - index2;
        }

        if(t1 > t2) {
            return t1;
        } else if(t2 > t1) {
            return t2;
        } else {
            return t1;
        }
    }

    private String findVirgula(String valor) {
        int index = valor.indexOf(",");
        String resp = "";
        if(index != -1) {
            resp = valor.substring(0,index)+"."+valor.substring(index+1);
            return resp;
        }

        return valor;
    }

    public void calcular(View view) {
        String valor1 = ((EditText)findViewById(R.id.valor1)).getText().toString();
        String valor2 = ((EditText)findViewById(R.id.valor2)).getText().toString();

        resposta = findViewById(R.id.result);

        String tag = view.getTag().toString();

        if(valor1.equals("") || valor2.equals("") || valor1.equals(".") || valor1.equals("-") || valor2.equals(".") || valor2.equals("-")){
            resposta.setText("Valor inválido");
        } else {
            int arredondar = arredondar(valor1, valor2);

            String zero = "";
            for(int i=0;i<arredondar;i++) {
                zero+="0";
            }

            if (tag.equals("sum")) {
                double resp = parseDouble(valor1) + parseDouble(valor2);
                if(typeValor(resp)) {
                    resposta.setText(String.valueOf((int)resp));
                } else {
                    resposta.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                }
            } else if (tag.equals("dec")) {
                double resp = parseDouble(valor1) - parseDouble(valor2);
                if(typeValor(resp)) {
                    resposta.setText(String.valueOf((int)resp));
                } else {
                    resposta.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                }
            } else if (tag.equals("multi")) {
                double resp = parseDouble(valor1) * parseDouble(valor2);
                if(typeValor(resp)) {
                    resposta.setText(String.valueOf((int)resp));
                } else {
                    resposta.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                }
            } else if (tag.equals("div")) {
                if ((parseDouble(valor2)) == 0) {
                    resposta.setText("Divisão por zero");
                } else {
                    double resp = parseDouble(valor1) / parseDouble(valor2);
                    if(typeValor(resp)) {
                        resposta.setText(String.valueOf((int)resp));
                    } else {
                        resposta.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                    }
                }
            }
        }

    }

    public void voltaMenu(View view) {
        finish();
    }
}