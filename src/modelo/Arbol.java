package modelo;

import interfaces.IArbol;
import interfaces.INodo;
import interfaces.IPersona;
import java.util.Comparator;

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
	
	public void insertar(IPersona persona, Comparator<IPersona> Criterio) { // método que se llamará del main y que recibe el dato a insertar, es decir, la instancia de la clase persona!!
		raiz = insertarRec(raiz, persona, Criterio); // igualamos raiz al retorno de la función 
	}
	
	public INodo insertarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio) {// recibimos como dato un dato genérico (que es una instancia de clase Persona), que deberemos insertar en 
		// nuestro árbol y un nodo que representa el nodo raíz de cada subárbol que formemos!-->
		// primero verificamos si el nodo raíz en el que estamos parados está vacío o no --> sería mi caso base
		if (nodo == null) {// si lo está, significa que es el nodo donde debemos insertar nuestro elemento-->
			return new Nodo(persona); // retornamos el nodo creado con nuestro dato para poder insertarlo en el null en el que estamos parados!!
		}
		// si no está vacío --> 
		if (Criterio.compare(persona, nodo.getPersona()) > 0) {// si el criterio de comparación nos dice que el dato a insertar es mayor que el nodo actual, 
			//entonces debemos insertarlo en la derecha

			nodo.setDerecha(insertarRec(nodo.getDerecha(), persona, Criterio)); // volvemos a llamar a la función pero pasando el nodo de la derecha, tal que es mi nueva raíz del
			// subárbol formado!
		} else if (Criterio.compare(persona, nodo.getPersona()) < 0) { // si el criterio de comparación nos dice que el dato a insertar es menor que el nodo actual, 
			//entonces debemos insertarlo en la izquierda
			nodo.setIzquierda(insertarRec(nodo.getIzquierda(), persona, Criterio));
		}
		return nodo; // cuando no entremos a salgamos del if o else if, retornamos el nodo al anterior llamado!
	}
	
	
	public void preOrder(INodo nodo) { // nodo representa la raíz de cada subárbol formado, en el primer llamado del main representa la raíz
		if (nodo != null) { // caso base -->
			System.out.println(nodo.getPersona());
			preOrder(nodo.getIzquierda());
			preOrder(nodo.getDerecha());
		}
	}
	
	public void inOrder(INodo nodo) {
		if (nodo != null) {
			inOrder(nodo.getIzquierda());
			System.out.println(nodo.getPersona());
			inOrder(nodo.getDerecha());
		}
	}
	
	public void postOrder(INodo nodo) {
		if (nodo != null) {
			postOrder(nodo.getIzquierda());
			postOrder(nodo.getDerecha());
			System.out.println(nodo.getPersona());
		}
	}
	public void eliminar(IPersona persona, Comparator<IPersona> Criterio){
		raiz = eliminarRec(raiz, persona, Criterio);
	}

	public INodo eliminarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio) {
		if (nodo == null) {
			return null;
		}
		if (Criterio.compare(persona, nodo.getPersona()) < 0) {
			nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), persona, Criterio));
		} else if (Criterio.compare(persona, nodo.getPersona()) > 0) {
			nodo.setDerecha(eliminarRec(nodo.getDerecha(), persona, Criterio));
		} else {
			// Caso 1: Nodo sin hijos
			if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
				return null;
			}
			// Caso 2: Nodo con un hijo
			if (nodo.getIzquierda() == null) {
				return nodo.getDerecha();
			}
			if (nodo.getDerecha() == null) {
				return nodo.getIzquierda();
			}
			// Caso 3: Nodo con dos hijos
			INodo sucesor = encontrarMinimo(nodo.getDerecha()); // Paso como dato el nodo derecho, ya que el sucesor será el mínimo del subárbol derecho
			nodo.setPersona(sucesor.getPersona());
			nodo.setDerecha(eliminarRec(nodo.getDerecha(), sucesor.getPersona(), Criterio));
		}
		return nodo;
	}

	// Método para encontrar el nodo con el valor mínimo en un subárbol derecho y asi poder eliminarlo correctamente
	public INodo encontrarMinimo(INodo nodo) {
		while (nodo.getIzquierda() != null) {
			nodo = nodo.getIzquierda();
		}
		return nodo;
	}

	public boolean buscar(IPersona persona, Comparator<IPersona> Criterio, Comparator<IPersona> Criterio2) {	
		if (buscarRec(raiz, persona, Criterio) != null) { // Primero buscamos con el primer criterio
			if (buscarRec(raiz, persona, Criterio2) != null) { // Si también se encuentra con el segundo criterio, entonces la persona está en el árbol
			return true;
			}
		}
		return false;
	}
	public INodo buscarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio) {
		if (nodo == null) {
			return null; // Si el nodo es nulo, no se encontró la persona
		}
		int comparacion = Criterio.compare(persona, nodo.getPersona());
		if (comparacion < 0) {
			return buscarRec(nodo.getIzquierda(), persona, Criterio); // Buscar en el subárbol izquierdo
		} else if (comparacion > 0) {
			return buscarRec(nodo.getDerecha(), persona, Criterio); // Buscar en el subárbol derecho
		} else {
			return nodo; // Se encontró la persona
		}
	}
}
