package Modelo;

import java.util.Arrays;
import java.util.Random;

import Utils.Lee;
import Vistas.Imprimir;
import Vistas.Menus;

public class Partida {
	private Personaje [] luchadores;
	static Personaje player1;
	static Personaje player2;
	static Personaje cpu;

		
	public static void Principal(Personaje[] luchadores) {
		int op=-1;
		do {
			Menus.menuPrincipal();
			op=Lee.Entero();
			
			switch(op) {
				case 1:
					if(player1==null && player2==null) {
						seleccionarPersonajePlayer1(luchadores);
						seleccionarPersonajePlayer2(luchadores);
					}
					lucha1();
					break;
				case 2:
					seleccionarPersonajePlayer1(luchadores);
					seleccionarCPU(luchadores);
					lucha2();
					break;
				case 3:
					Imprimir.salto();
					Menus.muestraPersonajes(luchadores);
					Imprimir.pausa();
					break;
				case 0:
					break;
			}
		}while(op>0);
	}

		
	public static int seleccionarPersonajePlayer1(Personaje [] luchadores) {
		
		Menus.muestraPersonajes(luchadores);
		Menus.menuSelectPersonaje();
		int eleccion=Lee.Entero();
		switch (eleccion) {
		case 1:
			player1=luchadores [0];
			break;
		case 2:
			player1=luchadores [1];
			break;
		default:
			Imprimir.error();
			break;
		}
		Imprimir.eleccion(player1);
		Imprimir.pausa();
		
		return eleccion;
	}
	public static int seleccionarPersonajePlayer2(Personaje [] luchadores) {
		
		Menus.muestraPersonajes(luchadores);
		Menus.menuSelectPersonaje();
		int eleccion=Lee.Entero();
		switch (eleccion) {
		case 1:
			player2=luchadores [0];
			break;
		case 2:
			player2=luchadores [1];
			break;
		default:
			Imprimir.error();
			break;
		}
		Imprimir.eleccion(player2);
		Imprimir.pausa();
		
		return eleccion;
	}
	
	public static void seleccionarCPU(Personaje [] luchadores) {
		Random rand = new Random(System.nanoTime());
		cpu = luchadores[rand.nextInt(luchadores.length)];
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
		int opcion2=0;
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
				if (player2.getVida()>0) {
					
					Menus.menuLucha();
					opcion2=Lee.Entero();
					
					switch (opcion2) {
						case 1:
							player1.daño(player2.ataqueFisico());
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
				if(cpu.getVida()>0) {
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
		return "luchadores: " + Arrays.toString(luchadores);
	}
	
	
	
	
	
}
