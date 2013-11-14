import java.util.ArrayList;

public class Maze {
	private MBox[][] mazeMatrix;

	public Maze(int n) {
		this.mazeMatrix = new MBox[n][n];
		for (int i = 0; i <= (n - 1); i++) {
			for (int j = 0; j <= (n - 1); j++) {
				mazeMatrix[i][j] = new MBox(i, j);
			}
		}
	}

	public ArrayList<MBox> estVoisinDe(int x, int y) {
		ArrayList<MBox> voisins = new ArrayList<MBox>();
		/*int z = 10*x + y;*/
		switch (x){
		case 0 : 
			switch (y){
			case 0 : voisins.add(mazeMatrix[x][y+1]);
			         voisins.add(mazeMatrix[x+1][y]);
			         break;
			case 9:  voisins.add(mazeMatrix[x][y-1]);
	                 voisins.add(mazeMatrix[x+1][y]);
	                 break;
	        default : voisins.add(mazeMatrix[x+1][y]);
	                  voisins.add(mazeMatrix[x-1][y]);
	                  voisins.add(mazeMatrix[x][y+1]);
	                  break;
					}
		case 9:
			switch (y) {
			case 0:
				voisins.add(mazeMatrix[x][y+1]);
				voisins.add(mazeMatrix[x-1][y]);
				break;
			case 9:
				voisins.add(mazeMatrix[x][y-1]);
				voisins.add(mazeMatrix[x-1][y]);
				break;
			default:
				voisins.add(mazeMatrix[x][y-1]);
				voisins.add(mazeMatrix[x][y+1]);
				voisins.add(mazeMatrix[x-1][y]);
			}
		 default :
			 switch (y){
				case 0 : voisins.add(mazeMatrix[x+1][y]);
				         voisins.add(mazeMatrix[x-1][y]);
				         voisins.add(mazeMatrix[x][y+1]);
				         break;
				case 9:  voisins.add(mazeMatrix[x+1][y]);
		                 voisins.add(mazeMatrix[x-1][y]);
		                 voisins.add(mazeMatrix[x][y-1]);
		                 break;
		        default : voisins.add(mazeMatrix[x][y-1]);
		                  voisins.add(mazeMatrix[x][y+1]);
		                  voisins.add(mazeMatrix[x-1][y]);
		                  voisins.add(mazeMatrix[x+1][y]);
		                  break;
						}
			}
		return (voisins);
		}
	

	
}
