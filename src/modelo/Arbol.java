package modelo;

import interfaces.IArbol;
import interfaces.INodo;
import java.util.Comparator;

public class Arbol<T> implements IArbol<T> {
	// atributo ->
	private INodo<T> raiz; // tiene un solo atributo, que es la raíz, que no cambia nunca y es el primer nodo insertado

	// constructor -->
	public Arbol() {
		super();
		this.raiz = null; // cuando creamos el árbol, no sabemos cúal es el primer nodo que insertaremos!
	}

	// getter y setters de raíz
	@Override
	public INodo<T> getRaiz() {
		return raiz;
	}

	@Override
	public void setRaiz(INodo<T> raiz) {
		this.raiz = raiz;
	}

	// primitivas del árbol ->

	@Override
	public void insertar(T dato, Comparator<T> criterio) { // método que se llamará del main y que recibe el dato a insertar, es decir, la instancia de la clase persona!!
		raiz = insertarRec(raiz, dato, criterio); // igualamos raiz al retorno de la función 
	}

	@Override
	public INodo<T> insertarRec(INodo<T> nodo, T dato, Comparator<T> criterio) {// recibimos como dato un dato genérico (que es una instancia de clase Persona), que deberemos insertar en 
		// nuestro árbol y un nodo que representa el nodo raíz de cada subárbol que formemos!-->
		// primero verificamos si el nodo raíz en el que estamos parados está vacío o no --> sería mi caso base
		if (nodo == null) {// si lo está, significa que es el nodo donde debemos insertar nuestro elemento-->
			return new Nodo<>(dato); // retornamos el nodo creado con nuestro dato para poder insertarlo en el null en el que estamos parados!!
		}
		// si no está vacío --> 
		if (criterio.compare(dato, nodo.getDato()) > 0) {// si el criterio de comparación nos dice que el dato a insertar es mayor que el nodo actual, 
			//entonces debemos insertarlo en la derecha
			nodo.setDerecha(insertarRec(nodo.getDerecha(), dato, criterio)); // volvemos a llamar a la función pero pasando el nodo de la derecha, tal que es mi nueva raíz del
			// subárbol formado!
		} else if (criterio.compare(dato, nodo.getDato()) < 0) { // si el criterio de comparación nos dice que el dato a insertar es menor que el nodo actual, 
			//entonces debemos insertarlo en la izquierda
			nodo.setIzquierda(insertarRec(nodo.getIzquierda(), dato, criterio));
		}
		return nodo; // cuando no entremos a salgamos del if o else if, retornamos el nodo al anterior llamado!
	}

	@Override
	public void preOrder(INodo<T> nodo) { // nodo representa la raíz de cada subárbol formado, en el primer llamado del main representa la raíz
		if (nodo != null) { // caso base -->
			System.out.println(nodo.getDato());
			preOrder(nodo.getIzquierda());
			preOrder(nodo.getDerecha());
		}
	}

	@Override
	public void inOrder(INodo<T> nodo) {
		if (nodo != null) {
			inOrder(nodo.getIzquierda());
			System.out.println(nodo.getDato());
			inOrder(nodo.getDerecha());
		}
	}

	@Override
	public void postOrder(INodo<T> nodo) {
		if (nodo != null) {
			postOrder(nodo.getIzquierda());
			postOrder(nodo.getDerecha());
			System.out.println(nodo.getDato());
		}
	}

	@Override
	public void eliminar(T dato, Comparator<T> criterio){
		raiz = eliminarRec(raiz, dato, criterio);
	}

	@Override
	public INodo<T> eliminarRec(INodo<T> nodo, T dato, Comparator<T> criterio) {
		// primero verificamos si el nodo raíz en el que estamos parados está vacío o no --> sería mi caso base
		if (nodo == null) {
			return null;
		}
		if (criterio.compare(dato, nodo.getDato()) < 0) {
			nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), dato, criterio));
		} else if (criterio.compare(dato, nodo.getDato()) > 0) {
			nodo.setDerecha(eliminarRec(nodo.getDerecha(), dato, criterio));
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
			INodo<T> sucesor = encontrarMinimo(nodo.getDerecha()); // Paso como dato el nodo derecho, ya que el sucesor será el mínimo del subárbol derecho
			nodo.setDato(sucesor.getDato());
			nodo.setDerecha(eliminarRec(nodo.getDerecha(), sucesor.getDato(), criterio));
		}
		return nodo;
	}

	// Método para encontrar el nodo con el valor mínimo en un subárbol derecho y asi poder eliminarlo correctamente
	@Override
	public INodo<T> encontrarMinimo(INodo<T> nodo) {
		while (nodo.getIzquierda() != null) {
			nodo = nodo.getIzquierda();
		}
		return nodo;
	}

	@Override
	public boolean buscar(T dato, Comparator<T> criterio, Comparator<T> criterio2) { 
		if (buscarRec(raiz, dato, criterio) != null) { // Primero buscamos con el primer criterio
			if (buscarRec(raiz, dato, criterio2) != null) { // Si también se encuentra con el segundo criterio, entonces la persona está en el árbol
				return true;
			}
		}
		return false;
	}
	@Override
	public INodo<T> buscarRec(INodo<T> nodo, T dato, Comparator<T> criterio) {
		if (nodo == null) {
			return null; // Si el nodo es nulo, no se encontró la persona
		}
		int comparacion = criterio.compare(dato, nodo.getDato());
		if (comparacion < 0) {
			return buscarRec(nodo.getIzquierda(), dato, criterio); // Buscar en el subárbol izquierdo
		} else if (comparacion > 0) {
			return buscarRec(nodo.getDerecha(), dato, criterio); // Buscar en el subárbol derecho
		} else {
			return nodo; // Se encontró la persona
		}
	}
}
