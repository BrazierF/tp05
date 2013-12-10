package Maze;
import fr.enst.inf103.ui.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

import Djikstra.GraphInterface;
import Djikstra.VertexInterface;

public class Maze implements GraphInterface , MazeViewSource {
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

	public void set(int x, int y, MBox w) {
		mazeMatrix[x][y] = w;
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

	public final void initFromTextFile(String text) throws MazeReadingException {
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

	public final void initFromTextFile2(String text)
			throws MazeReadingException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		File fichiersource = new File(text);
		BufferedReader txtALire = null;
		int i = 0;
		try {
			txtALire = new BufferedReader(new FileReader(fichiersource));
			BufferedReader txtALire2 = new BufferedReader(new FileReader(
					fichiersource));
			int l = txtALire2.readLine().length();
			txtALire2.close();
			char s = (char) txtALire.read();
			mazeMatrix = new MBox[l][l];
			while ((int) s != 65535) {
				if (s == 'A') {
					ABox boite = new ABox(i / l, i % l);
					mazeMatrix[i / l][i % l] = boite;
					s = (char) txtALire.read();
					i = i + 1;
				} else {
					if (s == 'E') {
						EBox boite = new EBox(i / l, i % l);
						mazeMatrix[i / l][i % l] = boite;
						s = (char) txtALire.read();
						i = i + 1;
					} else {
						if (s == 'W') {
							WBox boite = new WBox(i / l, i % l);
							mazeMatrix[i / l][i % l] = boite;
							s = (char) txtALire.read();
							i = i + 1;
						} else {
							if (s == 'D') {
								DBox boite = new DBox(i / l, i % l);
								mazeMatrix[i / l][i % l] = boite;
								s = (char) txtALire.read();
								i = i + 1;
							} else {
								s = (char) txtALire.read();
							}
						}
					}
				}
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

	public final void saveToTextFile(String fileName) throws IOException {
		File fichier = new File("data/" + fileName);
		PrintWriter out = new PrintWriter(new FileWriter(fichier));
		int n = mazeMatrix.length;
		for (int i = 0; i <= (n - 1); i++) {
			for (int j = 0; j <= (n - 1); j++) {
				out.write((mazeMatrix[i][j]).getInitial());
			}
			;
			out.println();
		}
		out.close();
	}

	@Override
	public boolean drawMaze(Graphics arg0, MazeView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return mazeMatrix.length;
	}

	public String getSymbolForBox(int arg0, int arg1) {
		try{return mazeMatrix[arg0][arg1].getInitial();}
		catch (ArrayIndexOutOfBoundsException e){return("Hors Tableau");}
	}

	@Override
	public int getWidth() {
		return (mazeMatrix[0].length);
	}

	@Override
	public boolean handleClick(MouseEvent arg0, MazeView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleKey(KeyEvent arg0, MazeView arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSymbolForBox(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}
}
