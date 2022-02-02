package listaDobleEnlazada;

public class ListaDobleEnlazada<T> {
	private Nodo<T> primero;
	private int size;
	
	
	public ListaDobleEnlazada(Nodo<T> primero, int size) {
		this.primero = primero;
		this.size = size;
	}
	
	/**
	 * Inserta un nodo al final de la lista
	 * @param v el valor del nodo insertado
	 * @return el nuevo tamaño de la lista
	 */
	public int push(T v) {
		int size=0;
		Nodo<T> nuevo = new Nodo<T>(v);
		
		while(nuevo.siguiente!=null) {
			nuevo=nuevo.siguiente;
		}
		
		return size+1;
	}

	/**
	 * Insertar un nodo al principio de la lista
	 * @param v el valor del nodo insertado
	 * @return el nuevo tamaño de la lista
	 */
	public int unshift(T v) {
		int size=0;
		Nodo<T> nuevo = new Nodo<T>(v);
		
		this.primero=nuevo;
		nuevo=nuevo.anterior;
		
		return size+1;
	}
	
	/**
	 * Devuelve el valor del último nodo de la lista y lo elimina (extrae)
	 * @return el valor del ultimo nodo o null si la lista está vácia
	 */
	public T pop() {
		
	}
	
	/**
	 * Devuelve el valor del primer nodo de la lista y lo elimina (extrae)
	 * @return el valor del primer nodo o null si la lista está vacía
	 */
	public T shift() {
		
	}
	
	/**
	 * Busca el valor pasado como parámetro y devuelve la posición del primer nodo que lo contenga
	 * @param v valor a buscar
	 * @return posición del nodo que lo contiene o -1 si no existe o la lista está vacía
	 */
	public int contains(T v) {
		
	}
	
	/**
	 * Devuelve el valor del nodo que se encuentra en la posición indicada
	 * @param pos posición del nodo
	 * @return su valor o null si no es una posición correcto o la lista está vacía
	 */
	public T get(int pos) {
		
	}

	/**
	 * Insertar un nodo con el valor pasado en la posición indicada
	 * @param value el valor del nuevo nodo a insertar
	 * @param pos la posición donde se desea insertar
	 * @return el nuevo tamaño de la lista
	 */
	public int put(T value, int pos) {
		
	}

	/**
	 * Elimina el nodo que se encuentre en la posición indicada
	 * @param pos posición del nodo a eliminar 
	 * @return el tamaño de la lista
	 */
	public int remove(int pos) {
		
	}
	
	/**
	 * Elimina el nodo que contenga el valor indicado
	 * @param v valor del nodo a eliminar 
	 * @return el tamaño de la lista
	 */
	public int removeElement(T v) {
		
	}
	@Override
	public String toString() {
		return  primero + "," + primero.siguiente + "[" + size +"]";
	}
	
}
