package micmacmoe;

public abstract class Player {

    protected String name;

    public Player(String name) {
	this.name = name;
    }

    protected String getName() {
	return this.name;
    }

    public abstract Point move(Board board);
}
