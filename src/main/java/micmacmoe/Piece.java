package micmacmoe;

public class Piece {

    private boolean isFree;
    private String playerID;

    public Piece() {
	this.isFree = true;
	this.playerID = "";
    }

    public void display() {
	if (this.isFree) {
	    System.out.print("free ");
	} else {
	    System.out.print(this.playerID);
	}
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

    public boolean playerEquals(String player) {
	return !this.isFree && this.playerID.equals(player);
    }

    public void setPlayer(String playerID) {
	this.isFree = false;
	this.playerID = playerID;
    }
}
