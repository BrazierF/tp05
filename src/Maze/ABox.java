package Maze;

// Classe des cases d'arrivées

public class ABox extends MBox {
	public ABox(int x0, int y0) {
		super(x0, y0);
	}

	public String getLabel() {
		return "ABox";
	}

	public String getInitial() {
		return "A";
	}
}
