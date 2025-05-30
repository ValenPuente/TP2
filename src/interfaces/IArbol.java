package interfaces;
import java.util.Comparator;

public interface IArbol<T> {
	public void insertar(T elemento, Comparator<T> comparador);

	public INodo<T> insertarRec(INodo<T> nodo, T elemento, Comparator<T> comparador);

	public void preOrder(INodo<T> nodo);
	public void inOrder(INodo<T> nodo);
	public void postOrder(INodo<T> nodo);

	public INodo<T> getRaiz();
	public void setRaiz(INodo<T> raiz);

	public void eliminar(T elemento, Comparator<T> comparador);
	public INodo<T> eliminarRec(INodo<T> nodo, T elemento, Comparator<T> comparador);

	public INodo<T> encontrarMinimo(INodo<T> nodo);

	public boolean buscar(T elemento, Comparator<T> comparador, Comparator<T> comparador2);
	public INodo<T> buscarRec(INodo<T> nodo, T elemento, Comparator<T> comparador);
}
