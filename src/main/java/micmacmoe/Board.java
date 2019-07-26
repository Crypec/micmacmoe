package micmacmoe;

import java.util.Arrays;

public class Board {

  private Piece[][] gameBoard;

  public Board(int xSize, int ySize) {
    this.gameBoard = new Piece[ySize][xSize];

    for (int i = 0; i < this.gameBoard.length; i++) {
      for (int j = 0; j < this.gameBoard[i].length; j++) {
        this.gameBoard[i][j] = new Piece();
      }
    }
  }

  public Board(Board board) {
    this.gameBoard = board.getBoard();
  }

  // TODO return better error value for performance and ergonomics
  // TODO: maybe a boolean if setting the player was possible and valid
  public boolean setPlayer(int x, int y, String playerID) {
    if (y > this.gameBoard.length || x > this.gameBoard[0].length) {
      return false;
    }
    if (!this.gameBoard[y][x].isFree()) {
      return false;
    } else {
      this.gameBoard[y][x].setPlayer(playerID);
      return true;
    }
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
    should check the whole board all the times because this is nesecarry for AI
    player
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
      hasWinner |= this.diagonalLeftToRightDown() || this.diagonalLeftToRightUp();
    }
    return hasWinner;
  }
  // TODO: the code is horrible, i know and i am also not in the mood to fix it
  // right now
  public boolean[][] getWinnerCells() {

    int xSize = this.gameBoard.length;
    int ySize = this.gameBoard[0].length;

    boolean[][] winnerCells = new boolean[ySize][xSize];
    for (boolean[] row : winnerCells) {
      Arrays.fill(row, false);
    }

    for (int i = 0; i < this.gameBoard.length; i++) {
      if (this.checkRow(i)) {
        for (int c = 0; c < xSize; c++) {
          winnerCells[i][c] = true;
        }
      }
    }

    for (int i = 0; i < this.gameBoard[0].length; i++) {}
    // it makes only sense to check the diagonals only if gameBoard is a square
    if (this.gameBoard.length == this.gameBoard[0].length) {
      boolean hasWinner = this.diagonalLeftToRightDown() || this.diagonalLeftToRightUp();
    }
    return winnerCells;
  }

  private boolean checkRow(int row) {
    String first = this.gameBoard[row][0].getPlayerID();
    for (var elem : this.gameBoard[row]) {
      if (!elem.playerEquals(first)) {
        return false;
      }
    }
    return true;
  }

  private boolean checkCol(int col) {
    String first = this.gameBoard[0][col].getPlayerID();
    for (int i = 0; i < this.gameBoard.length; i++) {
      if (!this.gameBoard[i][col].playerEquals(first)) {
        return false;
      }
    }
    return true;
  }

  private boolean diagonalLeftToRightDown() {
    String first = this.gameBoard[0][0].getPlayerID();
    for (int i = 0; i < this.gameBoard.length; i++) {
      if (!this.gameBoard[i][i].playerEquals(first)) {
        return false;
      }
    }
    return true;
  }

  private boolean diagonalLeftToRightUp() {
    String first = this.gameBoard[this.gameBoard.length - 1][0].getPlayerID();
    int x = 0;
    int y = this.gameBoard.length - 1;

    for (int i = 0; i < this.gameBoard.length; i++) {
      if (!this.gameBoard[y][x].playerEquals(first)) {
        return false;
      }
      x++;
      y--;
    }
    return true;
  }

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

  public void display() {

    var board = Arrays.asList();

    board.forEach(System.out::println);

    for (var row : this.gameBoard) {
      for (var piece : row) {
        piece.display();
      }
      System.out.println();
    }
  }

  public Piece[][] getBoard() {
    return this.gameBoard;
  }

  public int getSize() {
    return this.gameBoard.length * this.gameBoard[0].length;
  }

  public int getYSize() {
    return this.gameBoard.length;
  }

  public int getXSize() {
    return this.gameBoard[0].length;
  }
}
