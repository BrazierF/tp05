package Djikstra;

import java.util.HashSet;

public class Dijkstra {

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r,PiInterface pi,PreviousInterface pere,HashSet<VertexInterface> a) {
	int j = 0;
	a.add(r);
	VertexInterface pivot = r ;
	pi.setValue(r,0);
		for (VertexInterface sommetX : g.getAllVertices()){
		if (sommetX!=r){pi.setValue(sommetX, -1);
		}
	}
		while (j<a.size()){
	for (VertexInterface sommetY: g.getSuccessors(pivot)){
		if(!a.contains(sommetY)){
		 if (pi.getValue(pivot)+g.getWeight(pivot, sommetY)<pi.getValue(sommetY) || pi.getValue(sommetY)<0){
		 pi.setValue(sommetY,pi.getValue(pivot)+g.getWeight(pivot, sommetY));
		 pere.setValue(sommetY, pivot);
		 }
	    }
	}
	int i=0;int dstTempo=0;
	for (VertexInterface sommetY : g.getAllVertices()){
		if (!a.contains(sommetY)){			
			if(i==0 && pi.getValue(sommetY)>0){
			dstTempo=pi.getValue(sommetY);
			pivot=sommetY;
			sommetY.affiche();
			}
			else {
				if(pi.getValue(sommetY)<dstTempo && pi.getValue(sommetY)>0){
					pivot=sommetY;
					dstTempo = pi.getValue(sommetY);
			    }
			}
			i++;} 					
		}			
	a.add(pivot);
	pivot.affiche();
	System.out.print(j+","+a.size());
	j++;
	}
	return(pere);
	}

}


