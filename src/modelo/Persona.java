package modelo;

public class Persona {
	// defino atributos de la clase persona
	private String Nombre;
	private int DNI;
	
	// constructor de la persona
	public Persona(String nombre, int dNI) {
		super();
		Nombre = nombre;
		DNI = dNI;
	}
	
	// getters y setters
	public String getNombre() {
		return Nombre;
	}

	// no tiene sentido que alguien de fuera cambie el nombre de mi persona, por eso lo sacamos!!
	/*
	public void setNombre(String nombre) {
		Nombre = nombre;
	}*/

	// getter para obtener DNI
	public int getDNI() {
		return DNI;
	}

	// lo mismo para DNI, no tiene sentido que alguien de fuera lo cambie!
	/*
	public void setDNI(int dNI) {
		DNI = dNI;
	} */


	// toString() -->
	@Override
	public String toString() {
		return "Persona [Nombre=" + Nombre + ", DNI=" + DNI + "]";
	}
	
	
	

}
