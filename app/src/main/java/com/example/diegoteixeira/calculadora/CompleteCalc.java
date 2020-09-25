package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static java.lang.Double.parseDouble;

public class CompleteCalc extends AppCompatActivity {

    EditText valor;
    String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calc);
    }

    public void setNumbers(View view) {
        valor = findViewById(R.id.valor);

        String tag = view.getTag().toString();
        String novoValor = "";

        if(tag.equals("zero")) {
            novoValor = valor.getText().toString() + "0";
        } else if(tag.equals("um")) {
            novoValor = valor.getText().toString() + "1";
        } else if(tag.equals("dois")) {
            novoValor = valor.getText().toString() + "2";
        } else if(tag.equals("tres")) {
            novoValor = valor.getText().toString() + "3";
        } else if(tag.equals("quatro")) {
            novoValor = valor.getText().toString() + "4";
        } else if(tag.equals("cinco")) {
            novoValor = valor.getText().toString() + "5";
        } else if(tag.equals("seis")) {
            novoValor = valor.getText().toString() + "6";
        } else if(tag.equals("sete")) {
            novoValor = valor.getText().toString() + "7";
        } else if(tag.equals("oito")) {
            novoValor = valor.getText().toString() + "8";
        } else if(tag.equals("nove")) {
            novoValor = valor.getText().toString() + "9";
        }

        valor.setText(novoValor);
    }

    private int validaExpressao(String exp) {
        int index = exp.indexOf("+");
        if(index == -1) {
            index = exp.indexOf("-");
            if(index == -1) {
                index = exp.indexOf("*");
                if(index == -1) {
                    index = exp.indexOf("/");
                }
            }
        }
        return index;
    }

    private int validaPonto(String exp) {
        int index = validaExpressao(exp);

        String test = exp.substring(index+1);

        return test.indexOf(".");
    }

    public void setOp(View view) {
        valor = findViewById(R.id.valor);

        String exp = valor.getText().toString();

        String tag = view.getTag().toString();
        String novoValor = "";


        if (exp.length() > 0) {
            if(!exp.substring(exp.length()-1).equals(".") && !exp.substring(exp.length()-1).equals("+")
                && !exp.substring(exp.length()-1).equals("-") && !exp.substring(exp.length()-1).equals("*")
                && !exp.substring(exp.length()-1).equals("/")) {

                if (tag.equals("ponto")) {
                    if(validaPonto(valor.getText().toString()) == -1) {
                        novoValor = valor.getText().toString() + ".";
                    }
                } else if (tag.equals("mais") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "+";
                } else if (tag.equals("sub") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "-";
                } else if (tag.equals("multi") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "*";
                } else if (tag.equals("div") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "/";
                }

            } else {
                String atual = valor.getText().toString();

                if (tag.equals("ponto")) {
                    if(atual.indexOf(".") == -1 ){
                        novoValor = atual.substring(0,atual.length()-1) + ".";
                    }
                } else if (tag.equals("mais") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1)) {
                    novoValor = atual.substring(0,atual.length()-1) + "+";
                } else if (tag.equals("sub") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1)) {
                    novoValor = atual.substring(0,atual.length()-1) + "-";
                } else if (tag.equals("multi") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1)) {
                    novoValor = atual.substring(0,atual.length()-1) + "*";
                } else if (tag.equals("div") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1)) {
                    novoValor = atual.substring(0,atual.length()-1) + "/";
                }
            }

            if(!novoValor.equals("")) {
                valor.setText(novoValor);
            }

        }

    }

    public void setFunc(View view) {

    }

    public void voltaMenu(View view) {
        finish();
    }
}