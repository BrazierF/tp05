import java.io.IOException;

import Djikstra.ASet;
import Djikstra.Dijkstra;
import Djikstra.Pi;
import Djikstra.Previous;
import Djikstra.VertexInterface;
import InterfaceGraphique.MazeController;
import Maze.Maze;
import Maze.MazeReadingException;
import fr.enst.inf103.ui.MazeWindow;

public class Main {

	public static void main(String[] args) throws MazeReadingException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException {
		Maze m = new Maze(10,10);/*
		for (MBox x : (m.estVoisinDe(4, 4))) {
			x.affiche();
		}

		for (VertexInterface x : (m.getAllVertices())) {
			x.affiche();

		}

		for (VertexInterface x : (m.getSuccessors(m.get(4, 4)))) {
			x.affiche();
		}*/

		m.initFromTextFile2("data/labyrinthe.txt");
		System.out.print(m.getWeight(m.get(2,5), m.get(1,5)));
		for (VertexInterface X : m.getSuccessors(m.get(1, 5))){System.out.println(X.getLabel());X.affiche();}
		

	m.saveToTextFile("test");
		MazeController mazeController = new MazeController();
		MazeWindow mazeWindow = new MazeWindow("Labyrinthe", mazeController);
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous pere = new Previous();
		Dijkstra.dijkstra(m, m.get(0, 1), pi, pere, a);
		for (VertexInterface Y : pere.getShortestPathTo(m.get(6,8 )) ){
		Y.affiche();
		}

for(int i = 0 ; i<=9;i++){
	for(int j = 0 ; j<=9;j++){System.out.print(m.getSymbolForBox(i, j));}}


	}
}