package Modelo;

import java.util.Arrays;
import java.util.Random;

import Utils.Lee;
import Vistas.Imprimir;
import Vistas.Menus;

public class Partida {
	private Personaje [] luchadores;
	private Guerrero [] guerreros;
	private Mago [] magos;
	static Personaje player1;
	static Personaje player2;
	static Personaje cpu;

	public Partida(Personaje[] luchador, int numLuchadores, Guerrero [] guerreros, Mago [] magos, int numGuerreros, int numMagos) {
		this.luchadores = luchador;
		this.guerreros = guerreros;
		this.magos = magos;
		luchadores = new Personaje [numLuchadores];
		guerreros = new Guerrero [numGuerreros];
		magos = new Mago [numMagos];
		player1 = new Personaje();
		player2 = new Personaje();
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
					seleccionarClase(guerreros,magos);
					break;
				case 2:
					seleccionarClase(guerreros,magos);
					break;
				case 3:
					Imprimir.salto();
					muestraPersonajes(luchador);
					Imprimir.pausa();
					break;
				case 0:
					break;
			}
		}while(op>0 || op==1 || op==2);
	}

	public static void muestraPersonajes(Personaje [] luchadores) {
		
		for (int i = 0; i < luchadores.length; i++) {
			if(luchadores[i]==null) {
				System.out.println("null");
			}
			System.out.println(luchadores[i]);
			System.out.println();
		}
	}
	
	public static void muestraGuerreros(Guerrero [] guerreros) {
		for (int i = 0; i < guerreros.length; i++) {
			if(guerreros[i]==null) {
				System.out.println("null");
			}
			System.out.println(guerreros[i]);
			System.out.println();
		}
	}
	
	public static void muestraMagos(Mago [] magos) {
		for (int i = 0; i < magos.length; i++) {
			if(magos[i]==null) {
				System.out.println("null");
			}
			System.out.println(magos[i]);
			System.out.println();
		}
	}
	
	public static int seleccionarClase(Guerrero [] guerreros, Mago [] magos) {
		int eleccion=0;
		int opcion=0;
		Personaje p1 = null;
		Personaje p2 = null;
		do {
			Menus.seleccionar();
			opcion=Lee.Entero();
				switch (opcion) {
					case 1:
						muestraGuerreros(guerreros);
						Imprimir.seleccionarGuerrero();
						seleccionarGuerrero(eleccion,p1,guerreros,magos);
						Imprimir.seleccionarGuerrero();
						seleccionarGuerrero(eleccion,p2,guerreros,magos);
						break;
					case 2:
						muestraMagos(magos);
						Imprimir.seleccionarMago();
						seleccionarMago(eleccion,p1, magos, guerreros);
						Imprimir.seleccionarMago();
						seleccionarMago(eleccion,p2, magos, guerreros);
						break;
					case 0:
						break;
					default:
						Imprimir.error();
						break;
				}
		}while(opcion>0 || opcion==1 || opcion==2);
		
		lucha1();

		return opcion;
		
	}
	
	public static int seleccionarGuerrero(int eleccion, Personaje p1,Guerrero [] guerreros, Mago [] magos) {
		
		eleccion=Lee.Entero();
		switch (eleccion) {
		case 1:
			p1=guerreros[0];
			Imprimir.eleccion(p1);
			break;
		default:
			Imprimir.error();
			break;
		}
		Imprimir.pausa();
		
		return eleccion;
	}
	
	public static int seleccionarMago(int eleccion, Personaje p1,Mago [] magos, Guerrero[] guerreros) {
		
		eleccion=Lee.Entero();
		switch (eleccion) {
		case 1:
			p1=magos[0];
			Imprimir.eleccion(p1);
			break;
		default:
			Imprimir.error();
			break;
		}
		Imprimir.pausa();
		
		return eleccion;
	}
	
	
	public static boolean dificultad(int opcion) {
		boolean modo=false;
		
		if(opcion==1) {		
			modo=false;
		}
		if(opcion==2) {
			modo=true;
		}else {
			modo=false;
		}
		
		return modo;
	}
	
	public static void lucha1() {
		
		int opcion=0;
		int curas=2;
		int curas2=2;
		
		if(player1!=null && player2!=null) {
			Imprimir.pausa();
			Imprimir.introduccion();
			Imprimir.pausa();
		
		
			do {
				Menus.menuLucha();
				opcion=Lee.Entero();
				
				switch (opcion) {
					case 1:
						player2.daño(player1.ataqueFisico());
						Imprimir.batalla(player1, player2);
						
						break;
					case 2:
						int defensa=player1.defensaFisico()+player1.getVida();
						break;
					case 3:
						if(curas>0) {
							int curar=player1.getVida()+25;
							curas=-1;
							Imprimir.curar(player1);
						}else {
							Imprimir.sinCuras();
						}
						break;
					case 4:
						Imprimir.huir();
						player1.setVida(0);
						Imprimir.pausa();
						break;
					default:
						break;
				}
				
				switch (opcion) {
					case 1:
						player1.daño(cpu.ataqueFisico());
						Imprimir.batalla(player2, player1);
						break;
					case 2:
						int defensa=player2.defensaFisico()+player2.getVida();
						break;
					case 3:
						if(curas2>0) {
							int curar=player2.getVida()+25;
							curas2=-1;
							Imprimir.curar(player2);
						}else {
							Imprimir.sinCuras();
						}
						break;
					case 4:
						Imprimir.huir();
						player2.setVida(0);
						Imprimir.pausa();
						break;
					default:
						break;
				}
				
				
			}while(player2.getVida()>0 && player1.getVida()>0);
			
			if(player2.getVida()<=0) {
				Imprimir.ganar(player2);
			}
			
		}else {
			Imprimir.error();
		}

		Imprimir.end();
	}
	
	public static void lucha2() {
		
		int opcion=0;
		int curas=2;
		
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
						if(curas>0) {
							int curar=player1.getVida()+25;
							curas=-1;
							Imprimir.curar(player1);
						}else {
							Imprimir.sinCuras();
						}
						break;
					case 4:
						Imprimir.huir();
						player1.setVida(0);
						Imprimir.pausa();
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
						int defensa=cpu.defensaFisico()+cpu.getVida();
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
		Random rand = new Random(System.nanoTime());
		int aleatorio=rand.nextInt(2);
		return aleatorio;
	}

	@Override
	public String toString() {
		return "luchadores: " + Arrays.toString(luchadores) + " guerreros=" + Arrays.toString(guerreros)
				+ ", magos=" + Arrays.toString(magos);
	}
	
	
	
	
	
}
