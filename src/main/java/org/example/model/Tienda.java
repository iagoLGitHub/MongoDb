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


}
