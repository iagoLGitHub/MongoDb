package org.example.controller;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.example.Main;
import org.example.crud.RepositoryClient;
import org.example.crud.RepositoryProduct;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.example.view.MenuPrincipal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ControllerMenuPrincipal {
    MenuPrincipal menu = new MenuPrincipal();




    public ControllerMenuPrincipal() {
    }

    public void controllerPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        menu.menuPrincipal();

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                ControllerMenuCliente cliente = new ControllerMenuCliente();
                cliente.controllerMenuCliente();

                break;

            case 2:
                ControllerMenuFactura factura= new ControllerMenuFactura();
                factura.controllerMenuFactura();
                break;
            case 4:
                MongoClient mongoClient = new MongoClient();
                MongoDatabase database = mongoClient.getDatabase("comercioDB");

                try {


//                    Files.readAllLines(Path.of(Objects.requireNonNull(Main.class.getResource("json/clientes.json")).getPath()));
//                    String jsonCliente = new String(Files.readAllBytes(Paths.get("../../resources/json/clientes.json")));
//                    String jsonProducto = new String(Files.readAllBytes(Paths.get("../../resources/json/productos.json")));
//                    JSONParser parser = new JSONParser();
//                    SONObject jsonObject = (JSONObject) parser.parse(jsonCliente);J
//                    JSONParser parser2 = new JSONParser();
//                    JSONObject jsonObject2 = (JSONObject) parser2.parse(jsonProducto);
//                    Document document = Document.parse(jsonObject.toJSONString());
//                    Document document2 = Document.parse(jsonObject2.toJSONString());
//                    RepositoryClient rCliente=new RepositoryClient();
//                    rCliente.insertarJson(document);
//                    RepositoryProduct rProducto=new RepositoryProduct();
//                    rProducto.insertarJson(document2);
//                    System.out.println("Guardado");

//                    JSONParser jsonParser = new JSONParser();
//
//                    try (Reader rdClientes = new FileReader(Objects.requireNonNull(Main.class.getResource("json/clientes.json")).getFile());
//                         Reader rdProductos = new FileReader(Objects.requireNonNull(Main.class.getResource("json/productos.json")).getFile())) {
//                        database.createCollection("clientes");
//                        database.createCollection("productos");
//                        JSONArray jsonClientes = (JSONArray) jsonParser.parse(rdClientes);
//
//
//                        JSONArray jsonProductos = (JSONArray) jsonParser.parse(rdProductos);
//                        Document document = Document.parse(jsonClientes.toJSONString());
//                        Document document2 = Document.parse(jsonProductos.toJSONString());
//                        RepositoryClient rCliente=new RepositoryClient();
//                        rCliente.insertarJson(document);
//                        jsonClientes.
//                        RepositoryProduct rProducto=new RepositoryProduct();
//                        rProducto.insertarJson(document2);
//                        System.out.println("Guardado");
//                    }catch (Exception e){
//                        e.printStackTrace();
//                        System.out.println(e);
////                    }



                }catch (Exception e){
                    System.out.println(e);
                }
        }
    }


}
