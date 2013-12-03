package Djikstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface>
		implements PreviousInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void setValue(VertexInterface vertex, VertexInterface value) {
		put(vertex,value);

	}

	@Override
	public VertexInterface getValue(VertexInterface vertex) {
		return(get(vertex));
	}

	@Override
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		VertexInterface pere = vertex ;
		ArrayList<VertexInterface> lignéeDirecte = new ArrayList<VertexInterface>();
		while(pere!=null){
			lignéeDirecte.add(pere);
		pere=getValue(pere);				
	    }
		return(lignéeDirecte);
      
}
}
