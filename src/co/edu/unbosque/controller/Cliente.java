package co.edu.unbosque.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws Exception {

        try (var socket = new Socket("127.0.0.1", 59897)) {

            System.out.println("Conectado a: " + socket);
            System.out.println("Bienvenido a Ciudadanos de 4 Patas");
            System.out.println("Por favor escriba la operacion a realizar: \n" + "1) Crear caso" + "\n2) Hablar con un Agente");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);


            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("El mensaje transformado es: " + in.nextLine());
            }

        }

    }

}
