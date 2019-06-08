package micmacmoe;

import javax.swing.*;

public class Game {

    private Board gameBoard;
    private int playerIndex;
    private String[] players; 

    public static class Builder {

	private Board gameBoard;
	private int playerIndex;
	private String[] players;

	public Builder() {}

	public Builder size(final int x, final int y) {
	    this.gameBoard = new Board(x, y);
	    return this;
	}

	// @TODO check that there are no duplicate Players -> HashSet
	public Builder players(String... players) {
	    this.players = players;
	    return this;
	}

	public Game build() {
	    var game = new Game();
	    game.gameBoard = this.gameBoard;
	    game.players = this.players;
	    game.playerIndex = 0;
	    return game;
	}
    }
    
    public void updatePlayer() {
	int index = this.playerIndex;
	this.playerIndex = index > (players.length -1) ? index + 1 : 0;
    }

    public void play() {
	var frame = new JFrame();
    }
    
    public String getCurrentPlayer() {
	return this.players[this.playerIndex];
    }

}
