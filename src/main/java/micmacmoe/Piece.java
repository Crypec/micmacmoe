package micmacmoe;

public class Piece {
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
	return this.playerID;
    }

    public boolean playerEquals(String player) {
	if (!this.isFree) {
	    return this.playerID.equals(player);
	} else return false;
    }

    public String toString() {
	return isFree ? "Free" : this.playerID;
    }

    public void display() {
	System.out.println(this.toString());

    }

    public void setPlayer(String playerID) {
	this.isFree = false;
	this.playerID = playerID;
    }
}
