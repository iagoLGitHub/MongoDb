package org.example.model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Tienda {

    @BsonId
    private ObjectId id;
    @BsonProperty(value = "nombre")
    private String nombre;

    @BsonProperty(value = "direccion")
    private String direccion;

    public ObjectId getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Tienda(ObjectId id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
