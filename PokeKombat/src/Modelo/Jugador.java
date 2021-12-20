package Modelo;

import Utils.Lee;

public class Jugador {
	
	private String nombre;
	
	

	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Jugador() {
		super();
		this.nombre = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String introducirNombre(String nombre) {
		
		System.out.println("Introduzca su nombre");
		nombre=Lee.String(nombre);
		
		return nombre;
	}

	@Override
	public String toString() {
		return  nombre ;
	}
	
	
}
