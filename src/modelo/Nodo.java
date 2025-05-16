package modelo;

import interfaces.INodo;
import interfaces.IPersona;

public class Nodo implements INodo {
	// guardará las personas y tendrá la referencia al nodo de la derecha e izquierda! Comparamos con DNI el mayor y menor!
	private IPersona persona; // persona del tipo IPersona
	private INodo derecha;
	private INodo izquierda;
	
	public Nodo(IPersona p) {
		super();
		this.persona = p;
		this.derecha = null; // nada mas crear el nodo, queremos que derecha e izquierda sean null porque no sabemos todavía
		// a que nodos va a apuntar
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
	
	// toString no usamos en los árboles, creamos nosotros nuestro propios métodos!! Es por eso que no necesitamos toString de los nodos!
	
	

}
