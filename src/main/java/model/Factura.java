package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Factura {
    @BsonId
    private String id;

    @BsonProperty(value="codigo")
    private String codigo;

    @BsonProperty(value="year")
    private int year;

    @BsonProperty(value = "descripcion")
    private String descripcion;
    @BsonProperty(value = "observacion")
    private String observacion;

    @BsonProperty(value="cliente")
    private Cliente cliente;
    @BsonProperty(value = "productos")
    private List<Producto> productos;

    public Factura() {
        productos = new ArrayList<>();
    }

    public Factura(String codigo, int year, String descripcion, String observacion) {

        this.codigo = codigo;
        this.year = year;
        this.descripcion = descripcion;
        this.observacion = observacion;

    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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