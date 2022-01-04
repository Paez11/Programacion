package Controlador;

import Modelo.Guerrero;
import Modelo.Mago;
import Modelo.Partida;
import Modelo.Personaje;
import Utils.Lee;
import Vistas.Imprimir;
import Vistas.Menus;

public class Test {

	public static void Juego() {
		
		Guerrero p1 = new Guerrero("Spike",100,15,5,20,100);
		Mago p2 = new Mago("Malko",100,20,3,15,100);
		
		Personaje [] luchadores = new Personaje [2];
		
		
		luchadores[0] = p1;
		luchadores[1] = p2;
		
		
		Imprimir.inicio();
		Imprimir.pausa();
		
		Partida.Principal(luchadores);
		
		//Partida.lucha();
		
		Imprimir.salir();

	}

	
}
