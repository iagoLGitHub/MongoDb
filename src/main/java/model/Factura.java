package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Factura {
    @BsonId
    private String id;
    @BsonProperty(value = "descripcion")
    private String descripcion;
    @BsonProperty(value = "observacion")
    private String observacion;
    @BsonProperty(value = "productos")
    private List<Producto> productos;

    public Factura() {
        productos = new ArrayList<>();
    }

    public Factura(String id, String descripcion, String observacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.observacion = observacion;
        productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @BsonProperty(value = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @BsonProperty(value = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @BsonProperty(value = "productos")
    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}