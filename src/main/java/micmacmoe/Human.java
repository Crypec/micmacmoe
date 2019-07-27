package micmacmoe;

public class Human extends Player {

    private int preferredX;
    private int preferredY;
    
    public Human(String id) {
	super(id);
    }

    public void setPreferred(int x, int y) {
	this.preferredX = x;
	this.preferredY = y;
    }
    
    
    public Point move(Board board) {
	return new Point(this.preferredX, this.preferredY);
    }
}
