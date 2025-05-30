package interfaces;

public interface INodo<T> {
	
	public T getDato();
	
	public void setDato(T dato);
		

	public INodo<T> getDerecha();
	
	public void setDerecha(INodo<T> derecha);
		

	public INodo<T> getIzquierda();
		

	public void setIzquierda(INodo<T> izquierda);
		

	}

