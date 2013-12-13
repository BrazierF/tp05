package InterfaceGraphique;

import Maze.*;
import fr.enst.inf103.ui.*;

public class MazeController implements MazeViewController {

	@Override
	public void calculateShortestPath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MazeViewSource getMazeViewSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MazeViewSource newMaze() {
Maze m = new Maze (10,10);
MazeController mazeController = new MazeController();
MazeWindow mW= new MazeWindow("new maze",mazeController);
m.drawMaze(mW.getGraphics(),new MazeView(m));
return (m);
	}

	@Override
	public MazeViewSource openMaze(String arg0) {
Maze m = new Maze (10,10);
	try {
		m.initFromTextFile2(arg0);
	} catch (MazeReadingException e) {
		// TODO Auto-generated catch block
System.out.print("erreur");
	} catch (InstantiationException e) {
		System.out.print("erreur");
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		System.out.print("erreur");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		System.out.print("erreur");
		e.printStackTrace();
	}
return(m);
}
	@Override
	public void saveMazeAs(String arg0) {
	}

}
