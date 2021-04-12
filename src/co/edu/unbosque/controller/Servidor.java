package co.edu.unbosque.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;

public class Servidor {
    private static Set<String> names = new HashSet<>();
    


    private static Set<PrintWriter> writers = new HashSet<>();
    
    /**
   	 * Metodo main de la clase. Ejecuta la clase
   	 * @throws Exception una excepción si ocurre algun error al ejecutar el serverSocket o el pool de threads
   	 * @param args: parametro del sistema operativo
   	 */

    public static void main(String[] args) throws Exception {
        System.out.println("El servidor esta funcionando...");
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
            while (true) {
                pool.execute(new Handler(listener.accept()));
            }
        }
    }

    

    private static class Handler implements Runnable {
        private String name;
        private Socket socket;
        private Scanner in;
        private PrintWriter out;
        private boolean agente = false;

        
        /**
    	 * 
    	 * Metodo Constructor de la clase. asigna el socket que va a ser manejado
    	 * @param socket: el socket que será utilizado
    	 * 
    	 */

        public Handler(Socket socket) {
            this.socket = socket;
        }
        
        /**
       	 * 
       	 * comienza el hilo de ejecucion del socket. 
       	 * Tambien se encarga de asignar nombres a cada usuario y añadirlos al thread
       	 * 
       	 */

        public void run() {
            try {
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);
                
                var ip = socket.getLocalAddress();

                
                
                for (PrintWriter writer : writers) {
                	  for (String na: names) {
      					if(na.equals("Soporte")) {
      						agente = true;
      						writer.println("hola");
      					}
      				}         
                    
                }
                
              
                if(names.contains("Soporte") || ip.toString().equals("/127.0.0.2")) {
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.nextLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!name.isBlank() && !names.contains(name)) {
                        	
                        	if(name.equals("Soporte")) {
                        		 names.add(name);
                                 break;
                        	}else {
                        		Random r = new Random();
                        		name = "Usuario " + r.nextInt(10);
                        		 names.add(name);
                                 break;
                        	}
                           
                        }
                    }
                }


                out.println("NAMEACCEPTED " + name);
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + " se ha unido");
                }
                writers.add(out);


                while (true) {
                    String input = in.nextLine();
                    if (input.toLowerCase().startsWith("/quit")) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                      
                        writer.println(agente);
                    }
                    
                    
                  
                }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    writers.remove(out);
                }
                if (name != null) {
                    System.out.println(name + " se ha ido");
                    names.remove(name);
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + " se fué");
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

	
    
}