package model;

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
    @BsonProperty(value = "facturas")
    private List<Factura> facturas;

    public Cliente() {
        facturas = new ArrayList<>();
    }

    public Cliente(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        facturas = new ArrayList<>();
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

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }
}