package micmacmoe;

public class CLIFrontend extends Frontend {
    public CLIFrontend(int xSize, int ySize, String[] players) {
	super(xSize, ySize, players);
    }
    public void play() {
	System.out.println("play!");

    }
    public void advanceGame() {
	System.out.println("advance!");

    }
}
