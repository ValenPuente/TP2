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
	
	public void insertar(IPersona p) { // método que se llamará del main
		raiz = insertarRec(raiz, p); // igualamos raiz al retorno de la función 
	}
	
	public INodo insertarRec(INodo nodo, IPersona p) {// recibimos como dato una instancia de clase Persona, que deberemos insertar en nuestro árbol y un nodo
		// que representa el nodo raíz de cada subárbol que formemos!-->
		// primero verificamos si el nodo raíz en el que estamos parados está vacío o no --> sería mi caso base
		if (nodo == null) {// si lo está, significa que es el nodo donde debemos insertar nuestro elemento-->
			return new Nodo(p); // retornamos el nodo creado con nuestro dato para poder insertarlo en el null en el que estamos parados!!
		}
		// si no está vacío --> 
		if (p.getDNI() > nodo.getPersona().getDNI()) {// si el dni de la persona que queremos insertar es mayor al DNI de la persona del nodo raíz en el que 
			// nos encontramos
			nodo.setDerecha(insertarRec(nodo.getDerecha(), p)); // volvemos a llamar a la función pero pasando el nodo de la derecha, tal que es mi nueva raíz del
			// subárbol formado!
		} else if (p.getDNI() < nodo.getPersona().getDNI()) { // si el DNI de la persona que queremos insertar es menor -->
			nodo.setIzquierda(insertarRec(nodo.getIzquierda(), p));
		}
		return nodo; // cuando no entremos a salgamos del if o else if, retornamos el nodo al anterior llamado!
	}
	

}
