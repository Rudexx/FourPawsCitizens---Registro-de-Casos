package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Menu implements Runnable {
	
	  private Socket socket;
	  
	  public Menu(Socket s) {
		this.socket = s;
	  }
	

	
	public static void safePrintln(String s) {
        synchronized (System.out) {
            safePrintln(s);
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub


		
		try {

            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner entrada = new Scanner(System.in);
    		int opcion =0;
    		safePrintln("1.- Crear Caso \n"
    				+"2.-Hablar con agente\n"
    				+"3.-Salir");
    		opcion =in.nextInt();
    		
    		switch  (opcion){
    		case 1:
    			safePrintln("-------Creacion del caso--------" +
    						"\n Ingrese si fue\n"
    						+"1.- Robo\n"
    						+"2.- perdida\n"
    						+"3.- Abandono\n");
    			safePrintln("Introduzca La opcion que desea hacer: ");
    			opcion = entrada.nextInt();
    			switch (opcion) {
    			case 1:
    				safePrintln(" Elije un caso");
    				safePrintln("1. Robo");
    				safePrintln("2. Perdida");
    				safePrintln("3. Abandono");
    				safePrintln("4. Animal peligroso");
    				safePrintln("5. Manejo indebido del propietario");
    				
    				opcion = entrada.nextInt();
    				
    				
    				
    				safePrintln("¿Especie del animal?");
    				String especie = entrada.nextLine();
    				safePrintln("¿Tamaño del animal?");
    				String tamaño = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Localidad del animal?");
    				String localidad = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Dirección del animal?");
    				String direccion = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Nombre completo de la persona que reporta?");
    				String nombreP = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Teléfono de la persona que reporta?");
    				String telefonoP = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Email de la persona que reporta?");
    				String emailP = entrada.nextLine();
    				entrada.next();
    				safePrintln("¿Comentarios generales?");
    				String comentarios = entrada.nextLine();
    				entrada.next();

    				String tipocaso = "";
    				switch (opcion) {
					case 1:
						tipocaso = "Robo";
						break;
					case 2:
						tipocaso = "Pérdida";
						break;
					case 3:
						tipocaso = "Abandono";
						break;
					case 4:
						tipocaso = "Animal Peligroso";
						break;
					case 5:
						tipocaso = "Manejo indebido del propietario";
						break;
					default:
						break;
					}
    				
    				PetCase p = new PetCase();
    				p.setAddress(direccion);
    				p.setComments(comentarios);
    				p.setNeighbourhood(localidad);
    				p.setReporterEmail(emailP);
    				p.setReporterName(nombreP);
    				p.setReporterTelephone(telefonoP);
    				p.setSize(tamaño);
    				p.setSpecie(especie);
    				p.setType(tipocaso);

    			}
    			break;
    		case 2:
    			
    		}
		
        } catch (Exception e) {
            safePrintln("Error:" + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
            safePrintln("Closed: " + socket);
        }
	
		
		
	}
		
	}


