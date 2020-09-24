package com.example.diegoteixeira.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void typeCalc(View view) {
        String tag = view.getTag().toString();

        if (tag.equals("calc1")) {
            Intent it = new Intent(getBaseContext(), SimpleCalc.class);
            startActivity(it);
        } else if (tag.equals("calc2")) {
            Intent it = new Intent(getBaseContext(), CompleteCalc.class);
            startActivity(it);
        }
    }

}