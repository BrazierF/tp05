package Maze;

// Classe des cases de départ

public class DBox extends MBox {
	public DBox(int x0, int y0) {
		super(x0, y0);
	}

	public String getLabel() {
		return "DBox";
	}

	public String getInitial() {
		return "D";
	}
}
