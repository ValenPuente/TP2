package modelo;

import interfaces.INodo;
import interfaces.IPersona;

public class Nodo implements INodo {
	// guardará las personas y tendrá la referencia al nodo de la derecha e izquierda! Comparamos con DNI el mayor y menor!
	private IPersona persona; 
	private INodo derecha; // referencia al nodo mayor 
	private INodo izquierda; // referencia al nodo menor 
	
	public Nodo(IPersona persona) {
		super();
		this.persona = persona; // se le asigna la persona que se pasa por parámetro
		this.derecha = null; // nada mas crear el nodo, queremos que derecha e izquierda sean null porque no sabemos todavía
		// a que nodos va a apuntar dicho nodo creado
		this.izquierda = null;
	}
	
	// getters and setters -->

	public IPersona getPersona() {
		return persona;
	}

	public void setPersona(IPersona persona) {
		this.persona = persona;
	}

	public INodo getDerecha() {
		return derecha;
	}

	public void setDerecha(INodo derecha) {
		this.derecha = derecha;
	}

	public INodo getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(INodo izquierda) {
		this.izquierda = izquierda;
	}
	
	
	// no usamos el toString de los nodos ya que para imprimir cada nodo dentro del árbol usamos 3 métodos que acceden a cada dato de cada nodo.

	
	

}
