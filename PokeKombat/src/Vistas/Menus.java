package Vistas;

import java.util.Scanner;

public class Menus {
	

	
	public static void menuPrincipal() {
		System.out.println();
		System.out.println("\t\tMenu \n\t     Principal");
		System.out.println();
		System.out.println("Pulse 1 para jugar contra otro jugador");
		System.out.println("Pulse 2 para jugar contra la máquina");
		System.out.println("Pulse 3 para ver todos los personajes");
		System.out.println("Pulse 0 para salir");
	}
	
	public static void seleccionar() {
		System.out.println();
		System.out.println("Pulse 1 para ver los guerreros");
		System.out.println("Pulse 2 para ver a los magos");
		System.out.println("Pulse 0 para salir");
	}
	
	public static void menuSelectPersonaje() {
		System.out.println("Pulsa 0 para elegir a Spike");
		System.out.println("Pulsa 1 para elegir a Malko");
		System.out.println();
		System.out.println("Selecciona un personaje: ");
	}
	
	public static void menuLucha() {
		System.out.println();
		System.out.println("1: Atacar                   2: defender");
		System.out.println("3: Curar                    4: huir");
	}
	

	
}
