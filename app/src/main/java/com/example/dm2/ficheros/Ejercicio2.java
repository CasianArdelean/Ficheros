package com.example.dm2.ficheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio2 extends AppCompatActivity {
    private ArrayList<String> datos= new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);


        InputStream fraw = getResources().openRawResource(R.raw.ejercicio2_raw);
        BufferedReader br = new BufferedReader(new InputStreamReader(fraw));
        try {
            String line = br.readLine();
            while (line!=null) {
                datos.add(line);
                line = br.readLine();
            }
            br.close();
            fraw.close();
        } catch (IOException e) {
        }

        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);

        Spinner spiner = (Spinner)findViewById(R.id.spiner);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spiner.setAdapter(adaptador);

    }
}
