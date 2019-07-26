package micmacmoe;

public abstract class Frontend {


    protected Board gameBoard;
    protected int playerIndex;
    protected String[] players;

    protected int xSize;
    protected int ySize;
    
    protected Frontend(int xSize, int ySize, String[] players) {
	this.gameBoard = new Board(xSize, ySize);
	this.playerIndex = 0;
	this.players = players;
    }

    protected void updateCurrentPlayer() {
	int index = this.playerIndex;
	this.playerIndex = index == (this.players.length - 1) ? 0 : index + 1;
    }

    protected String getCurrentPlayer() {
	return this.players[this.playerIndex];
    }

    public abstract void advanceGame();
    public abstract void play();
}
