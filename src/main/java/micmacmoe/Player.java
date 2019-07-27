package micmacmoe;

public abstract class Player {

    public Player(String id) {
	this.id = id;
    }

    protected String getID() {
	return this.id;
    }


    protected String id;
    public abstract Point move(Board board);
}
