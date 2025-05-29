package interfaces;
import java.util.Comparator;

public interface IArbol {
	
	public void insertar(IPersona persona, Comparator<IPersona> Criterio);

	public INodo insertarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio);
	
	public void preOrder(INodo nodo);
	
	public void inOrder(INodo nodo);
	
	public void postOrder(INodo nodo);

	public INodo getRaiz();

	public void setRaiz(INodo raiz);

	public void eliminar(IPersona persona, Comparator<IPersona> Criterio);

	public INodo eliminarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio);

	public INodo encontrarMinimo(INodo nodo);

	public boolean buscar(IPersona persona, Comparator<IPersona> Criterio, Comparator<IPersona> Criterio2);

	public INodo buscarRec(INodo nodo, IPersona persona, Comparator<IPersona> Criterio);
}
