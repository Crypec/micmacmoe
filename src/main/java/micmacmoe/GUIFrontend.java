package micmacmoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFrontend extends Frontend implements ActionListener {

    private JButton[][] buttons;

    public GUIFrontend(int xSize, int ySize, String[] players) {
	
	super(xSize, ySize, players);

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

    public Point advanceGame() {

	

	if (this.gameBoard.hasWinner()) {
	    JOptionPane.showMessageDialog(
					  null, String.format("Player %s has won the game!", this.getCurrentPlayer()));
	    System.exit(0);
	} else if (this.gameBoard.isFull()) {
	    JOptionPane.showMessageDialog(null, "Both of you lost, board is full!");
	    System.exit(0);
	} else {
	    this.updateCurrentPlayer();
	}
	return new Point(0, 0);
    }

    public Point nextMove(int x, int y) {
	return new Point(x, y);
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
	
	Point p = this.nextMove(x, y);

	if (this.gameBoard.setPlayer(p.x, p.y, this.getCurrentPlayer())) {
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
	} 
    }
}
