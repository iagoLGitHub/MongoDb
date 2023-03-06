package org.example.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class RepositoryProduct {

    MongoClient conexion;
    MongoDatabase db;
    MongoCollection<Document> lista;

    public RepositoryProduct() {
        try {
            conexion = new MongoClient();
            db = conexion.getDatabase("comercioDB");
            lista = db.getCollection("productos");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void insertarJson(Document document){
        lista.insertOne(document);
    }
}
