package InterfaceGraphique;

import java.io.IOException;

import Maze.Maze;
import Maze.MazeReadingException;
import fr.enst.inf103.ui.MazeViewController;
import fr.enst.inf103.ui.MazeViewSource;

public class MazeController implements MazeViewController {
private Maze maze ;
public MazeController(Maze maze){
	this.maze=maze;
	
}


	public void calculateShortestPath() {
		
		
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

