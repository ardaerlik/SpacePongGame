package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.game.panel.GamePanel;

public class Meteor extends GameObject {
	
	private GamePanel panel;
	private Image meteorImage;
	private BufferedImage meteorBuffImage;
	private final int WIDTH = 80;
	private final int HEIGHT = 80;
	private int positionY;
	private int positionX;
	
	public Meteor(GamePanel panel) {
		this.panel = panel;
		this.positionX = 340;
		this.positionY = 60;
		
		try {
			meteorBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/lava.png"));
			super.setBuffImage(meteorBuffImage);
			this.meteorImage = meteorBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		super.setPositionX(positionX);
		super.setPositionY(positionY);
		super.setHeight(HEIGHT);
		super.setWidth(WIDTH);
		
		super.updateRectangle();
	}
	
	public void randomLocation() {
		
	}

	public GamePanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public Image getMeteorImage() {
		return meteorImage;
	}

	public void setMeteorImage(Image meteorImage) {
		this.meteorImage = meteorImage;
	}

	public BufferedImage getMeteorBuffImage() {
		return meteorBuffImage;
	}

	public void setMeteorBuffImage(BufferedImage meteorBuffImage) {
		this.meteorBuffImage = meteorBuffImage;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	
}
