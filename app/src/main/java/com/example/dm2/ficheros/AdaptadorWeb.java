package com.example.dm2.ficheros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class AdaptadorWeb extends ArrayAdapter<Web> {
    private ArrayList<Web> datos;
    public AdaptadorWeb(Context context, ArrayList<Web> datos) {
        super(context, R.layout.listitem_web, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_web, null);

        TextView lblNombre = item.findViewById(R.id.LblNombre);
        lblNombre.setText(datos.get(position).getNombre());

        TextView lblEnlace = item.findViewById(R.id.LblEnlace);
        lblEnlace.setText(datos.get(position).getEnlace());

        ImageView lblimage = item.findViewById(R.id.Lblimagen);

        switch (datos.get(position).getLogo().toString().trim()) {
            case "bing":
                lblimage.setImageResource(R.drawable.bing);
                break;
            case "yahoo":
                lblimage.setImageResource(R.drawable.yahoo);
                break;
            case "google":
                lblimage.setImageResource(R.drawable.google);
                break;
        }
        return(item);
    }
}