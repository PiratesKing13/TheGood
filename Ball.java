package pinBall;

public class Ball extends Component implements Movable {

	public Ball(int x, int y) {
		super(x, y);
		setWidth(50);
		setHeight(50);

	}

	public int dx = 0;
	public int dy = 0;
	private int speed = 4;
	
	protected boolean isOnScroller = true;

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;

	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void left() {
		if (isOnScroller) {
			dx = -4;
		}
		
	}

	public void right() {
		if (isOnScroller) {
			dx = 4;
		}
		
	}

	public void rightRelease() {
		if (isOnScroller) {
			dx = 0;
		}	}

	public void leftRelease() {
		if (isOnScroller) {
			dx = 0;
		}
	}

	@Override
	public void move() {
		if(getX()>Board.width-50|| getX()<0){
			dx = -dx;
			
		}
		if(getY()>Board.height-50||getY()<0)	{
			dy =-dy;
		}
		
		setX(getX() +dx);
		setY(getY() +dy);
		
	}
	
	

	public void start() {
		// when we press space
		dx = speed;
		dy = -speed;
	}

	

}
