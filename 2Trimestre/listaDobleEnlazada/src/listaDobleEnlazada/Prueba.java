package listaDobleEnlazada;

import java.util.Iterator;

public class Prueba {

	public static void main(String[] args) {
		ListaDobleEnlazada<String> lista = new ListaDobleEnlazada();
		lista.unshift("hola");
		
		System.out.println(lista);
	}

}
