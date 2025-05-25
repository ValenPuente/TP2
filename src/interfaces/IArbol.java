package interfaces;

public interface IArbol {
	
	public void insertar(IPersona persona);

	public INodo insertarRec(INodo nodo, IPersona persona);
	
	public void preOrder(INodo nodo);
	
	public void inOrder(INodo nodo);
	
	public void postOrder(INodo nodo);

}
