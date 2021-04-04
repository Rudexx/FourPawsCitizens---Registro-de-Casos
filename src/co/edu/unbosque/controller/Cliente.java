package co.edu.unbosque.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws Exception {
            ArrayList<Caso> casos = new ArrayList();
            try (var socket = new Socket("127.0.0.1", 59897)) {

                System.out.println("Connected: " + socket);
                System.out.println("Bienvenidos a animales de 4 patas");
                var scanner = new Scanner(System.in);
                System.out.println(" 1.-Crear Caso\r\n" + 
                		"                        2.-Hablar con agente\r\n" + 
                		"                        3.-Salir"
                     );
                var seleccion = scanner.nextLine();
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                if (seleccion.equals("1")) {
                    System.out.println("  -------Creacion del caso--------\r\n" + 
                    		"                             Ingrese si fue\r\n" + 
                    		"                            1.- Robo\r\n" + 
                    		"                            2.- perdida\r\n" + 
                    		"                            3.- Abandono\r\n" + 
                    		"                            4.- Animal Peligroso\r\n" + 
                    		"                            5.- Manejo indebido"
                          );
                    System.out.println("Introduzca La opcion que desea hacer: ");
                    seleccion = scanner.nextLine();
                    casos.add(new Caso(seleccion));
                    System.out.println("Escriba la especie de la mascota");
                    String item = scanner.nextLine();
                    casos.get(0).setEspecie(item);
                    System.out.println("Escriba el tamaño de la mascota");
                    item = scanner.nextLine();
                    casos.get(0).setTamano(item);
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
