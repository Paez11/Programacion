package Controlador;

import Modelo.Guerrero;
import Modelo.Mago;
import Modelo.Partida;
import Modelo.Personaje;

public class Test {

	public static void main(String[] args) {
		
		Guerrero p1 = new Guerrero("Spike",100,10,3,20);
		Mago p2 = new Mago("Malko",100,20,5,15);
		
		Personaje [] luchadores = new Personaje [2];
		
		luchadores[0] = p1;
		luchadores[1] = p2;
		
		Partida.muestraPersonajes(luchadores);
		
		Partida.seleccionarPersonaje(luchadores);
		
		Partida.lucha();

	}

	
}
