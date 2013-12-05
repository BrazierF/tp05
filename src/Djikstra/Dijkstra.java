package Djikstra;
import java.util.ArrayList;

import Maze.MBox;

public class Dijkstra {

	private static PreviousInterface dijkstra(GraphInterface g,
			VertexInterface r, ArrayList<VertexInterface> a, PiInterface pi,
			PreviousInterface previous) {
		for (MBox x : g) {
			x.pi()=100
		}
		r.pi()=0;
		for (VertexInterface x : g.getSuccessors(r)) {
			if (pi(r)+weight(x,r)<pi(x)) {
				pi(x)=pi(r)+weight(x,r);
				previous(x)=r
			}
		
		}
		
		
		return previous;
	}
}
