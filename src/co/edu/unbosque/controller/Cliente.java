package co.edu.unbosque.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    static ArrayList<Caso> casos = new ArrayList();
    public static void main(String[] args) throws Exception {
            try (var socket = new Socket("127.0.0.1", 59897)) {

                System.out.println("Connected: " + socket);
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                funcionar();
            }
            }
            
                public static void funcionar(){
                
                
                System.out.println("Bienvenidos a animales de 4 patas");
                var scanner = new Scanner(System.in);
                System.out.println("1.-Crear Caso\n" + 
                		"2.-Hablar con agente\n" + 
                		"3.-Salir"
                     );
                var seleccion = scanner.nextLine();
                if (seleccion.equals("1")) {
                    System.out.println("  -------Creacion del caso--------\n" + 
                    		"Ingrese si fue\n" + 
                    		"1.- Robo\n" + 
                    		"2.- perdida\n" + 
                    		"3.- Abandono\n" + 
                    		"4.- Animal Peligroso\n" + 
                    		"5.- Manejo indebido"
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
                    item = scanner.nextLine();
                    casos.get(0).setLocalidad(item);
                    System.out.println("Escribe la direccion de la mascota");
                    item = scanner.nextLine();
                    casos.get(0).setDireccion(item);
                    System.out.println("Escriba Su Nombre");
                    item = scanner.nextLine();
                    casos.get(0).setNombrePersona(item);
                    System.out.println("Escriba Su Telefono");
                    item = scanner.nextLine();
                    casos.get(0).setTelefono(item);
                    System.out.println("Escriba su Email");
                    item = scanner.nextLine();
                    casos.get(0).setEmail(item);
                    System.out.println("Comentarios Generales");
                    item = scanner.nextLine();
                    casos.get(0).setComentarios(item);
                    System.out.println("El caso se ha creado con exito");
                    System.out.println("¿Desea realizar otra operacion?" + "\nSi" + "\nNo");
                    seleccion = scanner.nextLine();
                    if(seleccion.equals("Si")) {
                    	funcionar();
                    }
                } else if (seleccion.equals("2")) {

                } else {

                }

                while (scanner.hasNextLine()) {
                    out.println(scanner.nextLine());
                    System.out.println("Transformed message: " + in.nextLine());
                }

            }

        }
