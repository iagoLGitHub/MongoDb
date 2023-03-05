package controller;

import view.MenuPrincipal;

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
        }
    }


}
