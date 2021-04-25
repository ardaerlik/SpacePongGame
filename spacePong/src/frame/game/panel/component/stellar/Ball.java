package frame.game.panel.component.stellar;

import java.awt.Image;
import javax.swing.ImageIcon;

import frame.game.panel.GamePanel;

public class Ball extends StellarObject {
	
	private GamePanel panel;
	private ImageIcon ballIMG;
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	private final double ACCELERATION = 0.25f;
	private double velocityY;
	private double velocityX;
	private int positionY;
	private int positionX;
	
	public Ball(GamePanel panel) {
		ballIMG = new ImageIcon("spacePong/assets/images/gameObjects/ball.png");
		
		this.panel = panel;
		this.positionX = 10;
		this.positionY = 60;
		this.velocityY = 2;
		this.velocityX = 4.5;
	}
	
	public void move() {
		moveController();
		positionX += velocityX;
		positionY += velocityY;
		velocityY += ACCELERATION;
		System.out.printf("%s %s%n", velocityX, velocityY);
	}
	
	private void moveController() {
		if ((positionX+velocityX > 1024) || (positionX+velocityX < 0)) {
			velocityX = -velocityX;
		}
		if (positionY+velocityY > 478) {
			positionY = 478 + (int) velocityY;
			velocityY = -velocityY;
		}
		if (positionY+velocityY < 0) {
			positionY = 0 - (int) velocityY;
			velocityY = -velocityY;
		}
	}
	
	private void resetBall() {
		this.positionX = 10;
		this.positionY = 60;
		this.velocityY = 2;
		this.velocityX = 4.5;
	}
	
	public Image getImage() {
		return this.ballIMG.getImage();
	}
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
	public double getVelocityY() {
		return this.velocityY;
	}
	
	public double getVelocityX() {
		return this.velocityX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

}
