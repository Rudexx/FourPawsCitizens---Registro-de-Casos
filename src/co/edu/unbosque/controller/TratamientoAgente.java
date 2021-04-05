package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TratamientoAgente implements Runnable {

    private Socket socket;

    public TratamientoAgente(Socket socket) {
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
                safePrintln("Hola estoy aca");
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

    public void safePrintln(String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }
}
