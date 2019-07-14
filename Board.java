package pinBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener {
	static int width, height;
	// listeners should be here
	private Scroller scroller;
	private Ball ball;
	private ArrayList<Box> boxes;
	private Timer timer;
	private Box box;

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		iB();
	}

	private void iB() {

		setBackground(Color.white);
		setPreferredSize(new Dimension(width, height));
		addKeyListener(this);
		setFocusable(true);
		scroller = new Scroller(400, 700);
		ball = new Ball(475, 650);
		initBox();

		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ball.move();
				scroller.move();
				repaint();

				checkCollision();
			}

		});

		timer.start();

	}

	private void checkCollision() {
		for (Box b : boxes) {

			if (ball.getX() + ball.getWidth() >= b.getX() && ball.getX() <= b.getX() + b.getWidth()) {
				// System.out.println("firt");
				if (ball.getY() <= b.getY() + b.getHeight() && ball.getY() + ball.getHeight() >= b.getY()) {

					System.out.println("second");
					if (b.isVisiblity()) {

						if (ball.getX() + ball.getWidth() - ball.getDx() <= b.getX()
								|| ball.getX() - ball.getDx() >= b.getX() + b.getWidth()) {

							
							ball.setDx(-1 * ball.getDx());

						} else {

							
							ball.setDy(-1 * ball.getDy());

						}
						b.hp--;
						if (b.hp < 1) {
							b.setVisiblity(false);
						}

					}

				}
			}
		}

		if (ball.getY() + ball.getHeight() >= scroller.getY() && ball.getX() >= scroller.getX()
				&& ball.getX() + ball.getWidth() <= (scroller.getX() + scroller.getWidth())) {

			if (ball.getY() + ball.getHeight() <= scroller.getY() + scroller.getHeight()) {

				// double ballpos = ball.getX() - scroller.getX();
				// double newx = (ballpos / scroller.getWidth()) - .5;
				// ball.setDx((int) newx * 5);
				// ball.setDy((int) -1 * ball.getDy());
				ball.setDy(-1 * ball.getDy());
			}
		}

	}

	@Override
	protected void paintComponent(Graphics p) {
		super.paintComponent(p);

		for (int i = 0; i < boxes.size(); i++) {
			Box b = boxes.get(i);

			if (b.isVisiblity()) {
				switch (b.hp) {
				case 3:
					p.setColor(Color.red);
					break;
				case 2:
					p.setColor(Color.blue);
					break;
				case 1:
					p.setColor(Color.black);
					break;
				}

				p.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
			}
		}
		p.fillRect(scroller.getX(), scroller.getY(), scroller.getWidth(), scroller.getHeight());

		p.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
	}

	private void initBox() {
		// why we add this?
		boxes = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				Box b = new Box(j * (width / 15), i * (50));
				b.setWidth((width / 15) - 2);
				b.setHeight(49);
				boxes.add(b);

			}
		}

	}

	@Override
	public void keyPressed(KeyEvent k) {
		int code = k.getKeyCode();

		switch (code) {

		case KeyEvent.VK_LEFT:
			scroller.left();
			ball.left();
			break;
		case KeyEvent.VK_RIGHT:
			scroller.right();
			ball.right();
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent k) {
		int code = k.getKeyCode();

		switch (code) {
		case KeyEvent.VK_LEFT:
			scroller.leftRelease();
			ball.leftRelease();
			break;
		case KeyEvent.VK_RIGHT:
			scroller.rightRelease();
			ball.rightRelease();
			break;
		case KeyEvent.VK_SPACE:
			if (ball.isOnScroller) {
				ball.isOnScroller = false;
				ball.start();
			}
		}

		switch (code) {
		case KeyEvent.VK_LEFT:
			scroller.leftRelease();
			break;
		case KeyEvent.VK_RIGHT:
			scroller.rightRelease();
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	private boolean isIntersect(Rectangle r1, Rectangle r2) {
		if (r1.getY() + r1.getHeight() < r2.getY() || r2.getY() + r2.getHeight() < r1.getY()) {
			return false;
		} else if (r1.getX() + r1.getWidth() < r2.getX() || r2.getX() + r2.getWidth() < r1.getX()) {
			return false;
		} else {
			return true;
		}

	}

}
