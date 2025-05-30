package test;

import java.util.Comparator;

import interfaces.IPersona;
import modelo.Arbol;
import modelo.Persona;
import interfaces.IArbol;


public class TestArbol {

	public static void main(String[] args) {
		Comparator<IPersona> criterioPorNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()); // Compara por nombre
        Comparator<IPersona> criterioPorDNI = (p1, p2) -> Integer.compare(p1.getDNI(), p2.getDNI()); // Compara por DNI

		IPersona[] personas = { // Creamos un array de personas para insertar en el árbol
			new Persona("Juan", 12345678),
			new Persona("Ana", 23456789),
			new Persona("Luis", 34567890),
			new Persona("Maria", 45678901),
			new Persona("Pedro", 56789012),
			new Persona("Sofia", 67890123),
			new Persona("Carlos", 78901234),
			new Persona("Lucia", 89012345),
			new Persona("Miguel", 90123456),
			new Persona("Valentina", 11223344),
			new Persona("Javier", 22334455),
			new Persona("Camila", 33445566),
			new Persona("Diego", 44556677),
			new Persona("Florencia", 55667788),
			new Persona("Mateo", 66778899)
		};

        IArbol<IPersona> arbolPorNombre = new Arbol<>();
        IArbol<IPersona> arbolPorDNI = new Arbol<>();

		for (IPersona per : personas) {
			arbolPorNombre.insertar(per, criterioPorNombre);
			arbolPorDNI.insertar(per, criterioPorDNI);
		}
		System.out.println("Árbol por nombre:");
		
		System.out.println("\nPreorden:");
		arbolPorNombre.preOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en preorden por nombre
		System.out.println("\nInorden:");
		arbolPorNombre.inOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en inorden por nombre
		System.out.println("\nPostorden:");
		arbolPorNombre.postOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en postorden por nombre

		System.out.println("\n--------------------------");

		System.out.println("\nÁrbol por DNI:");
		System.out.println("\nPreorden:");
		arbolPorDNI.preOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en preorden por DNI
		System.out.println("\nInorden:");
		arbolPorDNI.inOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en inorden por DNI
		System.out.println("\nPostorden:");
		arbolPorDNI.postOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en postorden por DNI

		System.out.println("\n--------------------------");


		// Búsqueda de una persona por nombre
		System.out.println("\nBuscando a Pedro en el árbol por nombre:"); //Compara tanto el nombre como el DNI
		System.out.println(arbolPorNombre.buscar(new Persona("Pedro", 56789012), criterioPorNombre, criterioPorDNI) ? "Encontrado" : "No encontrado");
		System.out.println("\nBuscando a PersonaQueNoEsta en el árbol por nombre:");
		System.out.println(arbolPorNombre.buscar(new Persona("PersonaQueNoEsta", 56789012), criterioPorNombre, criterioPorDNI) ? "Encontrado" : "No encontrado");
		System.out.println("\nBuscando a Pedro con mal puesto su DNI en el árbol por nombre:");
		System.out.println(arbolPorNombre.buscar(new Persona("Pedro", 87654321), criterioPorNombre, criterioPorDNI) ? "Encontrado" : "No encontrado");

		System.out.println("\n--------------------------");


		// Eliminación de una persona por nombre
		System.out.println("\nEliminando a Ana de los arboles:");
		arbolPorDNI.eliminar(personas[1], criterioPorDNI);
		arbolPorNombre.eliminar(personas[1], criterioPorNombre);
		System.out.println("\nEliminando a Camila de los arboles:");
		arbolPorDNI.eliminar(personas[11], criterioPorDNI);
		arbolPorNombre.eliminar(personas[11], criterioPorNombre);

		System.out.println("\n--------------------------");


		System.out.println("\nÁrbol por nombre después de la eliminación:");
		System.out.println("\nPreorden:");
		arbolPorNombre.preOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en preorden después de la eliminación
		System.out.println("\nInorden:");
		arbolPorNombre.inOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en inorden después de la eliminación
		System.out.println("\nPostorden:");
		arbolPorNombre.postOrder(arbolPorNombre.getRaiz()); // Imprime el árbol en postorden después de la eliminación

		System.out.println("\nÁrbol por DNI después de la eliminación:");
		System.out.println("\nPreorden:");
		arbolPorDNI.preOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en preorden después de la eliminación
		System.out.println("\nInorden:");
		arbolPorDNI.inOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en inorden después de la eliminación
		System.out.println("\nPostorden:");
		arbolPorDNI.postOrder(arbolPorDNI.getRaiz()); // Imprime el árbol en postorden después de la eliminación

	}
}
