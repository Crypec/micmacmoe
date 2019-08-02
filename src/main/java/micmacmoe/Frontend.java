package micmacmoe;

public abstract class Frontend {

    protected Board gameBoard;
    protected int playerIndex = 0;
    protected Player[] players;

    // used for constructing the gui
    protected int xSize;
    protected int ySize;
    
    protected Frontend(int xSize, int ySize, Player[] players) {
	this.gameBoard = new Board(xSize, ySize);
	this.players = players;

	this.xSize = xSize;
	this.ySize = ySize;
    }

    protected void updateCurrentPlayer() {
	int playerCount = this.players.length -1;
	if (this.playerIndex == playerCount) {
	    this.playerIndex = 0;
	} else {
	    this.playerIndex += 1;
	}
    }

    protected Player getCurrentPlayer() {
	return this.players[this.playerIndex];
    }

    public abstract void start();
}
