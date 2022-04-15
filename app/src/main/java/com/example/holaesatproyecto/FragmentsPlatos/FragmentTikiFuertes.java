package com.example.holaesatproyecto.FragmentsPlatos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.holaesatproyecto.ActividadDetallePlato;
import com.example.holaesatproyecto.R;
import com.example.holaesatproyecto.adaptadores.RecyclerAdaptadorPlatos;
import com.example.holaesatproyecto.api.ServiceProducto;
import com.example.holaesatproyecto.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTikiFuertes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTikiFuertes extends Fragment implements RecyclerAdaptadorPlatos.RecyclerIntemClick {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Producto> listaproducto;

    RecyclerView recyclerView;
    RecyclerAdaptadorPlatos adaptadorPlatos;

    public FragmentTikiFuertes() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentTikiFuertes newInstance(String param1, String param2) {
        FragmentTikiFuertes fragment = new FragmentTikiFuertes();
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
       View view= inflater.inflate(R.layout.fragment_tiki_fuertes, container, false);


        recyclerView=view.findViewById(R.id.RecyclerIdPlato);

        getItemsSQL();

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adaptadorPlatos=new RecyclerAdaptadorPlatos(getContext(),listaproducto,this  );

        recyclerView.setAdapter(adaptadorPlatos);
       return view;
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
                    producto.setNombre(producto.getNombre());
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
}