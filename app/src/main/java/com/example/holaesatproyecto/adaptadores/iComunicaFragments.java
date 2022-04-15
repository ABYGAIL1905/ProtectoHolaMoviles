package com.example.holaesatproyecto.adaptadores;

import com.example.holaesatproyecto.modelo.Producto;


public interface iComunicaFragments {
    //esta interface se encarga de realizar la comunicacion entre la lista de personas y el detalle
    public void enviarProducto(Producto producto); //se transportara un objeto de tipo persona
    //(En la clase Persona se implementa Serializable para poder transportar un objeteo a otro)
}
