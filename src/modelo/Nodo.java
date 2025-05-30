package modelo;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {
	// guardará las personas y tendrá la referencia al nodo de la derecha e izquierda! Comparamos con DNI el mayor y menor!
	private T dato;
	private INodo<T> derecha; // referencia al nodo mayor 
	private INodo<T> izquierda; // referencia al nodo menor 
	
	public Nodo(T dato) {
		super();
		this.dato = dato; // se le asigna la persona que se pasa por parámetro
		this.derecha = null; // nada mas crear el nodo, queremos que derecha e izquierda sean null porque no sabemos todavía
		// a que nodos va a apuntar dicho nodo creado
		this.izquierda = null;
	}
	
	// getters and setters -->

	@Override
	public T getDato() {
		return dato;
	}

	@Override
	public void setDato(T dato) {
		this.dato = dato;
	}

	@Override
	public INodo<T> getIzquierda() {
		return izquierda;
	}

	@Override
	public void setIzquierda(INodo<T> izquierda) {
		this.izquierda = izquierda;
	}

	@Override
	public INodo<T> getDerecha() {
		return derecha;
	}

	@Override
	public void setDerecha(INodo<T> derecha) {
		this.derecha = derecha;
	}
	
	
	// no usamos el toString de los nodos ya que para imprimir cada nodo dentro del árbol usamos 3 métodos que acceden a cada dato de cada nodo.

	
	

}
