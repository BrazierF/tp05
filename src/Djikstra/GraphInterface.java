package Djikstra;

import java.util.ArrayList;

public interface GraphInterface {

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);

	public ArrayList<VertexInterface> getAllVertices();

	public int getWeight(VertexInterface src, VertexInterface dst);

}
