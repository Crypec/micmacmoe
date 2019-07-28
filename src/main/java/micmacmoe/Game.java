package micmacmoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import micmacmoe.util.GUIStyle;

public class Game {

    private int xSize;
    private int ySize;
    private Player[] players;
    private GUIStyle style;

    public static class Builder {

	private Player[] players;
	private GUIStyle style;
	private int xSize;
	private int ySize;

	public Builder() {}

	public Builder size(int x, int y) {
	    this.xSize = x;
	    this.ySize = y;
	    return this;
	}

	public Builder withGUI(GUIStyle style) {
	    this.style = style;
	    return this;
	}

	// @TODO check that there are no duplicate Players -> HashSet
	public Builder players(Player... players) {
	    this.players = players;
	    return this;
	}

	public Game build() {
	    var game = new Game();
	    game.style = this.style;
	    game.players = this.players;
	    game.xSize = this.xSize;
	    game.ySize = this.ySize;
	    return game;
	}
    }

    // TODO: switch depending on GUIStyle
    public void play() {
	Frontend gameUI = switch (this.style) {
	    case CONSOLE -> new CLIFrontend(this.xSize, this.ySize, this.players);
	    case GRAPHIC -> new GUIFrontend(this.xSize, this.ySize, this.players);
	};
	gameUI.play();
    }
}
