import java.io.FileNotFoundException;



public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Maze m = new Maze(10);
		for (MBox x : (m.estVoisinDe(4, 4))) {
			x.affiche();
		}

	for (VertexInterface x : (m.getAllVertices())) {
			x.affiche();

		} 
		
		for (VertexInterface x : (m.getSuccessors(m.get(4,4)))) {
			x.affiche();
		}
		
	
	m.initFromTextFile("data/labyrinth");
	}
}


