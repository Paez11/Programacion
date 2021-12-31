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
		
		Guerrero p1 = new Guerrero("Spike",100,15,5,20);
		Mago p2 = new Mago("Malko",100,20,3,15);
		
		Personaje [] luchadores = new Personaje [2];
		
		Guerrero [] guerreros = new Guerrero [1];
		Mago [] magos = new Mago [1];
		
		guerreros[0]= p1;
		magos[0]=p2;
		
		luchadores[0] = p1;
		luchadores[1] = p2;
		
		
		Imprimir.inicio();
		Imprimir.pausa();
		
		Partida.Principal(luchadores, guerreros, magos);
		
		//Partida.lucha();
		
		Imprimir.salir();

	}

	
}
