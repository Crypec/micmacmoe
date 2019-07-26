package micmacmoe;

import micmacmoe.util.GUIStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {

    private int xSize;
    private int ySize;
    private String[] players;
    private GUIStyle style;

    public static class Builder {

	private String[] players;
	private GUIStyle style;
	private int xSize;
	private int ySize;

	public Builder() {}

	public Builder size(int x, int y) {

	    this.xSize = x;
	    this.ySize = y;
	    return this;
	}

	public Builder style(GUIStyle style) {
	    this.style = style;
	    return this;
	}

	// @TODO check that there are no duplicate Players -> HashSet
	public Builder players(String... players) {
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
	var test = new GUIFrontend(this.xSize, this.ySize, this.players);
	test.play();
    }
}
