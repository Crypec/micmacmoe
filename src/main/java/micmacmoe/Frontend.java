package micmacmoe;

public abstract class Frontend {

    protected Board gameBoard;
    protected int playerIndex;
    protected Player[] players;

    // used for constructing the gui
    protected int xSize;
    protected int ySize;
    
    protected Frontend(int xSize, int ySize, String[] players) {
	this.gameBoard = new Board(xSize, ySize);
	this.playerIndex = 0;
	this.players = players;
    }

    protected void updateCurrentPlayer() {
	this.playerIndex = (this.playerIndex == this.players.length -1) ? 0 : this.playerIndex + 1;
    }

    protected String getCurrentPlayer() {
	return this.players[this.playerIndex];
    }

    public abstract void play();
}
