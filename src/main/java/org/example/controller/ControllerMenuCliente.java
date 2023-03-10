package org.example.controller;

import org.bson.types.ObjectId;
import org.example.crud.RepositoryClient;
import org.example.model.Cliente;
import org.example.model.Tienda;
import org.example.view.MenuCliente;

import java.util.Scanner;

public class ControllerMenuCliente {


    MenuCliente menuCliente=new MenuCliente();
    Scanner sc = new Scanner(System.in);
    RepositoryClient cliente = null;
    int opcion;

    public ControllerMenuCliente() {
        this.menuCliente = new MenuCliente();
        this.cliente = new RepositoryClient();
    }



    public void controllerMenuCliente() {
        menuCliente.menuCliente();
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Clientes:");
                try {
                    cliente = new RepositoryClient();
                    cliente.listaClientes();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                break;


            case 2:
                System.out.println("Introduce el nombre del cliente");
                try {

                    String nombre;
                    cliente = new RepositoryClient();
                    sc.nextLine();
                    nombre = sc.nextLine();
                    cliente.buscarCliente(nombre);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                try {
                    sc.nextLine();
                    System.out.println("Introduce nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce apellidos");
                    String apellidos = sc.nextLine();
                    System.out.println("Introduce Email");
                    String email = sc.nextLine();
                    System.out.println("nombre de tienda");
                    String nombreTienda = sc.nextLine();
                    System.out.println("Direccion");
                    String direccion = sc.nextLine();
                    Cliente client = new Cliente(nombre, apellidos, email);
                    Tienda tienda=new Tienda(nombreTienda,direccion);
                    cliente = new RepositoryClient();
                    cliente.insertarCliente(client,tienda);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

            case 4:
                try {
                    sc.nextLine();
                    System.out.println("Introduce el nombre del cliente que quieres modificar");

                    cliente = new RepositoryClient();
                    String nombre = sc.nextLine();
                    Cliente client;
                    client= cliente.buscarCliente(nombre);
                    if (client!= null) {
                        System.out.println("Introduce nombre");
                        nombre = sc.nextLine();
                        System.out.println("Introduce apellidos");
                        String apellidos = sc.nextLine();
                        System.out.println("Introduce Email");
                        String email = sc.nextLine();
                        client.setNombre(nombre);
                        client.setApellidos(apellidos);
                        client.setEmail(email);
                        cliente.modificarCliente(client);

                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                try {
                    sc.nextLine();
                    cliente = new RepositoryClient();
                    System.out.println("Introduce el nombre del cliente que quieres borrar");
                    String nombre = sc.nextLine();
                    cliente.eliminarCliente(nombre);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

        }

    }
}
