import java.io.*;
import java.util.ArrayList;

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

}
	public final void initFromTextFile(String text) {
		File fichiersource = new File(text);
		BufferedReader txtALire = null;
		try {
			txtALire = new BufferedReader(new FileReader(fichiersource));
			String s = txtALire.readLine();
			while (s != null) {
				System.out.println(s);
				s = txtALire.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println("Problème de lecture entrée/sortie");
		} finally {
			try {if(txtALire!=null){
				txtALire.close();}
			} catch (IOException e) {
				System.out
						.println("Erreur dans la fermeture du fichier source");
			}
		}
	}
}
