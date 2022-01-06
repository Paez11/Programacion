package Modelo;

import java.util.Arrays;
import java.util.Random;

import Utils.Lee;
import Vistas.Dibujos;
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
					lucha2(luchadores);
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
			luchadores[0]=null;
			break;
		case 2:
			player1=luchadores [1];
			luchadores[1]=null;
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
			luchadores[0]=null;
			break;
		case 2:
			player2=luchadores [1];
			luchadores[1]=null;
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
		int contador=0;
		Personaje [] CPU;
		for (int i = 0; i < luchadores.length; i++) {
			if (luchadores[i]!=null) {
				contador++;
			}
		}
		CPU= new Personaje [contador];
		for (int i = 0; i < luchadores.length; i++) {
			for (int j = 0; j < CPU.length; j++) {
				if (luchadores[i]!=null && CPU[j]==null) {
					CPU[j]=luchadores[i];
				}
			}
		}
		cpu=CPU[rand.nextInt(CPU.length)];
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
			Imprimir.introduccion();
			Imprimir.pausa();
		
		
			do {
				Menus.menuLucha();
				opcion=Lee.Entero();
				
				switch (opcion) {
					case 1:
						player2.dano(player1.ataqueFisico());
						Dibujos.atacar();
						Imprimir.ataque(player1, player2);
						
						break;
					case 2:
						player1.defender(player1.defensaFisico());
						Dibujos.defender();
						Imprimir.defensa(player1);
						break;
					case 3:
						if(curas>0) {
							player1.curar(curas);
							curas=curas-1;
							Dibujos.curar();
							Imprimir.curar(player1);
						}else {
							Imprimir.sinCuras();
						}
						break;
					case 4:
						Imprimir.huir();
						player1.setVida(-99);
						Imprimir.pausa();
						break;
					default:
						break;
				}
				if (player2.getVida()>0 && player1.getVida()>0) {
					
					Menus.menuLucha();
					opcion2=Lee.Entero();
					
					switch (opcion2) {
						case 1:
							player1.dano(player2.ataqueFisico());
							Dibujos.atacar();
							Imprimir.ataque(player2, player1);
							break;
						case 2:
							player2.defender(player2.defensaFisico());
							Dibujos.defender();
							Imprimir.defensa(player2);
							break;
						case 3:
							if(curas2>0) {
								player2.curar(curas2);
								curas2=curas2-1;
								Dibujos.curar();
								Imprimir.curar(player2);
							}else {
								Imprimir.sinCuras();
							}
							break;
						case 4:
							Imprimir.huir();
							player2.setVida(-99);
							Imprimir.pausa();
							break;
						default:
							break;
					}
					Imprimir.pausa();
					Imprimir.status(player1, curas);
					Imprimir.status(player2, curas2);
				}
				
				
			}while(player2.getVida()>0 && player1.getVida()>0);
			
			if(player2.getVida()<=0) {
				Imprimir.ganador(player1);
			}else if (player1.getVida()<=0) {
				Imprimir.ganador(player2);
			}
			if(player1.getVida()==-99 || player2.getVida()==-99) {
				Dibujos.huir();
			}else {
				Dibujos.ganar();
			}
			
		}else {
			Imprimir.error();
		}

		Imprimir.end();
	}
	
	public static void lucha2(Personaje [] CPU) {
		
		int opcion=0;
		int recuperacion=25;
		int curas=2;
		int curas2=2;
		
		
		 
		if(player1!=null && cpu!=null) {
			Imprimir.introduccion2();
			Imprimir.eleccion(cpu);
			Imprimir.pausa();
		
		
			do {
				Menus.menuLucha();
				opcion=Lee.Entero();
				
				switch (opcion) {
					case 1:
						cpu.dano(player1.ataqueFisico());
						Dibujos.atacar();
						Imprimir.ataque(player1, cpu);
						break;
					case 2:
						player1.defender(player1.defensaFisico());
						Dibujos.defender();
						Imprimir.defensa(player1);
						break;
					case 3:
						if(curas>0) {
							player1.curar(recuperacion);
							curas=curas-1;
							Dibujos.curar();
							Imprimir.curar(player1);
						}else {
							Imprimir.sinCuras();
						}
						break;
					case 4:
						Imprimir.huir();
						player1.setVida(-99);
						Imprimir.pausa();
						break;
					default:
						break;
				}
				if(cpu.getVida()>0 && player1.getVida()>0) {
					switch (cpuDecision()) {
						case 0:
							player1.dano(cpu.ataqueFisico());
							Dibujos.atacar();
							Imprimir.ataque(cpu, player1);
							break;
						case 1:
							player1.dano(cpu.ataqueFisico());
							Dibujos.atacar();
							Imprimir.ataque(cpu, player1);
							break;
						case 2:
							cpu.defender(cpu.defensaFisico());
							Dibujos.defender();
							Imprimir.defensa(cpu);
							break;
						case 3:
							if(curas2>0) {
								cpu.curar(recuperacion);
								curas2=curas2-1;
								Dibujos.curar();
								Imprimir.curar(cpu);
							}else {
								Imprimir.sinCuras();
							}
						default:
							break;
					}
					Imprimir.pausa();
					Imprimir.status(player1, curas);
					Imprimir.status(cpu, curas2);
				}
					
			}while(cpu.getVida()>0 && player1.getVida()>0);
			
			if(cpu.getVida()<=0) {
				Imprimir.ganar(cpu);
				cpu=null;
			}else if (player1.getVida()<=0) {
				Imprimir.perder();
			}
			if(player1.getVida()==-99) {
				Dibujos.huir();
			}else {
				Dibujos.ganar();
			}
			
			
		}else {
			Imprimir.error();
		}

		Imprimir.end();
	}
	
	public static int cpuDecision() {
		Random rand = new Random(System.nanoTime());
		int aleatorio=rand.nextInt(4);
		return aleatorio;
	}

	@Override
	public String toString() {
		return "luchadores: " + Arrays.toString(luchadores);
	}
	
	
	
	
	
}
