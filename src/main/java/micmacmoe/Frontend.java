package micmacmoe;

public abstract class Frontend {

    protected Board gameBoard;
    protected int playerIndex;
    protected Player[] players;

    // used for constructing the gui
    protected int xSize;
    protected int ySize;
    
    protected Frontend(int xSize, int ySize, Player[] players) {
	this.xSize = xSize;
	this.ySize = ySize;
	this.gameBoard = new Board(xSize, ySize);
	this.playerIndex = 0;
	this.players = players;
    }

    protected void updateCurrentPlayer() {
	System.out.println(playerIndex);
	int playerCount = this.players.length -1;
	if (this.playerIndex == playerCount) {
	    this.playerIndex = 0;
	} else {
	    this.playerIndex += 1;
	}
	this.playerIndex = (this.playerIndex == this.players.length -1) ? 0 : this.playerIndex + 1;
    }

    protected Player getCurrentPlayer() {
	return this.players[this.playerIndex];
    }

    public abstract void start();
}
