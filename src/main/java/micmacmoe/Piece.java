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
	    return this.owner.getName().equals(player.getName());
	} else {
	    return false;
	}
    }

    public String toString() {
	if (this.isFree && this.owner == null) {
	    return "Free";
	} else {
	    return this.owner.getName();
	}
    }

    public void display() { System.out.println(this.toString()); }

    public void setOwner(Player owner) {
	this.isFree = false;
	this.owner = owner;
    }
}
