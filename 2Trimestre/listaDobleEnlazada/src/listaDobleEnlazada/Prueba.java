package listaDobleEnlazada;

import java.util.Iterator;

public class Prueba {

	public static void main(String[] args) {
		ListaDobleEnlazada<String> lista = new ListaDobleEnlazada<>();
		
		lista.push("adios");
		lista.push("ei");
		lista.unshift("hola");//hola - adios -ei
		lista.push("wowowowwoow");
		
		
		System.out.println(lista);
		System.out.println(lista.contains("adios"));
		lista.remove(3);
		lista.shift();
		lista.removeElement("adios");
		
		/*
		lista.pop();
		
		System.out.println(lista);
		
		System.out.println(lista.get(2));
		
		lista.put("donde", 5);
		
		System.out.println(lista);
		*/
		
		
		System.out.println(lista);
	}

}
