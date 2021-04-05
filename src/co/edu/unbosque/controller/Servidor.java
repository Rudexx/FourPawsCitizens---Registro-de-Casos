package co.edu.unbosque.controller;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Servidor {

    public static void main(String[] args) throws Exception {

        try (var listener = new ServerSocket(59897)) {

            System.out.println("El server esta corriendo: ");

            var pool = Executors.newFixedThreadPool(20);

            while (true) {
                pool.execute(new Tratamiento(listener.accept()));
            }

        }

    }

}
