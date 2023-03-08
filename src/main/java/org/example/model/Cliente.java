package org.example.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Cliente {
    @BsonId
    private ObjectId id;
    @BsonProperty(value = "nombre")
    private String nombre;
    @BsonProperty(value = "apellidos")
    private String apellidos;
    @BsonProperty(value = "email")
    private String email;

    @BsonProperty(value ="tienda")
    private Tienda tienda;
    @BsonProperty(value = "facturas")
    private List<Factura> facturas= new ArrayList<>();

    public Cliente() {
        facturas = new ArrayList<>();
    }


    public Cliente(ObjectId id, String nombre, String apellidos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Cliente(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    public Cliente(String nombre, String apellidos, String email,Tienda tienda) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tienda=tienda;
    }
    public Cliente(String nombre, String apellidos, String email, Factura factura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.facturas.add(factura);
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @BsonProperty(value = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @BsonProperty(value = "apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @BsonProperty(value = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @BsonProperty(value = "facturas")
    public List<Factura> getFacturas() {
        return facturas;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", tienda=" + tienda +
                '}';
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }
}