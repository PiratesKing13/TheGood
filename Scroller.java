package pinBall;

public class Scroller extends Component implements Movable {

	int dx = 0;

	public Scroller(int x, int y) {
		super(x, y);
		setWidth(200);
		setHeight(30);
	}

	public void left() {

		dx = -6;
	}

	public void right() {
		dx = +6;
	}

	public void rightRelease() {
		dx = 0;
	}

	public void leftRelease() {
		dx = 0;
	}

	@Override
	public void move() {
		if (getX() + dx + 200 > Board.width || getX() + dx <= 0) {

		} else {
			setX(getX() + dx);
		}
	}
}
