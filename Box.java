package pinBall;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Box extends Component {

	private int level = 1;
	private boolean visiblity;

	int hp;
	public Box(int x, int y) {
		super(x, y);
		visiblity = true;
		hp = 3;

	}

	public boolean isVisiblity() {
		return visiblity;
	}

	public void setVisiblity(boolean visiblity) {
		this.visiblity = visiblity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level >= 0) {

		}
	}

}
