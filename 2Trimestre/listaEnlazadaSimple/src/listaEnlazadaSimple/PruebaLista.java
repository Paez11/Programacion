package listaEnlazadaSimple;

import java.util.Iterator;

public class PruebaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEnlazada lista = new ListaEnlazada();
		lista.addFirst("hola");
		lista.addLast("adios");
		lista.addLast("Buenas noches");
		
		for (int i = 0; i < lista.lengthList(); i++) {
			System.out.println(lista.getDato(i));
		}
		//lista.removeFirstNodo();
		//lista.removeLastNodo();
		//lista.removeGetNodo(1);
		for (int i = 0; i < lista.lengthList(); i++) {
			System.out.println(lista.getNodo(i));
		}
		lista.setNodo(2, "aaa");
		for (int i = 0; i < lista.lengthList(); i++) {
			System.out.println(lista.getDato(i));
		}
		
	}

}
