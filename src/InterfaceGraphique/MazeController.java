package InterfaceGraphique;

import java.io.IOException;

import Djikstra.*;
import Maze.*;
import fr.enst.inf103.ui.*;

public class MazeController implements MazeViewController {
	private Maze maze ;
	
	public MazeController(Maze maze) {
		this.maze=maze;
	}
	
	public MazeController() {
		maze=new Maze(10,10);
	}
	
	public void calculateShortestPath() {
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous pere = new Previous();
		DBox src = maze.getSrc();
	    ABox dst =maze.getDst();
		Dijkstra.dijkstra(maze,src , pi, pere, a);
		for (VertexInterface sommetX : pere.getShortestPathTo(dst)){
			maze.setSymbolForBox(sommetX.getX(), sommetX.getY(), "HEBox");
		}
		maze.setSymbolForBox(src.getX(), src.getY(), "DBox");
		maze.setSymbolForBox(dst.getX(), dst.getY(), "ABox");
	}


	public MazeViewSource getMazeViewSource() {	
		return maze;
	}


	public MazeViewSource newMaze() {

maze = new Maze (10,10);
return (maze);

	}

	public MazeViewSource openMaze(String arg0) {

maze = new Maze (10,10);
	try {
		maze.initFromTextFile2(arg0);
	} catch (MazeReadingException e) {
System.out.print("erreur");
	}
return(maze);

}

	public void saveMazeAs(String arg0) {try {
		maze.saveToTextFile(arg0);
	} catch (IOException e) {
System.out.print("Erreur I/O");
	}
	}

}

