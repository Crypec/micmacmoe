package micmacmoe;

public class CLIFrontend extends Frontend {
    public CLIFrontend(int xSize, int ySize, String[] players) {
	super(xSize, ySize, players);
    }
    public void play() {
	System.out.println("play!");

    }
    public Point advanceGame() {
	System.out.println("advance!");
	return new Point(0, 0);

    }
}
