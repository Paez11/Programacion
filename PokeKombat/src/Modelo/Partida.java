package Modelo;

import java.util.Arrays;

import Utils.Lee;
import Vistas.Imprimir;
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
		opcion=Lee.Entero();
		Imprimir.salto();
		
		for (int i = 0; i < luchadores.length; i++) {
			switch (opcion) {
			
			case 0:
				player1=luchadores[0];
				cpu=luchadores[1];
				i=luchadores.length;
				Imprimir.eleccion(player1);
				break;
			case 1:
				player1=(Mago)luchadores[1];
				cpu=luchadores[0];
				i=luchadores.length;
				Imprimir.eleccion(player1);
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
		return opcion;
		
	}
	
	
	public static boolean dificultad(int opcion) {
		boolean modo=false;
		
		if(opcion==1) {		
			
		}
		if(opcion==2) {
			
		}
		
		return modo;
	}
	
	public static void lucha() {
		
		boolean vivo=true;
		int opcion=0;
		
		Menus.pausa();
		Menus.introduccion();
		Imprimir.eleccion(cpu);
		Menus.pausa();
		
		do {
			Menus.menuLucha();
			opcion=Lee.Entero();
			
			switch (opcion) {
				case 1:
					cpu.daño(player1.ataqueFisico());
					Imprimir.batalla(player1, cpu);
					
					break;
				case 2:
					int defensa=player1.defensaFisico()+player1.getVida();
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
					Imprimir.batalla(cpu, player1);
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
		int aleatorio=(int)Math.random()*3+1;
		return aleatorio;
	}

	@Override
	public String toString() {
		return "luchadores: "+ Arrays.toString(luchadores);
	}
	
	
	
	
}
