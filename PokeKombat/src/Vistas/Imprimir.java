package Vistas;

import java.util.Scanner;

import Modelo.Personaje;

public class Imprimir {
	
	public static void inicio() {
		System.out.println("\n\t\tBienvenido \n\t\t    a \n\t\tPokeKombat");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("PokeKombat es un juego de peleas por turnos.\n En este seleccionas unos de nuestros campeones que estan divididos en dos clases. \n"
				+ "Diponemos de dos modos de juego, \n uno para pelear contra otro jugador en la misma máquina y otro contra la cpu. \n"
				+ "En este modo dispondrá de dos modos de juego, normal, el \n cual reseteará tu vida para seguir jugando contra nuevos oponentes \n"
				+ "y heroico, que jugaras con la misma vida hasta \n el final. Si lo consigues obtendras una recompensa única.");
		System.out.println("----------------------------------------------------------------------------------------------------------");
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
	
	public static void batalla(Personaje p1,Personaje p2) {
		System.out.println();
		System.out.println(p2.getNombre()+" ha recibido un daño de: "+p1.ataqueFisico());
		System.out.println("vida restante de "+p2.getNombre()+" "+p2.getVida());
	}
	public static void salto() {
		System.out.println();
		System.out.println("--------------------------------------------------------");
	}
	public static void eleccion(Personaje p1) {
		System.out.println("Ha elegido a: \n"+p1);
	}
	
	public static void end() {
		System.out.println("\n\n\tFIN DE PROGRAMA");
	}
	
	public static void ganar(Personaje p1) {
		System.out.println("Derrotastes a "+p1.getNombre());
		System.out.println("\n\t\tVICTORIA");
	}
	public static void perder() {
		System.out.println("Te derrotaron");
		System.out.println("\n\t\tDERROTA");
	}
	
	public static void error() {
		System.out.println("error");
	}
	
}
