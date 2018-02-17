package com.example.dm2.ficheros;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejercicio1 extends AppCompatActivity {
    private EditText texto;
    private TextView documento;
    private boolean sdDisponible = false;
    private boolean sdAccesoEscritura = false;
    protected void anadirInt(View v)
    {
        String mensaje = texto.getText().toString();
        try
        {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("Fichero1.txt", Context.MODE_PRIVATE));
            osw.write(mensaje);
            osw.close();
        } catch (Exception e) {
        }
    }
    protected void anadirExt(View v)
    {
        comprobarSD();
        if((sdDisponible==true)&&(sdAccesoEscritura==true))
        {
            String mensaje = texto.getText().toString();
            try
            {
                File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

                File f = new File(ruta_sd.getAbsolutePath(), "Fichero1.txt");

                OutputStreamWriter fout =
                        new OutputStreamWriter(
                                new FileOutputStream(f));

                fout.write(mensaje);
                fout.close();
            }
            catch (Exception ex)
            {
            }
        }
    }
    protected void leerInt(View v)
    {
        try
        {
            documento.setText("");
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("Fichero1.txt")));
            String line=fin.readLine();
            while(line!=null)
            {
                documento.setText(documento.getText().toString()+line+"\n");
                line=fin.readLine();
            }
            fin.close();
        } catch (Exception e) {}
    }
    protected void leerExt(View v)
    {
        documento.setText("");
        comprobarSD();
        if(sdDisponible==true) {
            try {
                File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
                File f = new File(ruta_sd.getAbsolutePath(), "Fichero1.txt");

                BufferedReader fin =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(f)));
                String line=fin.readLine();
                while(line!=null)
                {
                    documento.setText(documento.getText().toString()+line+"\n");
                    line=fin.readLine();
                }
                fin.close();
            } catch (Exception ex) {
                documento.setText("");
            }
        }
    }
    protected void leerRecurso(View v)
    {
        documento.setText("");
        InputStream fraw = getResources().openRawResource(R.raw.ejercicio1_raw);
        BufferedReader br = new BufferedReader(new InputStreamReader(fraw));
        try {
            String line = br.readLine();
            while (line!=null) {
                documento.setText(documento.getText().toString() + line + "\n");
                line = br.readLine();
            }
            br.close();
            fraw.close();
        } catch (IOException e) {}
    }
    protected void borrarInt(View v)
    {
        File f = new File(getFilesDir(),"Fichero1.txt");
        f.delete();
    }
    protected void borrarExt(View v)
    {
        File ruta_sd = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File f = new File(ruta_sd.getAbsolutePath(), "Fichero1.txt");
        f.delete();
    }

    protected void comprobarSD()
    {
        //Comprobamos el estado de la memoria externa (tarjeta SD)
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED))
        {
            sdDisponible = true;
            sdAccesoEscritura = true;
        }
        else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            sdDisponible = true;
            sdAccesoEscritura = false;
        }
        else
        {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        texto = (EditText) findViewById(R.id.texto);
        documento = (TextView) findViewById(R.id.documento);
    }
}
