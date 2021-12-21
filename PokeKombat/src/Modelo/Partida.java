package Modelo;

import java.util.Arrays;

import Utils.Lee;
import Vistas.Imprimir;
import Vistas.Menus;

public class Partida {
	private Personaje [] luchadores;
	private Guerrero [] guerreros;
	private Mago [] magos;
	static Personaje player1;
	static Personaje cpu;

	public Partida(Personaje[] luchador, int numLuchadores, Guerrero [] guerreros, Mago [] magos, int numGuerreros, int numMagos) {
		this.luchadores = luchador;
		this.guerreros = guerreros;
		this.magos = magos;
		luchadores = new Personaje [numLuchadores];
		guerreros = new Guerrero [numGuerreros];
		magos = new Mago [numMagos];
		player1 = new Personaje();
		cpu = new Personaje();
	}

	public Personaje[] getLuchadores() {
		return luchadores;
	}

	public void setLuchadores(Personaje[] luchadores) {
		this.luchadores = luchadores;
	}
	
	public Guerrero[] getGuerreros() {
		return guerreros;
	}

	public void setGuerreros(Guerrero[] guerreros) {
		this.guerreros = guerreros;
	}

	public Mago[] getMagos() {
		return magos;
	}

	public void setMagos(Mago[] magos) {
		this.magos = magos;
	}

	
	public static void Principal(Personaje[] luchador, Guerrero [] guerreros, Mago [] magos) {
		int op=-1;
		do {
			Menus.menuPrincipal();
			op=Lee.Entero();
			
			switch(op) {
				case 1:
					
					break;
				case 2:
					seleccionarClase(guerreros, magos);
					break;
				case 3:
					Imprimir.salto();
					muestraPersonajes(luchador);
					Imprimir.pausa();
					break;
				case 0:
					break;
			}
		}while(op>0);
		Imprimir.end();

	}

	public static void muestraPersonajes(Personaje [] luchadores) {
		for (int i = 0; i < luchadores.length; i++) {
			System.out.println(luchadores[i]);
			System.out.println();
		}
	}
	
	public static int seleccionarClase(Guerrero [] guerreros, Mago [] magos) {
		int eleccion=0;
		int opcion=0;
		
		do {
			Menus.seleccionar();
			opcion=Lee.Entero();
				switch (opcion) {
					case 1:
						break;
					case 2:
						break;
					case 0:
						break;
					default:
						Imprimir.error();
						break;
				}
		}while(opcion>0);

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
		
		int opcion=0;
		
		if(player1!=null && cpu!=null) {
			Imprimir.pausa();
			Imprimir.introduccion();
			Imprimir.eleccion(cpu);
			Imprimir.pausa();
		
		
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
			
			if(cpu.getVida()<=0) {
				Imprimir.ganar(cpu);
			}else if (player1.getVida()<=0) {
				Imprimir.perder();
			}
		}else {
			Imprimir.error();
		}

		Imprimir.end();
	}
	
	public static int cpuDecision() {
		int aleatorio=(int)Math.random()*3+1;
		return aleatorio;
	}

	@Override
	public String toString() {
		return "luchadores: " + Arrays.toString(luchadores) + " guerreros=" + Arrays.toString(guerreros)
				+ ", magos=" + Arrays.toString(magos);
	}
	
	
	
	
	
}
