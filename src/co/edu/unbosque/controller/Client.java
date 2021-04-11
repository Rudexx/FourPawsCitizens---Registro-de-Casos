package co.edu.unbosque.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A simple Swing-based client for the chat server. Graphically it is a frame
 * with a text field for entering messages and a textarea to see the whole
 * dialog.
 *
 * The client follows the following Chat Protocol. When the server sends
 * "SUBMITNAME" the client replies with the desired screen name. The server will
 * keep sending "SUBMITNAME" requests as long as the client submits screen names
 * that are already in use. When the server sends a line beginning with
 * "NAMEACCEPTED" the client is now allowed to start sending the server
 * arbitrary strings to be broadcast to all chatters connected to the server.
 * When the server sends a line beginning with "MESSAGE" then all characters
 * following this string should be displayed in its message area.
 */
 public class Client {
	 static ArrayList<Caso> casos = new ArrayList();
    String serverAddress;
    Scanner in;
    PrintWriter out;
    JFrame frame = new JFrame("Chatter");
    JTextField textField = new JTextField(50);
    JTextArea messageArea = new JTextArea(16, 50);

    /**
     * Constructs the client by laying out the GUI and registering a listener with
     * the textfield so that pressing Return in the listener sends the textfield
     * contents to the server. Note however that the textfield is initially NOT
     * editable, and only becomes editable AFTER the client receives the
     * NAMEACCEPTED message from the server.
     */
    public Client(String serverAddress) {
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
        return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void run() throws IOException {
        try {
            var socket = new Socket(serverAddress, 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            String option = askClient();
            
            if(option.equals("Crear Caso")) {


               
               
               System.out.println("hola");

        
               System.out.println("  -------Creacion del caso--------\n" +
                       "Ingrese si fue\n" +
                       "1.- Robo\n" +
                       "2.- perdida\n" +
                       "3.- Abandono\n" +
                       "4.- Animal Peligroso\n" +
                       "5.- Manejo indebido"
               );
               
             	 var scanner = new Scanner(System.in);
                	var seleccion = scanner.nextLine();
               
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
               System.out.println("¿Desea realizar añadir otro caso?" + "\nSi" + "\nNo");
               seleccion = scanner.nextLine();
               if (seleccion.equalsIgnoreCase("Si")) {
                 createCase(in, out);
               } else if (seleccion.equalsIgnoreCase("No")) {
               	return;
               } else {

               }
           	
            }else if(option.equals("Hablar con agente")) {
            	this.frame.setVisible(true);
            	while (in.hasNextLine()) {
                    var line = in.nextLine();
                    if (line.startsWith("SUBMITNAME")) {
                        out.println(getName());
                    } else if (line.startsWith("NAMEACCEPTED")) {
                        this.frame.setTitle("Chatter - " + line.substring(13));
                        textField.setEditable(true);
                    } else if (line.startsWith("MESSAGE")) {
                        messageArea.append(line.substring(8) + "\n");
                    }
                }
            }else {
            	
            }
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {

    	
    	var client = new Client("25.119.209.58");
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(false);
    	client.run();

    }
    
    
    public static void createCase(Scanner in, PrintWriter out) throws UnknownHostException, IOException {
    	

    	
    	
    }
    
    public static String askClient() {
    	
    	JOptionPane.showMessageDialog(null, "Bienvenido a animales de 4 patas");
    	//i solved my problem adding the following 2 lines of code...
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        Object[] options = {"Crear Caso", "Hablar con agente", "Ver casos creados"};
        //...and passing `frame` instead of `null` as first parameter
        Object selectionObject = JOptionPane.showInputDialog(frame, "Escoja una opcion a continuación", "Menú", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();
        return selectionString;
    }
}

