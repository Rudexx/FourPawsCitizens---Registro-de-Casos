package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatSoporte {
    String serverAddress;
    Scanner in;
    PrintWriter out;
    JFrame frame = new JFrame("ChatSoporte");
    JTextField textField = new JTextField(50);
    JTextArea messageArea = new JTextArea(16, 50);

    /**
	 * 
	 * Metodo Constructor de la clase. Asigna la locacion del server en el que se encuentra el socket
	 * @param serverAddress: direccion ip del servidor
	 * 
	 */
    
    public ChatSoporte(String serverAddress) {
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
    
    /**
   	 * 
   	 * retorna el nombre del agente que se conecta
   	 * @return un String con el nombre del agente de soporte
   	 * 
   	 */

    private String getName() {
        return "Soporte";
    }
    
    /**
   	 * 
   	 * comienza el hilo de ejecucion del socket
   	 * @throws IOException: una excepci�n si ocurre algun error al ejecutar el socket
   	 * 
   	 */

    private void run() throws IOException {
        try {
            var socket = new Socket(serverAddress, 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            
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
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    /**
   	 * 
   	 * Metodo main de la clase. Ejecuta la clase
   	 * @throws IOException: una excepci�n si ocurre algun error al ejecutar el socket
   	 * @param args: parametro del sistema operativo
   	 * 
   	 */
    
    public static void main(String[] args) throws Exception {
        var client = new ChatSoporte("127.0.0.2");
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}
