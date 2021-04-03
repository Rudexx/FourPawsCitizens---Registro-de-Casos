package co.edu.unbosque.controller;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		
	

		Scanner entrada = new Scanner(System.in);
		int opcion =0;
		System.out.println("1.- Crear Caso \n"
				+"2.-Hablar con agente\n"
				+"3.-Salir");
		opcion = entrada.nextInt();
		
		switch  (opcion){
		case 1:{
			System.out.println("-------Creacion del caso--------" +
						"\n Ingrese si fue\n"
						+"1.- Robo\n"
						+"2.- perdida\n"
						+"3.- Abandono\n");
			System.out.println("Introduzca La opcion que desea hacer: ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Elije un caso");
				System.out.println("Robo");
				System.out.println("Perdida");
				System.out.println("Abandono");
				System.out.println("Animal peligroso");
				System.out.println("Manejo indevido del propietario");
				
			}
			
				
		}
		
		
		
	}
	}

}
