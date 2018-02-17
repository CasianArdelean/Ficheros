package com.example.dm2.ficheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {
    private ArrayList<Web> datos = new ArrayList<Web>();
    private ListView lstOpciones;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        InputStream fraw = getResources().openRawResource(R.raw.ejercicio3_raw);
        BufferedReader br = new BufferedReader(new InputStreamReader(fraw));
        try {
            String line = br.readLine();
            while (line!=null) {
                String[] web= line.split(";");
                datos.add(new Web(web[0],web[1],web[2],web[3]));
                line = br.readLine();
            }
            br.close();
            fraw.close();
        } catch (IOException e) {
        }

        AdaptadorWeb adaptador =  new AdaptadorWeb(this, datos);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

    }
}

