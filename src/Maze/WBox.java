package Maze;

// Classe des cases murées

public class WBox extends MBox {
	public WBox(int x0, int y0) {
		super(x0, y0);
	}

	public String getLabel() {
		return "WBox";
	}

	public String getInitial() {
		return "W";
	}
}
