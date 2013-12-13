
public class MazeReadingException extends Exception {
	public MazeReadingException(String fichier,int noLigne, String msgErreur){
		super(msgErreur+" à la ligne "+noLigne+" dans le fichier "+fichier);
	}

}
