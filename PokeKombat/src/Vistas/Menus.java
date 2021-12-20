package Vistas;

import java.util.Scanner;

public class Menus {
	
	public static void menuPrincipal() {
		System.out.println("                   Bienvenido");
		
		
	}
	
	public static void menuSelectPersonaje() {
		System.out.println("Pulsa 0 para elegir a Spike");
		System.out.println("Pulsa 1 para elegir a Malko");
		System.out.println();
	}
	
	public static void menuLucha() {
		System.out.println();
		System.out.println("1: Atacar                   2: defender");
		System.out.println("3: Curar                    4: huir");
	}
	
	public static void introduccion() {
		System.out.println();
		System.out.println("Preparate para luchar");
		System.out.println();
		System.out.println("lucharas contra: ");
	}
	
	public static void pausa() {
		Scanner teclado = new Scanner (System.in);
		System.out.println("\n\t\tPULSA ENTER PARA SEGUIR\n");
		teclado.nextLine();
	}
}
