package com.example.holaesatproyecto.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

    private Long idProducto;

    private String nombre;
    private Byte foto;
    private String categoria;
    private String descripcion;
    private Double precio;
    private Integer stock;

    public Producto(Long idProducto, String nombre, Byte foto, String categoria, String descripcion, Double precio, Integer stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.foto = foto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}