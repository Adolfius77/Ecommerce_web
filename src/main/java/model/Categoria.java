/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.bson.types.ObjectId;

/**
 * Categoría del catálogo (colección Mongo: categoria).
 */
public class Categoria {

    private ObjectId _id;
    private String nombre;
    private String descripcion;

    public Categoria() {
    }

    public Categoria(ObjectId _id, String nombre, String descripcion) {
        this._id = _id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
