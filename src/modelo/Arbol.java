package modelo;

import interfaces.IArbol;
import interfaces.INodo;
import interfaces.IPersona;

public class Arbol implements IArbol {
	// atributo ->
	private INodo raiz; // tiene un solo atributo, que es la raíz, que no cambia nunca y es el primer nodo insertado
	
	
	// constructor -->
	public Arbol() {
		super();
		this.raiz = null; // cuando creamos el árbol, no sabemos cúal es el primer nodo que insertaremos!
	}

	// getter y setters de raíz
	public INodo getRaiz() {
		return raiz;
	}


	public void setRaiz(INodo raiz) {
		this.raiz = raiz;
	}
	
	
	// primitivas del árbol ->
	
	public void insertar(IPersona persona) { // método que se llamará del main y que recibe el dato a insertar, es decir, la instancia de la clase persona!!
		raiz = insertarRec(raiz, persona); // igualamos raiz al retorno de la función 
	}
	
	public INodo insertarRec(INodo nodo, IPersona persona) {// recibimos como dato un dato genérico (que es una instancia de clase Persona), que deberemos insertar en 
		// nuestro árbol y un nodo que representa el nodo raíz de cada subárbol que formemos!-->
		// primero verificamos si el nodo raíz en el que estamos parados está vacío o no --> sería mi caso base
		if (nodo == null) {// si lo está, significa que es el nodo donde debemos insertar nuestro elemento-->
			return new Nodo(persona); // retornamos el nodo creado con nuestro dato para poder insertarlo en el null en el que estamos parados!!
		}
		// si no está vacío --> 
		if (persona.getDNI() > nodo.getPersona().getDNI()) {// si el dni de la persona que queremos insertar es mayor al DNI de la persona del nodo raíz en el que 
			// nos encontramos
			nodo.setDerecha(insertarRec(nodo.getDerecha(), persona)); // volvemos a llamar a la función pero pasando el nodo de la derecha, tal que es mi nueva raíz del
			// subárbol formado!
		} else if (persona.getDNI() < nodo.getPersona().getDNI()) { // si el DNI de la persona que queremos insertar es menor -->
			nodo.setIzquierda(insertarRec(nodo.getIzquierda(), persona));
		}
		return nodo; // cuando no entremos a salgamos del if o else if, retornamos el nodo al anterior llamado!
	}
	
	
	public void preOrder(INodo nodo) { // nodo representa la raíz de cada subárbol formado, en el primer llamado del main representa la raíz
		if (nodo != null) { // caso base -->
			System.out.println(nodo.getPersona() + "-");
			preOrder(nodo.getIzquierda());
			preOrder(nodo.getDerecha());
		}
	}
	
	public void inOrder(INodo nodo) {
		if (nodo != null) {
			inOrder(nodo.getIzquierda());
			System.out.println(nodo.getPersona() + "-");
			inOrder(nodo.getDerecha());
		}
	}
	
	public void postOrder(INodo nodo) {
		if (nodo != null) {
			postOrder(nodo.getIzquierda());
			postOrder(nodo.getDerecha());
			System.out.println(nodo.getPersona() + "-");
		}
	}
	
	
	// public void eliminar
	
	// public void eliminarRec

}
