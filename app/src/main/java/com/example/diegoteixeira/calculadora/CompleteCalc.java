package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class CompleteCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_calc);
    }

    public void setNumbers(View view) {
    }

    public void setOp(View view) {
    }

    public void setFunc(View view) {
    }

    public void voltaMenu(View view) {
        finish();
    }
}