import java.util.ArrayList;

public class Maze {
	private ArrayList<MBox> mazeList;
	
	public ArrayList<MBox> estVoisinDe(int x,int y){
		ArrayList<MBox> voisins = new ArrayList<MBox>();
		switch (x){
		case 0 : 
			switch (y){
			case 0 : voisins.add(mazeList.get(1));
			         voisins.add(mazeList.get(10));
				
			}
			}
		}
	}
}
