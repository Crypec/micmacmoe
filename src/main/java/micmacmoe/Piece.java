package micmacmoe;

public class Piece {
    private boolean isFree;
    private Player owner;

    public Piece() {
	this.isFree = true;
	this.owner = null;
    }

    public boolean isFree() { return this.isFree; }

    public Player getPlayer() { return this.owner; }

    public boolean playerEquals(Player player) {
	if (!this.isFree) {
	    return this.owner.getID().equals(player.getID());
	} else
	    return false;
    }

    public String toString() { return isFree ? "Free" : this.owner.getID(); }

    public void display() { System.out.println(this.toString()); }

    public void setOwner(Player owner) {
	this.isFree = false;
	this.owner = owner;
    }
}
