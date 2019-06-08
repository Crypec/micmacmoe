package micmacmoe;


public class Board {

    private Piece[][] gameBoard;
    
    public Board(int xSize, int ySize) {
	this.gameBoard = new Piece[xSize][ySize];
	for (int i = 0; i < this.gameBoard.length; i++) {
	    for (int j = 0; j < this.gameBoard[i].length; j++) {
		this.gameBoard[i][j] = new Piece();
	    }
	}
    }

    // return better error value for performance and ergonomics
    public void setPlayer(int x, int y, String playerID) throws IllegalAccessException {
	System.out.printf("x :: %d, y :: %d len :: %d len %d %n", x, y, this.gameBoard.length, this.gameBoard[0].length); // debug statement
	if (!this.gameBoard[x][y].isFree()) {
	    // @TODO could report if player has already set on this piece -> report owner of piece 
	    throw new IllegalAccessException("DEBUG ERR :: Field is not Free!");
	} else if (x > this.gameBoard.length || y > this.gameBoard[y].length) {
	    throw new IllegalAccessException("DEBUG ERR :: // Field outside of board!");
	}
	this.gameBoard[x-1][y-1].setPlayer(playerID);
    }

    /* 
       With cords: (x,y)

       x -Axis ---> 
      +-----------------+ 
      |(0,0)|(0,1)|(0,2)| |
      +-----------------+ | y-Axis
      |(1,0)|(1,1)|(1,2)| |
      +-----------------+ v
      |(2,0)|(2,1)|(2,2)| 
      +-----------------+ 
      
      Implementation: 
      downRight: checks the diagonal rows exmp :: (0,0) (1,1) (2, 2)
      downLeft: checks the diagonal rows exmp :: (0,2) (1,1) (2, 0)
      rowID: checks each row exmp :: (0,0) (0,1) (0,2)
      colID: checks the colums exmp :: (2,0) (2,1) (2,2)

      @TODO:
      could return an Option to a potential Winner 
      @WARN:
      should check the whole board all the times because this is nesecarry for AI player
    */
    public boolean hasWinner() {

	boolean hasWinner = false;
	for (int i = 0; i < this.gameBoard.length; i++) {
	    hasWinner |= this.checkRow(i);
	}
	for (int i = 0; i < this.gameBoard[0].length; i++) {
	    hasWinner |= this.checkCol(i);
	}
	// it makes only sense to check the diagonals only if gameBoard is a square 
	if (this.gameBoard.length == this.gameBoard[0].length) { 
	    hasWinner |= this.diagonalRight() || this.diagonalLeft();
	}
	return hasWinner;
    }

    private boolean checkRow(int row) {
	String first = this.gameBoard[row][0].getPlayerID();
	for (var elem : this.gameBoard[row]) {
	    if (!elem.getPlayerID().equals(first)) {
		return false;
	    }
	}
	return true;
    }
    

    private boolean checkCol(int col) {
	String first = this.gameBoard[0][col].getPlayerID();
	for (int i = 0; i < this.gameBoard.length; i++) {
	    if (!this.gameBoard[i][col].getPlayerID().equals(first)) {
		return  false;
	    }
	}
	return true; 
    }

    private boolean diagonalRight() {
	String first = this.gameBoard[0][0].getPlayerID();
	for (int i = 0; i < this.gameBoard.length; i++) {
	    if (!this.gameBoard[i][this.gameBoard.length - (i-1)].getPlayerID().equals(first)) {
		return false;
	    }
	}
	return true;
    }

    private boolean diagonalLeft() {
	String first = this.gameBoard[0][this.gameBoard.length -1].getPlayerID();
	for (int i = 0; i < this.gameBoard.length; i++) {
	    if  (!first.equals(this.gameBoard[i][i].getPlayerID())) {
		return false;
	    }
	}
	return true;
    }

    // @TODO replace with fancy iterator?
    public boolean isFull() {
	for (var row : this.gameBoard) {
	    for (var cell : row) {
		if (cell.isFree()) {
		    return false;
		}
	    }
	}
	return true;
    }

    public Piece[][] getBoard() {
	return this.gameBoard;
    }
}
