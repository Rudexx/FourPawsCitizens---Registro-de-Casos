package co.edu.unbosque.controller;

import java.io.IOException;
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
