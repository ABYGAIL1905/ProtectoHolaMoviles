package com.example.holaesatproyecto.FragmentsPlatos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.holaesatproyecto.ActividadDetallePlato;
import com.example.holaesatproyecto.R;
import com.example.holaesatproyecto.adaptadores.AdapterProducto;
import com.example.holaesatproyecto.adaptadores.RecyclerAdaptadorPlatos;
import com.example.holaesatproyecto.adaptadores.iComunicaFragments;
import com.example.holaesatproyecto.api.Apis;
import com.example.holaesatproyecto.api.ServiceProducto;
import com.example.holaesatproyecto.modelo.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentEntradasTiki extends Fragment implements RecyclerAdaptadorPlatos.RecyclerIntemClick {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //Variables********************************

   List<Producto> listaProducto ;
   // ArrayList<Producto> productoLista;
   ProgressDialog progress;
    JsonObjectRequest jsonObjectRequest;
   RecyclerAdaptadorPlatos adaptadorPlatos;
    RecyclerView recyclerView;

    Activity actividad;
    iComunicaFragments interfaceComunicaFragments;


    public FragmentEntradasTiki() {
        // Required empty public constructor
    }


    public static FragmentEntradasTiki newInstance(String param1, String param2) {
        FragmentEntradasTiki fragment = new FragmentEntradasTiki();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup vista=(ViewGroup) inflater.inflate(R.layout.fragment_entradas_tiki,container,false);

        //recyclerProductos=(RecyclerView)vista.findViewById(R.id.RecyclerIdPlato);
        recyclerView=vista.findViewById(R.id.RecyclerIdPlato);
       // getPosts();
        listaProducto =new ArrayList<>();
        verProductos();
        LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);

        adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaProducto,this);
        recyclerView.setAdapter(adaptadorPlatos);

        return vista;

    }
    private  void initValues(){

        //LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
        //recyclerView.setLayoutManager(manager);
        //getItemsSQL();
    }
    public void verProductos(){
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
        listaProducto.add(new Producto("1","12","Cochas",R.drawable.ceviche_de_concha,null,"Marizco","Con camrones",23,10));
    }

   private void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.210:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceProducto service =retrofit.create(ServiceProducto.class);
       retrofit2.Call<List<Producto>> call =service.productos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                List<Producto> post=response.body();

                for (Producto m: post){
                    String content="";
                    Producto p=new Producto();
                    p.setNombre_producto(m.getNombre_producto());
                    System.out.println(m.getNombre_producto()+"VERRR LISTAAAAAAAAAAAAAAAAAAA");

                    listaProducto.add(p);

                }

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });


    }
    private void getItemsSQL() {
        ServiceProducto service = Apis.getInstance().create(ServiceProducto.class);
        retrofit2.Call<List<Producto>> call =service.productos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                listaProducto=response.body();
                //adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaProducto, this);
                recyclerView.setAdapter(adaptadorPlatos);
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }



    @Override
    public void itemClick(Producto producto) {
        Intent intent= new Intent(getContext() ,ActividadDetallePlato.class);
        intent.putExtra("itemDetalle",producto); //Cualquier n ombre en put extra
        startActivity(intent);
    }
}