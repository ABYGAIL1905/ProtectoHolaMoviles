package com.example.holaesatproyecto.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private String id_producto;
    private String id_menu;
    private String nombre_producto;
    private int foto_producto;
    private String foto;
    private String categoria;
    private String descripcion_producto;
    private double precio_producto;
    private  int stock_producto;

    public Producto() {

    }

    public Producto(String id_producto, String id_menu, String nombre_producto, int foto_producto, String foto, String categoria, String descripcion_producto, double precio_producto, int stock_producto) {
        this.id_producto = id_producto;
        this.id_menu = id_menu;
        this.nombre_producto = nombre_producto;
        this.foto_producto = foto_producto;
        this.foto = foto;
        this.categoria = categoria;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.stock_producto = stock_producto;
    }

    public Producto(int foto_producto) {
        this.foto_producto = foto_producto;
    }

    public Producto(String foto,String nombre_producto) {
        this.foto = foto;
        this.nombre_producto=nombre_producto;
    }

    public int getFoto_producto() {
        return foto_producto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFoto_producto(int foto_producto) {
        this.foto_producto = foto_producto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }



    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }
}
