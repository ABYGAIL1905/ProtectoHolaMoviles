package com.example.holaesatproyecto.api;

import com.example.holaesatproyecto.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ServiceProducto {

    @GET("productos")
    Call<List<Producto>>productos();
}
