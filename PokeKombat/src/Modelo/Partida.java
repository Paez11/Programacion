package Modelo;

import java.util.Arrays;

import Utils.Lee;
import Vistas.Menus;

public class Partida {
	private Personaje [] luchadores;
	static Personaje player1;
	static Personaje cpu;

	public Partida(Personaje[] luchador, int numLuchadores, String nombre) {
		this.luchadores = luchador;
		luchadores = new Personaje [numLuchadores];
		player1 = new Personaje();
		cpu = new Personaje();
	}

	public Personaje[] getLuchadores() {
		return luchadores;
	}

	public void setLuchadores(Personaje[] luchadores) {
		this.luchadores = luchadores;
	}
	
	
	public static void muestraPersonajes(Personaje [] luchadores) {
		for (int i = 0; i < luchadores.length; i++) {
			System.out.println(luchadores[i]);
			System.out.println();
		}
	}
	
	public static int seleccionarPersonaje(Personaje [] luchadores) {
		int opcion=0;
		
		Menus.menuSelectPersonaje();
		System.out.print("Selecciona un personaje: ");
		opcion=Lee.Entero();
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		for (int i = 0; i < luchadores.length; i++) {
			switch (opcion) {
			
			case 0:
				player1=luchadores[0];
				System.out.println("Ha elegido a: \n"+luchadores[0]);
				cpu=luchadores[1];
				i=luchadores.length;
				break;
			case 1:
				player1=luchadores[1];
				System.out.println("Ha elegido a: \n"+luchadores[1]);
				cpu=luchadores[0];
				i=luchadores.length;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
		return opcion;
	}
	
	public static void lucha() {
		
		boolean vivo=true;
		int opcion=0;
		
		Menus.pausa();
		Menus.introduccion();
		System.out.println(cpu);
		Menus.pausa();
		
		do {
			Menus.menuLucha();
			opcion=Lee.Entero();
			
			switch (opcion) {
				case 1:
					cpu.daño(player1.ataqueFisico());
					System.out.println("Defensa " +cpu.defensaFisico());
					System.out.println(cpu.getNombre()+" ha recibido un daño de: "+player1.ataqueFisico());
					System.out.println("vida restante de "+cpu.getNombre()+" "+cpu.getVida());
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					break;
			}
			
			switch (cpuDecision()) {
				case 1:
					player1.daño(cpu.ataqueFisico());
					System.out.println("Defensa " +player1.defensaFisico());
					System.out.println(player1.getNombre()+" ha recibido un daño de: "+cpu.ataqueFisico());
					System.out.println("vida restante de "+player1.getNombre()+" "+player1.getVida());
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					break;
			}
			
			
		}while(cpu.getVida()>0 && player1.getVida()>0);
		
		
		if(cpu.getVida()<0) {
			System.out.println("Derrotastes a "+cpu.getNombre());
			System.out.println("\n\t\tVICTORIA");
		}else if (player1.getVida()<0) {
			System.out.println("Te derrotaron");
			System.out.println("\n\t\tDERROTA");
		}
		
		System.out.println("\n\n\tFIN DE PROGRAMA");
	}
	
	public static int cpuDecision() {
		int opcion;
		opcion=(int) Math.floor(Math.random()*3+1);
		return opcion;
	}

	@Override
	public String toString() {
		return "luchadores: "+ Arrays.toString(luchadores);
	}
	
	
	
	
}
