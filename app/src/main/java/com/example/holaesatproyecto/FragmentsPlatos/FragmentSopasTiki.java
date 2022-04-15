package com.example.holaesatproyecto.FragmentsPlatos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.holaesatproyecto.ActividadDetallePlato;
import com.example.holaesatproyecto.R;
import com.example.holaesatproyecto.adaptadores.RecyclerAdaptadorPlatos;
import com.example.holaesatproyecto.api.Apis;
import com.example.holaesatproyecto.api.ServiceProducto;
import com.example.holaesatproyecto.modelo.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentSopasTiki extends Fragment implements RecyclerAdaptadorPlatos.RecyclerIntemClick {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
  //// ATRIBUTOSSSSSSSSSSSS

    ArrayAdapter  arrayAdapter;
    private List<Producto> listaproducto;

    RecyclerView recyclerView;
    RecyclerAdaptadorPlatos adaptadorPlatos;
    public static String JSON_URL="http://192.168.100.210:8080/api/productos/1";

    public FragmentSopasTiki() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentSopasTiki newInstance(String param1, String param2) {
        FragmentSopasTiki fragment = new FragmentSopasTiki();
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
        View vista=inflater.inflate(R.layout.fragment_entradas_tiki, container, false);





        recyclerView=vista.findViewById(R.id.RecyclerIdPlato);

        getItemsSQL();

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaproducto,this  );

       recyclerView.setAdapter(adaptadorPlatos);
        return vista;

    }
    private void getItemsSQL()  {
        listaproducto=new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.210:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceProducto json = retrofit.create(ServiceProducto.class);
        //Call<List<Producto>> call = json.productos();
        Call<List<Producto>> call =json.productos();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                List<Producto> post = response.body();
                for (Producto producto : post) {
                    producto.setNombre_producto(producto.getNombre_producto());
                    listaproducto.add(producto);
                }
                System.out.println(listaproducto.size()+ " iiiiiiiiiiiiiiiiiiiiiddddddd");

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });

    }

    @Override
    public void itemClick(Producto producto) {
        Intent intent= new Intent(getContext() , ActividadDetallePlato.class);
        intent.putExtra("itemDetalle",producto); //Cualquier n ombre en put extra
        startActivity(intent);

    }
  /* public void cargarPlatos(){
      //  RequestQueue reques=Volley.newRequestQueue(getContext());


       JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
               (Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {

                   @Override
                   public void onResponse(JSONArray response) {

                       for (int i = 0; i < response.length(); i++) {
                           JSONObject objeto ;
                           Producto producto = new Producto();

                           try {
                               objeto=response.getJSONObject(i);
                               producto.setNombre_producto(objeto.getString("nombre"));
                               //producto.setFoto(objeto.getString("foto"));
                               listaproducto.add(producto);
                               System.out.println( objeto.getString("nombre")+"LLISTAAAAAAAAAAAAAAAAAAAAA");
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }

                           arrayAdapter.notifyDataSetChanged();

                       }


                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       Log.d("tag", "onErrorResponse: "+error.getMessage());
                   }
               });
           Volley.newRequestQueue(getContext()).add(jsonArrayRequest);

           }*/




}