package Modelo;

import java.util.Random;

public class Personaje {
	
	private String nombre;
	private int vida;
	protected int ataque;
	protected int defensa;
	
	protected Random rand = new Random(System.nanoTime());
	
	public Personaje(String nombre, int vida, int ataque, int defensa) {
		super();
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}
	
	public Personaje() {
		super();
		this.nombre = "";
		this.vida = 100;
		this.ataque = 2;
		this.defensa = 1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	/**
	 * Metodo que tendra el da�o de ataque base de todos los personajes entre 1 y la que tenga el personaje
	 * @return devuelve la variable con un numero aleatorio para el ataque
	 */
	public int ataqueFisico() {
		int ataque=rand.nextInt(this.ataque);
		return ataque;
	}
	
	/**
	 * Metodo para tener una defensa aleatoria entre 1 y la que tendra por defecto el personaje
	 * @return devuelve un numero aleatorio para la defensa
	 */
	public int defensaFisico() {
		int defensa=rand.nextInt(this.defensa);
		
		return defensa;
	}
	
	/**
	 * Metodo para restar a la vida de un personaje
	 * @param vida la vida que cambiara al restarle en un ataque
	 */
	public void da�o(int vida) {
		
		if(this.defensaFisico()<=0) {
			this.vida=this.vida-vida;
		}else {
			this.vida=(this.vida+this.defensaFisico())-vida;
		}
	}

	@Override
	public String toString() {
		return 
				 "\n nombre: " + nombre 
				+ "\n vida: " + vida 
				+ "\n ataque: " + ataque 
				+ "\n defensa:" + defensa;
	}
	
	
}
