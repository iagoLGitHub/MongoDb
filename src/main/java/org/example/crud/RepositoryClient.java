package org.example.crud;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.example.model.Cliente;
import org.bson.Document;
import org.bson.types.ObjectId;

public class RepositoryClient {

    MongoClient conexion;
    MongoDatabase db;
    MongoCollection<Document> lista;

    public RepositoryClient() {
        try {
            conexion = new MongoClient();
            db = conexion.getDatabase("comercioDB");
            lista = db.getCollection("clientes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listaClientes() {
        lista.find().forEach((Block<? super Document>) (Document doc) -> System.out.println(doc.toJson()));
        System.out.println();
    }

    public Cliente buscarCliente(String nombre) {

        Document query = new Document("nombre", nombre);
        Document result = lista.find(query).first();


        // Imprime los resultados
        if (result == null) {
            System.out.println("No se encontraron resultados para " + nombre);
            return null;
        } else {
            System.out.println("Resultados para " + nombre + ":");

            ObjectId id = result.getObjectId("_id");
            String nombreCliente = result.getString("nombre");
            String apellidos = result.getString("apellidos");
            String email = result.getString("email");

            Cliente cliente = new Cliente(id, nombreCliente, apellidos, email);


            System.out.println(cliente.toString());
            return cliente;
        }

    }

    /**
     * Crea un cliente
     * @param cliente
     */
    public void insertarCliente(Cliente cliente) {
        try {

            Document documento = new Document("nombre", cliente.getNombre())
                    .append("apellidos", cliente.getApellidos())
                    .append("email", cliente.getEmail());
            System.out.println(documento.toJson());
            lista.insertOne(documento);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * Modifica un cliente
     * @param cliente
     */
    public void modificarCliente(Cliente cliente) {
        // Crear un objeto Document con los nuevos valores a actualizar
        Document updateDocument = new Document("$set", new Document("nombre", cliente.getNombre())
                .append("apellidos", cliente.getApellidos())
                .append("email", cliente.getEmail()));

        // Crear un objeto UpdateOptions para especificar las opciones de actualización
        UpdateOptions updateOptions = new UpdateOptions().upsert(true);

        // Actualizar el documento en la base de datos
        UpdateResult result = lista.updateOne(new Document("_id",cliente.getId()), updateDocument, updateOptions);

        // Imprimir un mensaje indicando si el documento fue actualizado o no
        if (result.getMatchedCount() > 0) {
            System.out.println("El cliente con ID " + cliente.getId() + " ha sido actualizado.");
        } else if (result.getUpsertedId() != null) {
            System.out.println("Se ha insertado un nuevo cliente con ID " + result.getUpsertedId() + ".");
        } else {
            System.out.println("No se encontró ningún cliente con ID " + cliente.getId()+ ".");
        }
    }

    /**
     * Elimina el cliente dandole su nombre
     * @param nombre
     */
    public void eliminarCliente(String nombre){

        DeleteResult result= lista.deleteOne(Filters.eq("nombre", nombre));

        if (result.getDeletedCount() >0){
            System.out.println("El cliente con nombre " + nombre + " ha sido borrado de la base de datos.");

        } else {
            System.out.println("No se encontró ningún cliente con el nombre " + nombre + ".");
        }
    }

    public void insertarJson(Document document){

       lista.insertOne(document);


    }
}