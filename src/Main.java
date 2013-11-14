public class Main {

	public static void main(String[] args) {
		Maze m = new Maze(10);
		for (MBox x:(m.estVoisinDe(2, 4))){
			x.affiche();
		}

	}
}
