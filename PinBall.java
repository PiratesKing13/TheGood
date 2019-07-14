package pinBall;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PinBall extends JFrame {
	private int width;
	private int height;

	public PinBall() {
		setTitle("Pin Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Board board = new Board(1200, 800);
		add(board);
		setResizable(false);
		pack();
	}

}
