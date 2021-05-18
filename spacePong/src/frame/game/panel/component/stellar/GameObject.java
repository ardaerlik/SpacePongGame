package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

public abstract class GameObject 
	implements ActionListener {
	
	protected BufferedImage buffImage;
	protected Image image;
	protected Rectangle rectangle;
	protected ObjectMode objectMode;
	protected Timer timer;
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
				
		timer = new Timer(20, this);

		updateRectangle();
	}
	
	public abstract void action();
	
	public void startAction() {
		timer.start();
	}
	
	public void stopAction() {
		timer.stop();
	}
	
	protected void updateRectangle() {
		rectangle = new Rectangle(positionX, positionY, width, height);
	}
	
	public Image getImage() {
		return image;
	}
	
	public BufferedImage getBuffImage() {
		return buffImage;
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
	
	protected Timer getTimer() {
		return timer;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public void setBuffImage(BufferedImage buffImage) {
		this.buffImage = buffImage;
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

	protected void setTimer(Timer timer) {
		this.timer = timer;
	}
	
}
