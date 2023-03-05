package controller;

import crud.RepositoryClient;
import crud.RepositoryFactura;
import model.Cliente;
import model.Factura;
import org.bson.types.ObjectId;
import view.MenuFactura;
import view.MenuPrincipal;

import java.util.Scanner;

public class ControllerMenuFactura {


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
        opcion=bf.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el cliente de la factura");
                bf.nextLine();
                String nombre=bf.nextLine();

                factura.listaFacturaCliente(nombre);
                break;

        }

    }

    public void buscarListaFactura(String nombre){




    }


    public void crearFactura() {
        Scanner bf = new Scanner(System.in);
        RepositoryClient rCliente=new RepositoryClient();
        RepositoryFactura rFactura=new RepositoryFactura();

        System.out.println("Introduce el cliente de la factura");
        String nombre=bf.nextLine();

        Cliente cliente=rCliente.buscarCliente(nombre);
        if (cliente != null) {
            System.out.println("Introduce el codigo");
            String codigo = bf.nextLine();
            System.out.println("Introduce el año");
            int year= bf.nextInt();
            System.out.println("introduce descripción");
            bf.nextLine();
            String descripcion = bf.nextLine();
            System.out.println("Introduce una observación");
            String observacion= bf.nextLine();
            Factura factura=new Factura(codigo,year,descripcion,observacion);

            rFactura.crearFacturaCliente(cliente,factura);


        }

        }





    }



