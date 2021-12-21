package Modelo;

public class Mago extends Personaje{
	
	private int poderDefensa;

	
	
	public Mago(String nombre, int vida, int ataque, int defensa, int poderDefensa) {
		super(nombre, vida, ataque, defensa);
		this.poderDefensa = poderDefensa;
	}
	public Mago() {
		super("", 100, 2, 1);
		this.poderDefensa = 5;
	}

	public int getPoderDefensa() {
		return poderDefensa;
	}

	public void setPoderDefensa(int poderDefensa) {
		this.poderDefensa = poderDefensa;
	}
	
	@Override
	public int defensaFisico() {
		int aleatorio=(int)Math.random();
		int defensa=aleatorio*this.getDefensa()+1;
		
		return this.poderDefensa+defensa;
	}
	
	
	@Override
	public String toString() {
		return "Mago-> "+ super.toString() +"\n poderDefensa: "+poderDefensa;
	}
	
	
}
