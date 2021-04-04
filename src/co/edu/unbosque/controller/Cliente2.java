package co.edu.unbosque.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente2 {
    static ArrayList<Caso> casos = new ArrayList();
    public static void main(String[] args) throws Exception {
            try (var socket = new Socket("127.0.0.1", 59897)) {

                System.out.println("Connected: " + socket);
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                funcionar(in, out);
            }
            }
            
                public static void funcionar(Scanner in, PrintWriter out){
                	
                var sc = in;
                var prin = out;
                
                
                System.out.println("Bienvenidos a animales de 4 patas");
                var scanner = new Scanner(System.in);
                System.out.println("1.-Crear Caso\n" + 
                		"2.-Hablar con agente\n" + 
                		"3. Ver casos creados\n" +
                		"4.-Salir"
                     );
                var seleccion = scanner.nextLine();
                if(seleccion.equals("1")) {
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
                    Caso c = new Caso(seleccion);
                    System.out.println("Escriba la especie de la mascota");
                    String item = scanner.nextLine();
                    c.setEspecie(item);
                    System.out.println("Escriba el tamaño de la mascota");
                    item = scanner.nextLine();
                    c.setTamano(item);
                    System.out.println("Escribe la localidad de la mascota");
                    item = scanner.nextLine();
                    c.setLocalidad(item);
                    System.out.println("Escribe la direccion de la mascota");
                    item = scanner.nextLine();
                    c.setDireccion(item);
                    System.out.println("Escriba Su Nombre");
                    item = scanner.nextLine();
                    c.setNombrePersona(item);
                    System.out.println("Escriba Su Telefono");
                    item = scanner.nextLine();
                    c.setTelefono(item);
                    System.out.println("Escriba su Email");
                    item = scanner.nextLine();
                    c.setEmail(item);
                    System.out.println("Comentarios Generales");
                    item = scanner.nextLine();
                    c.setComentarios(item);
                    casos.add(c);
                    System.out.println("El caso se ha creado con exito");
                    System.out.println("¿Desea realizar otra operacion?" + "\nSi" + "\nNo");
                    seleccion = scanner.nextLine();
                    if(seleccion.equalsIgnoreCase("Si")) {
                    	funcionar(sc, prin);
                    }
                } else if (seleccion.equalsIgnoreCase("No")) {

                } else {

                }
               
                }else if(seleccion.equalsIgnoreCase("2")) {
                	
                }else if(seleccion.equalsIgnoreCase("3")) {
                	
                if(casos.size() != 0) {	
                	for (int i = 0; i < casos.size(); i++) {
						System.out.println(casos.get(i).toString());
					}
                }else {
                	System.out.println("No se ha creado ningún caso aún");
                }
                }else {
                	
                }
                
                while (scanner.hasNextLine()) {
                    out.println(scanner.nextLine());
                    System.out.println("Transformed message: " + in.nextLine());
                }

            }

        }
