/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public class Producto {
    private ObjectId _id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String imagenProducto;
    private int stock;
    private String categoria;
    private List<reseña>listaResenas;
    
    public Producto() {
    }

    public Producto(ObjectId _id, String nombre, Double precio, String descripcion, String imagenProducto, int stock, String categoria, List<reseña> listaResenas) {
        this._id = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenProducto = imagenProducto;
        this.stock = stock;
        this.categoria = categoria;
        this.listaResenas = listaResenas;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<reseña> getListaResenas() {
        return listaResenas;
    }

    public void setListaResenas(List<reseña> listaResenas) {
        this.listaResenas = listaResenas;
    }
    
    
    
    
}
