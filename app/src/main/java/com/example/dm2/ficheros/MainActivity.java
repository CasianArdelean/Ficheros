package com.example.dm2.ficheros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void ejercicio1 (View v) {
        Intent intent = new Intent(MainActivity.this,Ejercicio1.class);
        startActivity(intent);
    }
    public void ejercicio2 (View v) {
        Intent intent = new Intent(MainActivity.this,Ejercicio2.class);
        startActivity(intent);
    }
    public void ejercicio3 (View v) {
        Intent intent = new Intent(MainActivity.this,Ejercicio3.class);
        startActivity(intent);
    }
    public void salir (View v)
    {
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
