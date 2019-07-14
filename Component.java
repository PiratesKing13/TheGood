package pinBall;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class Component {
	private Color color , borderColor;
	
	private int x, y, width, height;
//	private Image image;
	public Component(int x , int y) {
		this.x = x;
		this.y = y;	
	}
	public int getX() {
		return x;
	}
	protected void setX(int x){
		this.x = x;
	}
	public int getY() {
		return y;
	}
	protected void setY(int y){
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int widht) {
		this.width = widht;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	};
	public Rectangle getBound(){
		return new Rectangle(x, y, width, height);
	}
}
