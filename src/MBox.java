public class MBox implements VertexInterface {
	private int x;
	private int y;

	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("(" + x + "," + y + ")");
	}

	public String getLabel;
}
