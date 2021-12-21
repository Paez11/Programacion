package Vistas;

import java.util.Scanner;

import Modelo.Personaje;

public class Imprimir {
	
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
	
	
}
