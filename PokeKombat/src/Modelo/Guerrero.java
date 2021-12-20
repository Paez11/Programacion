package Modelo;

public class Guerrero extends Personaje {
	
	private int poderAtaque;

	public Guerrero(String nombre, int vida, int ataque, int defensa, int poderAtaque) {
		super(nombre, vida, ataque, defensa);
		this.poderAtaque = poderAtaque;
	}
	
	public Guerrero() {
		super("", 100, 2, 1);
		this.poderAtaque = 5;
	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}
	
	@Override
	public int ataqueFisico() {
		int ataque=(int) Math.floor(Math.random()*this.getAtaque()+1);
		
		return this.poderAtaque+ataque;
	}

	@Override
	public String toString() {
		return "Guerrero-> "+super.toString()+"\n poderAtaque: "+poderAtaque;
	}
	
	
}
