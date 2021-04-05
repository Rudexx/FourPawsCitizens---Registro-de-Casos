package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Tratamiento implements Runnable {

    private Socket socket;

    public Tratamiento(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        safePrintln("Connected: " + socket);

        try {

            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

            while (in.hasNextLine()) {
                var message = in.nextLine();
                safePrintln("El mensaje recibido es: " + message);
                var newMessage = message.toUpperCase();
                safePrintln("The message to be returned is: " + newMessage);
                out.println(newMessage);
                try {
                    Socket enviarmensaje = new Socket("127.0.0.2", 59897);
                    var inmensaje = new Scanner(enviarmensaje.getInputStream());
                    var outmensaje = new PrintWriter(enviarmensaje.getOutputStream());
                    outmensaje.println("Este mensaje viene de otro lugar creo");
                    ObjectOutputStream ELmensaje = new ObjectOutputStream(enviarmensaje.getOutputStream());
                    ELmensaje.writeObject(in.nextLine());
                    enviarmensaje.close();
                }catch (Exception e){

                }
            }
            /*try(Socket enviarmensaje = new Socket("127.0.0.1", 59897)){
                ObjectOutputStream ELmensaje = new ObjectOutputStream(enviarmensaje.getOutputStream());
                ELmensaje.writeObject(in.nextLine());
                enviarmensaje.close();
            }*/

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

    public void safePrintln(String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }
}
