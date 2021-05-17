package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameObject {
	private BufferedImage image;
	private Rectangle rectangle;
	private int positionX;
	private int positionY;
	private int width;
	private int height;
	
	public GameObject() {
		updateRectangle();
	}
	
	protected void updateRectangle() {
		rectangle = new Rectangle(positionX, positionY, width, height);
	}
	
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
	public BufferedImage getBuffImage() {
		return this.image;
	}
	
	public Image getImage() {
		Image normalImg = image.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		return normalImg;
	}
	
	public void setBuffImage(BufferedImage image) {
		this.image = image;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
