package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Ball extends GameObject {
	
	private GamePanel panel;
	private Image ballImage;
	private BufferedImage ballBuffImage;
	private final double ACCELERATION = 0.25f;
	private double velocityY;
	private double velocityX;
	
	public Ball(GamePanel panel) {
		super(10, 60, 30, 30);
		this.panel = panel;

		this.velocityY = 2;
		this.velocityX = 4.5;
		
		try {
			ballBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/ball.png"));
			super.setBuffImage(ballBuffImage);
			this.ballImage = ballBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move() {
		moveController();
		positionX += velocityX;
		positionY += velocityY;
		velocityY += ACCELERATION;
		
		super.setPositionX(positionX);
		super.setPositionY(positionY);
		super.updateRectangle();
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
		
		paddleForce();
	}
	
	private void paddleForce() {
		if (GameObjectHelper.paddleIntersects(panel.getPaddle(), this)) {
			int paddlePositionX = panel.getPaddlePosition()[0];
			
			velocityY = -velocityY+1;
			velocityX += (positionX + width/2 - (paddlePositionX + panel.getPaddle().width/2))/10;
		}
	}
	
	public void resetBall() {
		this.positionX = 10;
		this.positionY = 60;
		this.velocityY = 2;
		this.velocityX = 4.5;
	}
	
	public Image getImage() {
		return this.ballImage;
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
