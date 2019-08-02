package micmacmoe;

public class CLIFrontend extends Frontend {
    public CLIFrontend(int xSize, int ySize, Player[] players) {
	super(xSize, ySize, players);
    }
    public void start() {
	System.out.println("start");

    }
    public Point advanceGame() {
	System.out.println("advance!");
	return new Point(0, 0);

    }
}
