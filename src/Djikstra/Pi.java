package Djikstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Integer> implements
		PiInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void setValue(VertexInterface vertex, int value) {
		put(vertex,value);
	};

	public int getValue(VertexInterface vertex) {
		return get(vertex);
	};
}
