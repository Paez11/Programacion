package listaDobleEnlazada;


public class ListaDobleEnlazada<T> {
	private Nodo<T> primero;
	private int size;
	
	
	public ListaDobleEnlazada() {
		this.primero = null;
		this.size = 0;
	}
	
	
	public Nodo<T> getPrimero() {
		return primero;
	}



	public void setPrimero(Nodo<T> primero) {
		this.primero = primero;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	/**
	 * Inserta un nodo al final de la lista
	 * @param v el valor del nodo insertado
	 * @return el nuevo tama�o de la lista
	 */
	public int push(T v) {
		
		Nodo<T> nuevo = new Nodo<T>(v);
		Nodo<T> aux = this.primero;
		
		if(aux==null) {
			this.unshift(v);
		}
		
		while(aux.siguiente!=null) {
			aux=aux.siguiente;
		}
		aux.siguiente=nuevo;
		nuevo.anterior=aux;
		size++;
		
		return size;
	}

	/**
	 * Insertar un nodo al principio de la lista
	 * @param v el valor del nodo insertado
	 * @return el nuevo tama�o de la lista
	 */
	public int unshift(T v) {
		
		Nodo<T> nuevo = new Nodo<T>(v);
		
		if(this.primero==null) {
			this.primero=nuevo;
			size++;
		}else {
			
			this.primero.anterior=nuevo;
			nuevo.siguiente=this.primero;
			this.primero=nuevo;
		}
		
		return size;
	}
	
	/**
	 * Devuelve el valor del �ltimo nodo de la lista y lo elimina (extrae)
	 * @return el valor del ultimo nodo o null si la lista est� v�cia
	 */
	public T pop() {
		Nodo <T> eliminado = this.primero;
		T dato = eliminado.getDato();
		
		if(this.primero.siguiente==null) {
			this.primero=null;
		}else {
			eliminado=this.primero.siguiente;
			Nodo<T> aux = this.primero;
			while(eliminado.siguiente!=null) {
				aux=eliminado;
				eliminado=eliminado.siguiente;
			}
			aux=eliminado.anterior;
			eliminado.siguiente=null;
			
			
		}
		
		
		return dato;
	}
	
	/**
	 * Devuelve el valor del primer nodo de la lista y lo elimina (extrae)
	 * @return el valor del primer nodo o null si la lista est� vac�a
	 */
	public T shift() {
		Nodo <T> aux = this.primero;
		T dato = null;
		
		
		return dato;
	}
	
	/**
	 * Busca el valor pasado como par�metro y devuelve la posici�n del primer nodo que lo contenga
	 * @param v valor a buscar
	 * @return posici�n del nodo que lo contiene o -1 si no existe o la lista est� vac�a
	 */
	public int contains(T v) {
		
	}
	
	/**
	 * Devuelve el valor del nodo que se encuentra en la posici�n indicada
	 * @param pos posici�n del nodo
	 * @return su valor o null si no es una posici�n correcto o la lista est� vac�a
	 */
	public T get(int pos) {
		
	}

	/**
	 * Insertar un nodo con el valor pasado en la posici�n indicada
	 * @param value el valor del nuevo nodo a insertar
	 * @param pos la posici�n donde se desea insertar
	 * @return el nuevo tama�o de la lista
	 */
	public int put(T value, int pos) {
		
	}

	/**
	 * Elimina el nodo que se encuentre en la posici�n indicada
	 * @param pos posici�n del nodo a eliminar 
	 * @return el tama�o de la lista
	 */
	public int remove(int pos) {
		
	}
	
	/**
	 * Elimina el nodo que contenga el valor indicado
	 * @param v valor del nodo a eliminar 
	 * @return el tama�o de la lista
	 */
	public int removeElement(T v) {
		
	}
	@Override
	public String toString() {
		return  primero + "," + primero.siguiente + "[" + size +"]";
	}
	
}