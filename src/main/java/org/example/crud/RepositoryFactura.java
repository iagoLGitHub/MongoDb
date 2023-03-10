package org.example.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import org.example.model.Cliente;
import org.example.model.Factura;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;


public class RepositoryFactura {

    MongoClient conexion;
    MongoDatabase db;
    MongoCollection<Document> listaFacturas;

    public RepositoryFactura() {
        try {

            conexion = new MongoClient();
            db = conexion.getDatabase("comercioDB");
            listaFacturas = db.getCollection("facturas");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void listaFacturaCliente(String nombre){
        List listaF;
        RepositoryClient c=new RepositoryClient();

        Document query = new Document("nombre", nombre);
        Document result = c.lista.find(query).first();


        // Imprime los resultados
        if (result == null) {
            System.out.println("No se encontraron resultados para " + nombre);

        } else {
            System.out.println("Resultados para " + nombre + ":");

            ObjectId id = result.getObjectId("_id");
            String nombreCliente = result.getString("nombre");
            String apellidos = result.getString("apellidos");
            String email = result.getString("email");
            listaF=result.getList("facturas",Document.class);
            System.out.println("Facturas de:"+nombre);
            for (Object factura : listaF) {
                System.out.println("Factura " + factura.toString());
            }

            Cliente cliente = new Cliente(id, nombreCliente, apellidos, email);

//            JsonWriterSettings settings = JsonWriterSettings.builder().indent(true).build();
//
//            Document document = new Document();
//
//            System.out.println(document.toJson(settings));

        }
    }

    public void buscarFacturaFechainferior(int fecha){
        RepositoryClient c=new RepositoryClient();
        Bson filtro=Filters.lt("fecha",fecha);


        // Realizaci??n de la b??squeda
        List<Document> result = c.lista.find(filtro).into(new ArrayList<Document>());

        for (Document doc : result) {
            System.out.println(doc);

        }
        // Imprimir los resultados en consola




    }
    public void buscarFacturaFechaSuperior(int fecha){
        RepositoryClient c=new RepositoryClient();


        Bson filtro= Filters.gt("fecha",fecha);



        // Realizaci??n de la b??squeda
        List<Document> result = c.lista.find(filtro).into(new ArrayList<>());

        for (Document doc : result) {
            System.out.println(doc);
        }

    }

    public void crearFacturaCliente(Cliente cliente, Factura factura){
        RepositoryClient c=new RepositoryClient();
        ObjectId id=new ObjectId();
        Document dFactura = new Document("codigo", factura.getCodigo())
                .append("fecha", factura.getYear())
                .append("descripcion",factura.getDescripcion())
                .append("observacion", factura.getObservacion());



        // Buscar el cliente por su ID y agregar la factura a su lista de facturas
        Document query = new Document("_id", cliente.getId());
        Document update = new Document("$push", new Document("facturas", dFactura));
        UpdateResult result=c.lista.updateOne(query, update);
        if (result.getMatchedCount() > 0) {
            System.out.println("La factura con id " + factura.getId() + " ha sido introducida.");

        } else {
            System.out.println("No se encontr?? ning??n cliente con ID " + cliente.getId()+ ".");
        }



    }





}
