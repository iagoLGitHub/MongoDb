package org.example.controller;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.example.crud.RepositoryClient;
import org.example.crud.RepositoryFactura;
import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.view.MenuFactura;

import java.util.Scanner;

public class ControllerMenuFactura {
    MongoClient conexion;
    MongoDatabase db;

    MenuFactura menuFactura = new MenuFactura();
    RepositoryFactura factura = null;


    public ControllerMenuFactura() {
        this.menuFactura = new MenuFactura();
        this.factura = new RepositoryFactura();
    }

    public void controllerMenuFactura() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        menuFactura.menuFactura();
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                busquedaFactura();

                break;
            case 2:

                crearFactura();
                break;
        }

    }


    public void busquedaFactura() {
        Scanner bf = new Scanner(System.in);
        int opcion = -1;
        menuFactura.menuFacturaBuscar();
        opcion = bf.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el cliente de la factura");
                bf.nextLine();
                String nombre = bf.nextLine();

                factura.listaFacturaCliente(nombre);
                break;

            case 2:
                System.out.println("");

                break;

            case 3:
                System.out.println("Introduce fecha");
                bf.nextLine();
                int fecha = bf.nextInt();
                factura.buscarFacturaFechaSuperior(fecha);
                break;
            case 4:

                System.out.println("Introduce fecha");
                bf.nextLine();
                int f = bf.nextInt();
                factura.buscarFacturaFechainferior(f);
                break;
        }

    }

    public void buscarListaFactura(String nombre) {


    }


    public void crearFactura() {
        Scanner bf = new Scanner(System.in);
        RepositoryClient rCliente = new RepositoryClient();
        RepositoryFactura rFactura = new RepositoryFactura();

        System.out.println("Introduce el cliente de la factura");
        String nombre = bf.nextLine();

        Cliente cliente = rCliente.buscarCliente(nombre);
        if (cliente != null) {
            System.out.println("Introduce el codigo");
            String codigo = bf.nextLine();
            System.out.println("Introduce el año");
            int year = bf.nextInt();
            System.out.println("introduce descripción");
            bf.nextLine();
            String descripcion = bf.nextLine();
            System.out.println("Introduce una observación");
            String observacion = bf.nextLine();
            Factura factura = new Factura(codigo, year, descripcion, observacion);

            rFactura.crearFacturaCliente(cliente, factura);


        }

    }


}



