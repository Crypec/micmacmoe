package micmacmoe;

import micmacmoe.util.PlayerType;

public class AIPlayer extends Player {

    public AIPlayer(String id) {
	super(id);
    }

    
    private void evaluate() {
	
    }

    public Point move(Board board) {
	return new Point(0, 0);
    }
}
