import java.util.ArrayList;

public class Maze {
	private ArrayList<MBox> mazeList;

	public ArrayList<MBox> estVoisinDe(int x, int y) {
		ArrayList<MBox> voisins = new ArrayList<MBox>();
		int z = 10*x + y;
		switch (x){
		case 0 : 
			switch (y){
			case 0 : voisins.add(mazeList.get(z+1));
			         voisins.add(mazeList.get(z+10));
			         break;
			case 9:  voisins.add(mazeList.get(z-1));
	                 voisins.add(mazeList.get(z+10));
	                 break;
	        default : voisins.add(mazeList.get(z-1));
	                  voisins.add(mazeList.get(z+1));
	                  voisins.add(mazeList.get(z+10));
	                  break;
					}
		case 9:
			switch (y) {
			case 0:
				voisins.add(mazeList.get(z - 10));
				voisins.add(mazeList.get(z + 1));
				break;
			case 9:
				voisins.add(mazeList.get(z - 10));
				voisins.add(mazeList.get(z - 1));
				break;
			default:
				voisins.add(mazeList.get(z - 1));
				voisins.add(mazeList.get(z + 1));
				voisins.add(mazeList.get(z - 10));
			}
		 default :
			 switch (y){
				case 0 : voisins.add(mazeList.get(z+1));
				         voisins.add(mazeList.get(z+10));
				         voisins.add(mazeList.get(z-10));
				         break;
				case 9:  voisins.add(mazeList.get(z-1));
		                 voisins.add(mazeList.get(z+10));
		                 voisins.add(mazeList.get(z-10));
		                 break;
		        default : voisins.add(mazeList.get(z-1));
		                  voisins.add(mazeList.get(z+1));
		                  voisins.add(mazeList.get(z+10));
		                  voisins.add(mazeList.get(z-10));
		                  break;
						}
			}
		}
	
}
