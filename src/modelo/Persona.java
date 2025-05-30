package modelo;

import interfaces.IPersona;

public class Persona implements IPersona {
	// defino atributos de la clase persona
	private final String nombre;
	private final int dni; // atributo por el cual se ordenará el arbol!!
	
	// constructor de la persona
	public Persona(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	// getters y setters
	@Override
	public String getNombre() {
		return nombre;
	}

	// no tiene sentido que alguien de fuera cambie el nombre de mi persona, por eso lo sacamos!!
	/*
	public void setNombre(String nombre) {
		Nombre = nombre;
	}*/

	// getter para obtener DNI
	@Override
	public int getDNI() {
		return dni;
	}

	// lo mismo para DNI, no tiene sentido que alguien de fuera lo cambie!
	/*
	public void setDNI(int dNI) {
		DNI = dNI;
	} */


	// toString() -->
	@Override
	public String toString() {
		return "Persona [Nombre=" + nombre + ", DNI=" + dni + "]";
	}
	
	
	

}
