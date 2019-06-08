package micmacmoe;

import javax.swing.*;

public class Piece extends JButton {
    private boolean isFree;
    private String playerID;

    public Piece() {
	    this.isFree = true;
	    this.playerID = "";
    }

    public boolean isFree() {
	return this.isFree; 
    }

    public String getPlayerID() {
	    if (this.isFree()) {
	        return " ";
	    }
	    return this.playerID;
    }
    public void setPlayer(String playerID) {
	    this.isFree = false;
	    this.playerID = playerID;
    }
}
