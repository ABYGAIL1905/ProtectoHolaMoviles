package com.example.holaesatproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.holaesatproyecto.FragmentsPlatos.FragmentEntradasTiki;
import com.example.holaesatproyecto.FragmentsPlatos.FragmentSopasTiki;
import com.example.holaesatproyecto.FragmentsPlatos.FragmentTikiFuertes;
import com.example.holaesatproyecto.FragmentsPlatos.FragmentTikiHouse;
import com.example.holaesatproyecto.FragmentsPlatos.FragmentTradicionales;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
        FragmentTransaction transaction;
        Fragment fentradas,fhouse,fsopas,ffuertes,ftradicional;
        CircleImageView img1,img2,img3,img4,img5;
        View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fentradas = new FragmentEntradasTiki();
        fhouse = new FragmentTikiHouse();
        fsopas = new FragmentSopasTiki();
        ffuertes = new FragmentTikiFuertes();
        ftradicional = new FragmentTradicionales();
        img1=(CircleImageView)findViewById(R.id.imgEntradas);
        img2=(CircleImageView)findViewById(R.id.imgHouse);

        //Reemplazar un fragmen por otro
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentprincipal, fentradas).commit();
    }




    public void onClick(View view){


        transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.imgEntradas:

                        transaction.replace(R.id.fragmentprincipal,fentradas);
                        transaction.addToBackStack(null);


                break;
            case R.id.imgHouse:

                       transaction.replace(R.id.fragmentprincipal,fhouse);
                       transaction.addToBackStack(null);

                break;
            case R.id.imgSopas:
                transaction.replace(R.id.fragmentprincipal,fsopas);
                transaction.addToBackStack(null);
                break;
            case R.id.imgFuertes:
                transaction.replace(R.id.fragmentprincipal,ffuertes);
                transaction.addToBackStack(null);
                break;
            case R.id.imgTradicional:
                transaction.replace(R.id.fragmentprincipal,ftradicional);
                transaction.addToBackStack(null);
                break;


        }
        transaction.commit();



    }
}