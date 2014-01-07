package Maze;

// Classe des cases vides

public class EBox extends MBox {
	public EBox(int x0, int y0) {
		super(x0, y0);
	}

	public String getLabel() {
		return "EBox";
	}

	public String getInitial() {
		return "E";
	}
}
