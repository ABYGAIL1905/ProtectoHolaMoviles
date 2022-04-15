package com.example.holaesatproyecto.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.holaesatproyecto.FragmentsPlatos.FragmentEntradasTiki;
import com.example.holaesatproyecto.R;
import com.example.holaesatproyecto.modelo.Producto;

import java.util.List;

public class AdapterProducto extends ArrayAdapter<Producto> {
    private Context context;
    private List<Producto> listaproducto;
    private TextView txtnombreplato;
    ImageView fotoplato;



    public AdapterProducto(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Producto> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.listaproducto=objects;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roview=layoutInflater.inflate(R.layout.grid_platos,parent,false);

       // fotoplato=(ImageView)roview.findViewById(R.id.opcionimagenPlato1);
        txtnombreplato=(TextView)roview.findViewById(R.id.menunombre_plato1);

        fotoplato.setImageResource(listaproducto.get(position).getFoto_producto());
        txtnombreplato.setText(listaproducto.get(position).getNombre_producto());
        return  roview;



    }
}
