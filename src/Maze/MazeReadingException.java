package Maze;

public class MazeReadingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MazeReadingException(String fichier,int noLigne, String msgErreur){
		super(msgErreur+" à la ligne "+noLigne+" dans le fichier "+fichier);
			
	}
	public MazeReadingException(String fichier, String msgErreur){
		super(msgErreur+" dans le fichier "+fichier);
			
	}


}
