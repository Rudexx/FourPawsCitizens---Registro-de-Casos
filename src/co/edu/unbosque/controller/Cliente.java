package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    String serverAddress;
    Scanner in;
    PrintWriter out;
    JFrame frame;
    JTextField textField = new JTextField(50);
    JTextArea messageArea = new JTextArea(16, 50);
    Servidor server;
    String linea = "";
    

    /**
     * Constructs the client by laying out the GUI and registering a listener with
     * the textfield so that pressing Return in the listener sends the textfield
     * contents to the server. Note however that the textfield is initially NOT
     * editable, and only becomes editable AFTER the client receives the
     * NAMEACCEPTED message from the server.
     */
    public Cliente(String serverAddress) {
    	frame = new JFrame();
        this.serverAddress = serverAddress;

        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.pack();

        // Send on enter then clear to prepare for next message
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }

    private String getName() {
        return "Usuario";
    }

    private void run() throws IOException {
        try {
            var socket = new Socket(serverAddress, 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            
            
            try {
            	linea = in.nextLine();
            	JOptionPane.showMessageDialog(null, linea);
            	out.println(linea);
            	var cliente = new Cliente("127.0.0.1");
		        cliente.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        cliente.frame.setVisible(false);
		        
		        while (in.hasNextLine()) {
	                var line = in.nextLine();
	                if (line.startsWith("SUBMITNAME")) {
	                    out.println(getName());
	                } else if (line.startsWith("NAMEACCEPTED")) {
	                    this.frame.setTitle("Chatter - Usuario" );
	                    textField.setEditable(true);
	                } else if (line.startsWith("MESSAGE")) {
	                    messageArea.append(line.substring(8) + "\n");
	                }
	            }

            }catch (Exception e) {
				System.out.println("No existe ningun agente conectado, intente mas tarde");
			       ArrayList<Caso> casos = new ArrayList();
			        boolean ejecutar = true;
			        while (ejecutar == true){
			            System.out.println("Bienvenidos a animales de 4 patas");
			            var scanner = new Scanner(System.in);
			            System.out.println("1.-Crear Caso\n" +
			                    "2.-Hablar con agente\n" +
			                    "3. Ver casos creados\n" +
			                    "4.-Salir"
			            );
			            var seleccion = scanner.nextLine();
			            if (seleccion.equals("1") ) {
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
			                if (seleccion.equalsIgnoreCase("Si")) {
			                    ejecutar = true;
			                } else if (seleccion.equalsIgnoreCase("No")) {
			                    System.exit(0);
			                } else {
			                    System.out.println("Accion No reconocida");
			                    System.out.println("Adios");
			                    System.exit(0);
			                }
			            } else if (seleccion.equalsIgnoreCase("2")) {
			            	 
			            	try {
			            		var cliente = new Cliente("127.0.0.1");
			            		 cliente.run();
					                cliente.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					                cliente.frame.setVisible(true);        
			            	}catch (Exception e1) {
			            		ejecutar = true;
			            		
							}
			               
			            } else if (seleccion.equalsIgnoreCase("3")) {
			                if (casos.size() != 0) {
			                    for (int i = 0; i < casos.size(); i++) {
			                        System.out.println(casos.get(i).toString());
			                    }
			                } else {
			                    System.out.println("No se ha creado ningún caso aún");
			                }
			            } else if (seleccion.equals("4")) {
			                System.out.println("Adios");
			                System.exit(0);
			            } else {
			                System.out.println("Accion no reconocida");
			            }
			        }
			}
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Caso> casos = new ArrayList();
        boolean ejecutar = true;
        while (ejecutar == true){
            System.out.println("Bienvenidos a animales de 4 patas");
            var scanner = new Scanner(System.in);
            System.out.println("1.-Crear Caso\n" +
                    "2.-Hablar con agente\n" +
                    "3. Ver casos creados\n" +
                    "4.-Salir"
            );
            var seleccion = scanner.nextLine();
            if (seleccion.equals("1") ) {
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
                if (seleccion.equalsIgnoreCase("Si")) {
                    ejecutar = true;
                } else if (seleccion.equalsIgnoreCase("No")) {
                    System.exit(0);
                } else {
                    System.out.println("Accion No reconocida");
                    System.out.println("Adios");
                    System.exit(0);
                }
            } else if (seleccion.equalsIgnoreCase("2")) {
                ejecutar = false;
            } else if (seleccion.equalsIgnoreCase("3")) {
                if (casos.size() != 0) {
                    for (int i = 0; i < casos.size(); i++) {
                        System.out.println(casos.get(i).toString());
                    }
                } else {
                    System.out.println("No se ha creado ningún caso aún");
                }
            } else if (seleccion.equals("4")) {
                System.out.println("Adios");
                System.exit(0);
            } else {
                System.out.println("Accion no reconocida");
            }
        }
        
    
    }
}