package micmacmoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFrontend implements ActionListener {

    private Board gameBoard;
    private int playerIndex = 0;
    private String[] players;

    private int xSize;
    private int ySize;
    private JButton[][] buttons;

    public GUIFrontend(int xSize, int ySize, String[] players) {

	this.gameBoard = new Board(xSize, ySize);
	this.playerIndex = 0;
	this.players = players;

	this.xSize = xSize;
	this.ySize = ySize;

	this.buttons = new JButton[ySize][xSize];

	for (int i = 0; i < this.buttons.length; i++) {
	    for (int j = 0; j < this.buttons[i].length; j++) {
		this.buttons[i][j] = new JButton("Free");
		this.buttons[i][j].setBackground(Color.decode("#EBE6DB"));
		this.buttons[i][j].setForeground(Color.BLACK);
		this.buttons[i][j].addActionListener(this);
		this.buttons[i][j].setFocusPainted(false);
	    }
	}
    }

    private void updateCurrentPlayer() {
	int index = this.playerIndex;
	this.playerIndex = index == (players.length - 1) ? 0 : index + 1;
    }

    public String getCurrentPlayer() { return this.players[this.playerIndex]; }

    public void play() {

	var frame = new JFrame("MicMacMoe");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("MicMacMoe");
	frame.setSize(this.xSize * 200, this.ySize * 200);

	frame.getContentPane().setLayout(new GridLayout(this.xSize, this.ySize));

	for (var row : this.buttons) {
	    for (var button : row) {
		frame.add(button);
	    }
	}
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
    }

    public void advanceGame() {
	if (this.gameBoard.hasWinner()) {
	    JOptionPane.showMessageDialog(null,
					  String.format("Player %s has won the game!",
                                                  this.getCurrentPlayer()));
      System.exit(0);
    } else if (this.gameBoard.isFull()) {
      JOptionPane.showMessageDialog(null, "Both of you lost, board is full!");
      System.exit(0);
    } else {
      this.updateCurrentPlayer();
    }
  }

  // TODO: this is absolutely stupid to have and eventListener for this
  public void actionPerformed(ActionEvent ae) {
    int x = 0;
    int y = 0;
  global:
    for (y = 0; y < this.buttons.length; y++) {
      for (x = 0; x < this.buttons[y].length; x++) {
        if (ae.getSource() == this.buttons[y][x]) {
          break global;
        }
      }
    }
    // checks if setting the player was successfull
    if (this.gameBoard.setPlayer(x, y, this.getCurrentPlayer())) {
      Color buttonBGColor;
      if (this.playerIndex % 2 == 0) {
	  buttonBGColor = Color.decode("#0C243B");
      } else {
	  buttonBGColor = Color.decode("#C35D46");
      }
      this.buttons[y][x].setBackground(buttonBGColor);
      this.buttons[y][x].setText(this.getCurrentPlayer());
      this.buttons[y][x].setForeground(Color.WHITE);
      this.buttons[y][x].setFont(new Font("Arial", Font.PLAIN, 40));
      this.advanceGame();
    } else {
      return;
    }
  }
}
