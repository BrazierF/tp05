package Maze;

// Classe des cases parcourues à la fin de l'algorithme de Dijkstra

public class HEBox extends MBox {
	public HEBox(int x, int y) {
		super(x, y);
	}

	public String getLabel() {
		return "HEBox";
	}

	public String getInitial() {
		return "*";
	}
}
