package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Ball extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image ballImage;
	private BufferedImage ballBuffImage;
	private final double ACCELERATION = 0.25f;
	private final double INNITIAL_VY = 2;
	private final double INNITIAL_VX = 4.5;
	private double velocityY;
	private double velocityX;
	
	public Ball(GamePanel panel) {
		super(10, 60, 30, 30, ObjectMode.BALL);
		this.panel = panel;
		this.velocityY = 2;
		this.velocityX = 4.5;
		
		try {
			ballBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/ball.png"));
			super.setBuffImage(ballBuffImage);
			this.ballImage = ballBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(ballBuffImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void action() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
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
		if ((positionX+velocityX > 1004) || (positionX+velocityX < 0)) {
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

	public GamePanel getPanel() {
		return panel;
	}

	public Image getBallImage() {
		return ballImage;
	}

	public BufferedImage getBallBuffImage() {
		return ballBuffImage;
	}

	public double getACCELERATION() {
		return ACCELERATION;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public double getVelocityX() {
		return velocityX;
	}
	
	public double getINNITIAL_VY() {
		return INNITIAL_VY;
	}

	public double getINNITIAL_VX() {
		return INNITIAL_VX;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setBallImage(Image ballImage) {
		this.ballImage = ballImage;
	}

	public void setBallBuffImage(BufferedImage ballBuffImage) {
		this.ballBuffImage = ballBuffImage;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

}
