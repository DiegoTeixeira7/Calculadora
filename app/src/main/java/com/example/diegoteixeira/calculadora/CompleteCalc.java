package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

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

    private boolean validaSub(String exp){
        String valida = exp;
        boolean resposta = false;
        if(exp.length() > 1) {
            if(exp.substring(0,1).equals("-")) {
                valida = exp.substring(1);
            }

            int index = valida.indexOf("-");

            if(index == -1) {
                resposta = true;
            } else {
                if(valida.length() == index+1){
                    resposta = true;

                } else {
                    if(!valida.substring(index+1,index+2).equals("-")) {
                        resposta = true;
                    }
                }
            }
        } else {
            if(valida.length() == 0) {
                resposta = true;
            } else if(valida.length() == 1 && !valida.equals("-")) {
                resposta = true;
            }
        }

        return resposta;
    }

    private int validaExpressao(String exp) {
        int index = exp.indexOf("+");
        if(index == -1) {
            index = exp.indexOf("*");
            if(index == -1) {
                index = exp.indexOf("/");
                if(index == -1 && exp.length() > 1) {
                    if(exp.substring(0,1).equals("-")){
                        index = exp.substring(1).indexOf("-");
                    } else {
                        index = exp.indexOf("-");
                    }
                }
            }
        }
        return index;
    }

    private int validaConta(String exp) {
        int index = exp.indexOf("+");
        if(index == -1) {
            index = exp.indexOf("*");
            if(index == -1) {
                index = exp.indexOf("/");
                if(index == -1 && exp.length() > 1) {
                    if(exp.substring(0,1).equals("-")){
                        if(exp.substring(1).indexOf("-") == -1) {
                            index = -1;
                        } else {
                            index = exp.substring(1).indexOf("-") + 1;
                        }
                    } else {
                        index = exp.indexOf("-");
                    }
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
                } else if (tag.equals("sub") && (validaExpressao(valor.getText().toString()) == -1) && validaSub(valor.getText().toString())) {
                    novoValor = valor.getText().toString() + "-";
                } else if (tag.equals("multi") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "*";
                } else if (tag.equals("div") && (validaExpressao(valor.getText().toString()) == -1)) {
                    novoValor = valor.getText().toString() + "/";
                }

            } else {
                String atual = valor.getText().toString();

                if (tag.equals("ponto") && atual.length() > 1 && !atual.substring(atual.length()-1).equals("-")) {
                    if(atual.indexOf(".") == -1 ){
                        novoValor = atual.substring(0,atual.length()-1) + ".";
                    }
                } else {
                    boolean p = !atual.substring(atual.length() - 1).equals(".");
                    if (tag.equals("mais") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1) && (atual.length() > 1) && p) {
                        novoValor = atual.substring(0,atual.length()-1) + "+";
                    } else if (tag.equals("sub") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1) && validaSub(valor.getText().toString()) && p) {

                            novoValor = atual + "-";

                    } else if (tag.equals("multi") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1) && (atual.length() > 1) && p ){
                        novoValor = atual.substring(0,atual.length()-1) + "*";
                    } else if (tag.equals("div") && (validaExpressao(atual.substring(0,atual.length()-1)) == -1) && (atual.length() > 1) && p) {
                        novoValor = atual.substring(0,atual.length()-1) + "/";
                    }
                }
            }

            if(!novoValor.equals("")) {
                valor.setText(novoValor);
            }

        } else {
            if(tag.equals("sub")){
                valor.setText("-");
            }
        }
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

    public void setFunc(View view) {
        valor = findViewById(R.id.valor);
        String atual = valor.getText().toString();

        String tag = view.getTag().toString();

        if(tag.equals("delete")) {
            if(atual.length() > 0) {
                valor.setText(atual.substring(0,atual.length()-1));
            }
        } else if(tag.equals("deleteAll")) {
            valor.setText("");
        } else if(tag.equals("igual")) {

            if((atual.length() > 2)){
                int index = validaConta(atual);

                if(index != -1 && index != atual.length()-1) {
                    String valor1 = atual.substring(0,index);
                    String op = atual.substring(index,index+1);
                    String valor2 = atual.substring(index+1);

                    if(!valor2.equals("-") && !valor2.substring(valor2.length()-1).equals(".")) {
                        int arredondar = arredondar(valor1, valor2);

                        String zero = "";
                        for(int i=0;i<arredondar;i++) {
                            zero+="0";
                        }

                        if(op.equals("+")) {
                            double resp = parseDouble(valor1) + parseDouble(valor2);
                            if(typeValor(resp)) {
                                valor.setText(String.valueOf((int)resp));
                            } else {
                                valor.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                            }
                        } else if(op.equals("-")) {
                            double resp = parseDouble(valor1) - parseDouble(valor2);
                            if(typeValor(resp)) {
                                valor.setText(String.valueOf((int)resp));
                            } else {
                                valor.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                            }
                        } else if(op.equals("*")) {
                            double resp = parseDouble(valor1) * parseDouble(valor2);
                            if(typeValor(resp)) {
                                valor.setText(String.valueOf((int)resp));
                            } else {
                                valor.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                            }
                        } else if(op.equals("/") && !valor2.equals("0")){
                            double resp = parseDouble(valor1) / parseDouble(valor2);
                            if(typeValor(resp)) {
                                valor.setText(String.valueOf((int)resp));
                            } else {
                                valor.setText(findVirgula(new DecimalFormat("#,##0." + zero).format(resp)));
                            }
                        }
                    }
                }
            }
        }
    }

    public void voltaMenu(View view) {
        finish();
    }
}