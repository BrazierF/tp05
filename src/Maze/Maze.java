package Maze;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Djikstra.GraphInterface;
import Djikstra.VertexInterface;
import fr.enst.inf103.ui.MazeView;
import fr.enst.inf103.ui.MazeViewSource;

public class Maze implements GraphInterface , MazeViewSource {
	private MBox[][] mazeMatrix;
	private int width ;
	private int height;

	public Maze(int h,int w) {
		this.mazeMatrix = new MBox[h][w];
		width=w;
		height=h;
		for (int i = 0; i <= (h - 1); i++) {
			for (int j = 0; j <= (w - 1); j++) {
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
		if (vertex.getLabel()!="WBox"){
		for (VertexInterface X : estVoisinDe(box.getX(), box.getY())) {
			if (X.getLabel() != "WBox") {
				successeurs.add(X);
			}
		}}
		return successeurs;

	}
	
	public int getWeight(VertexInterface src,VertexInterface dst) {
		MBox destination = (MBox) dst;
		if (src.getLabel()!="WBox"){
		for (VertexInterface X : getSuccessors(src) ) {
			MBox Y = (MBox)X;
			if (Y.getX()==destination.getX() && Y.getY()==destination.getY()){return 1;}}}
		return(-1);
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
			throws MazeReadingException
{
		File fichiersource = new File(text);
		BufferedReader txtALire = null;
		BufferedReader txtALire2 = null;
		int i = 0;int nbDeDepart =0 ; int nbDArrivee = 0 ;
		try {
			txtALire = new BufferedReader(new FileReader(fichiersource));
			txtALire2= new BufferedReader(new FileReader(
					fichiersource));
			String x = txtALire2.readLine();
			width = x.length();
			height = 0 ;
			while(x!=null){
				height++;
				if (x.length()!=width) {txtALire2.close();throw new MazeReadingException(text,height,"Il n'y a pas le bon nombre de cases ("+(x.length()+")"));}
				x=txtALire2.readLine();
			}
			txtALire2.close();
			char s = (char) txtALire.read();
			mazeMatrix = new MBox[height][width];
			while ((int) s != 65535) {
				if (s == 'A') {
					ABox boite = new ABox(i / width, i % width);
					mazeMatrix[i / width][i % width] = boite;
					s = (char) txtALire.read();
					i = i + 1;
					nbDArrivee++;
				} else {
					if (s == 'E') {
						EBox boite = new EBox(i / width, i % width);
						mazeMatrix[i / width][i % width] = boite;
						s = (char) txtALire.read();
						i = i + 1;
					} else {
						if (s == 'W') {
							WBox boite = new WBox(i / width, i % width);
							mazeMatrix[i / width][i % width] = boite;
							s = (char) txtALire.read();
							i = i + 1;
						} else {
							if (s == 'D') {
								DBox boite = new DBox(i / width, i % width);
								mazeMatrix[i / width][i % width] = boite;
								s = (char) txtALire.read();
								i = i + 1;
								nbDeDepart++;
							} else { if ( (int)s!=10){
								throw (new MazeReadingException(text,i/width+1,"Le caractère '"+s+"' n'est pas attendu"));
							} else {
								s = (char) txtALire.read();}
								
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé");
		} catch (IOException e) {
			System.out.println("Problème de lecture entrée/sortie"
					+ i);
		} finally {if(nbDeDepart!=1){throw (new MazeReadingException(text,"Il y a " +nbDeDepart+" case(s) depart"));}
		if(nbDArrivee!=1){throw (new MazeReadingException(text,"Il y a " +nbDArrivee+" case(s) arrivee"));}
			try {
					txtALire.close();
				}
			 catch (IOException e) {
				System.out
						.println("Erreur dans la fermeture du fichier source");
			}	
		}
	}

	public final void saveToTextFile(String fileName) throws IOException {
		File fichier = new File(fileName+".txt");
		PrintWriter out = new PrintWriter(new FileWriter(fichier));
		for (int i = 0; i <= (height - 1); i++) {
			for (int j = 0; j <= (width - 1); j++) {
				out.write((mazeMatrix[i][j]).getInitial());
			}
			;
			out.println();
		}
		out.close();
	}

	public boolean drawMaze(Graphics arg0, MazeView arg1) {
		return false;
	}

	public int getHeight() {
		return height;
	}

	public String getSymbolForBox(int arg0, int arg1) {
		try{return mazeMatrix[arg0][arg1].getInitial();}
		catch (ArrayIndexOutOfBoundsException e){return("Hors Tableau");}
	}

	public int getWidth() {
		return (width);
	}

	public boolean handleClick(MouseEvent arg0, MazeView arg1) {
		return false;
	}

	public boolean handleKey(KeyEvent arg0, MazeView arg1) {
		return false;
	}

	public void setSymbolForBox(int arg0, int arg1, String arg2) {
		if (arg2.equals("ABox")) {
			ABox boite = new ABox(arg0, arg1);
			mazeMatrix[arg0][arg1] = boite;
		} else {
			if (arg2.equals("EBox")) {
				EBox boite = new EBox(arg0, arg1);
				mazeMatrix[arg0][arg1] = boite;
			} else {
				if (arg2.equals("WBox")) {
					WBox boite = new WBox(arg0, arg1);
					mazeMatrix[arg0][arg1] = boite;
				} else {
					if (arg2.equals("DBox")) {
						DBox boite = new DBox(arg0, arg1);
						mazeMatrix[arg0][arg1] = boite;
					}
					}
				}
			}
		}

	}

