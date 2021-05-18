package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	
	protected BufferedImage image;
	protected Rectangle rectangle;
	protected ObjectMode objectMode;
	protected int positionX;
	protected int positionY;
	protected int width;
	protected int height;
	
	public GameObject(int positionX, int positionY, 
			int width, int height, ObjectMode objectMode) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
		this.objectMode = objectMode;
		
		updateRectangle();
	}
	
	public abstract void action();
	
	protected void updateRectangle() {
		rectangle = new Rectangle(positionX, positionY, width, height);
	}
	
	public Image getImage() {
		Image normalImg = image.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		return normalImg;
	}
	
	public BufferedImage getBuffImage() {
		return image;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public ObjectMode getObjectMode() {
		return objectMode;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setBuffImage(BufferedImage image) {
		this.image = image;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public void setObjectMode(ObjectMode objectMode) {
		this.objectMode = objectMode;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
