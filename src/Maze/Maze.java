package Maze;

import java.io.*;
import java.util.ArrayList;

import Djikstra.GraphInterface;
import Djikstra.VertexInterface;

public class Maze implements GraphInterface {
	private MBox[][] mazeMatrix;

	public Maze(int n) {
		this.mazeMatrix = new MBox[n][n];
		for (int i = 0; i <= (n - 1); i++) {
			for (int j = 0; j <= (n - 1); j++) {
				mazeMatrix[i][j] = new EBox(i, j);
			}
		}
	}

	public VertexInterface get(int x, int y) {
		return mazeMatrix[x][y];
	}

	public ArrayList<MBox> estVoisinDe(int x, int y) {
		ArrayList<MBox> voisins = new ArrayList<MBox>();
		try {
			voisins.add(mazeMatrix[x][y - 1]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			voisins.add(mazeMatrix[x][y + 1]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			voisins.add(mazeMatrix[x - 1][y]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			voisins.add(mazeMatrix[x + 1][y]);
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return (voisins);

	}

	public ArrayList<VertexInterface> getAllVertices() {
		int n = mazeMatrix.length;
		ArrayList<VertexInterface> casesAccessibles = new ArrayList<VertexInterface>();
		for (int i = 0; i <= (n - 1); i++) {
			for (int j = 0; j <= (n - 1); j++) {
				if (mazeMatrix[i][j].getLabel() != "WBox") {
					casesAccessibles.add(mazeMatrix[i][j]);
				}
			}
		}
		return casesAccessibles;
	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		ArrayList<VertexInterface> successeurs = new ArrayList<VertexInterface>();
		for (VertexInterface X : estVoisinDe(box.getX(), box.getY())) {
			if (X.getLabel() != "WBox") {
				successeurs.add(X);
			}
		}
		return successeurs;

	}

	public final void initFromTextFile(String text) throws MazeReadingException{
		File fichiersource = new File(text);
		BufferedReader txtALire = null;
		int i = 1;
		try {
			txtALire = new BufferedReader(new FileReader(fichiersource));
			String s = txtALire.readLine();
			while (s != null) {
				System.out.println(s);
				s = txtALire.readLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println("Problème de lecture entrée/sortie à la ligne" + i);
		} finally {
			try {if(txtALire!=null){
				txtALire.close();}
			} catch (IOException e) {
				System.out
						.println("Erreur dans la fermeture du fichier source");
			}
		}
	}
	
	public final void initFromTextFile2(String text)
			throws MazeReadingException {
		File fichiersource = new File(text);
		BufferedReader txtALire = null;
		int i = 1;
		try {
			txtALire = new BufferedReader(new FileReader(fichiersource));
			BufferedReader txtALire2 = new BufferedReader(new FileReader(fichiersource));
			Maze maze = new Maze((txtALire2.readLine()).length());
			char s = (char) txtALire.read();
			while ((int) s != (-1)) {
				Class c = Class.forName(s+"Box");			
				mazeMatrix[m][n]=c.newInstance();
				s = (char) txtALire.read();
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println("Problème de lecture entrée/sortie à la ligne"
					+ i);
		} finally {
			try {
				if (txtALire != null) {
					txtALire.close();
				}
			} catch (IOException e) {
				System.out
						.println("Erreur dans la fermeture du fichier source");
			}
		}
	}
}