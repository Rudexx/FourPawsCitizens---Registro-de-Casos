package co.edu.unbosque.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws Exception {

        try (var socket = new Socket("127.0.0.1", 59897)) {
            ArrayList<Caso> casos = new ArrayList();
            try (var socket = new Socket("127.0.0.1", 59897)) {

                System.out.println("Connected: " + socket);
                System.out.println("Bienvenidos a animales de 4 patas");
                var scanner = new Scanner(System.in);
                System.out.println("""
                        1.-Crear Caso
                        2.-Hablar con agente
                        3.-Salir""");
                var seleccion = scanner.nextLine();
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                if (seleccion.equals("1")) {
                    System.out.println("""
                            -------Creacion del caso--------
                             Ingrese si fue
                            1.- Robo
                            2.- perdida
                            3.- Abandono
                            4.- Animal Peligroso
                            5.- Manejo indebido""");
                    System.out.println("Introduzca La opcion que desea hacer: ");
                    seleccion = scanner.nextLine();
                    casos.add(new Caso(seleccion));
                    System.out.println("Escriba la especie de la mascota");
                    String item = scanner.nextLine();
                    casos.get(1).setEspecie(item);
                    System.out.println("Escriba el tamaño de la mascota");
                    item = scanner.nextLine();
                    casos.get(1).setTamaño(item);
                    System.out.println("Escribe la localidad de la mascota");
                    System.out.println("Escribe la direccion de la mascota");
                    System.out.println("Escriba Su Nombre");
                    System.out.println("Escriba Su Telefono");
                    System.out.println("Escriba su Email");
                    System.out.println("Comentarios Generales");

                } else if (seleccion.equals("2")) {

                } else {

                }

                while (scanner.hasNextLine()) {
                    out.println(scanner.nextLine());
                    System.out.println("Transformed message: " + in.nextLine());
                }

            }

        }

    }
}
