package com.example.holaesatproyecto.adaptadores;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.holaesatproyecto.ActividadDetallePlato;
import com.example.holaesatproyecto.R;
import com.example.holaesatproyecto.modelo.Producto;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdaptadorPlatos extends RecyclerView.Adapter<RecyclerAdaptadorPlatos.ViewHolder> {

    //LayoutInflater inflater;
    Context context;
    List<Producto> listaproducto;
    List<Producto> originallistaproducto;
    RecyclerView listPlatos;
    RecyclerIntemClick intemClick;
    private View.OnClickListener listener;



    public RecyclerAdaptadorPlatos(Context context,List<Producto> listaproducto ,RecyclerIntemClick intemClick) {
       this.context=context;

        this.listaproducto = listaproducto;
        this.intemClick=intemClick;
        //System.out.println(listaproducto.size()+"Productos Mostrando");
       // this.listPlatos=listPlatos;
       // this.originallistaproducto = new ArrayList<>();

       //originallistaproducto.addAll(listaproducto);

    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_platos,parent,false);
        //RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.WRAP_CONTENT);
        //view.setLayoutParams(layoutParams);
        //view.setOnClickListener(this);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView")int position) {
        final Producto item=listaproducto.get(position);
        holder.txtnombreplato.setText(item.getNombre_producto());
        System.out.println(listaproducto.get(position).getNombre_producto()+"NOMBRESSSSSSSSSSSSSSSSS");
       // holder.fotoplato.setImageResource(item.getFoto_producto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intemClick.itemClick(item);
            }
        });
       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(holder.itemView.getContext(), ActividadDetallePlato.class);
                intent.putExtra("itemDetalle",item); //Cualquier n ombre en put extra
                holder.itemView.getContext().startActivity(intent);
            }
        });*/


    }



    @Override
    public int getItemCount() {
        return listaproducto.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtnombreplato;
        ImageView fotoplato;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombreplato=itemView.findViewById(R.id.menunombre_plato1);
            //fotoplato=itemView.findViewById(R.id.opcionimagenPlato1);

        }

    }
    public interface RecyclerIntemClick{
        void itemClick(Producto producto);

    }



}
