package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import frame.game.panel.GamePanel;

public class Meteor extends GameObject 
	implements ActionListener {
	
	private enum Way {HORIZONTAL, VERTICAL};
	private GamePanel panel;
	private Image meteorImage;
	private BufferedImage meteorBuffImage;
	private Way way;
	private double velocityY;
	private double velocityX;
	private boolean isNewWay;
	
	public Meteor(GamePanel panel) {
		super(340, 60, 80, 80, ObjectMode.METEOR);
		this.panel = panel;
		this.velocityY = 3;
		this.velocityX = 3;
		this.isNewWay = true;
		
		try {
			meteorBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/lava.png"));
			super.setBuffImage(meteorBuffImage);
			this.meteorImage = meteorBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(meteorBuffImage);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void action() {
		double oldVelocityX = panel.getBall()
								   .getVelocityX();
		
		double oldVelocityY = panel.getBall()
								   .getVelocityY();
		
		panel.getBall()
			 .setVelocityX(oldVelocityX*1.2);
		
		panel.getBall()
		     .setVelocityY(oldVelocityY*1.2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
	}
	
	private void move() {
		if (isNewWay) {
			way = ((int)(Math.random()*2) == 0)? Way.HORIZONTAL: Way.VERTICAL;
			isNewWay = false;
			
			switch (way) {
				case HORIZONTAL:
					super.positionX += this.velocityX;
					break;
				case VERTICAL:
					super.positionY += this.velocityY;
					break;
			}
		} else {
			isNewWay = true;
			
			switch (way) {
				case HORIZONTAL:
					super.positionX -= this.velocityX;
					break;
				case VERTICAL:
					super.positionY -= this.velocityY;
					break;
			}
		}
	}

	public GamePanel getPanel() {
		return panel;
	}

	public Image getMeteorImage() {
		return meteorImage;
	}

	public BufferedImage getMeteorBuffImage() {
		return meteorBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setMeteorImage(Image meteorImage) {
		this.meteorImage = meteorImage;
	}

	public void setMeteorBuffImage(BufferedImage meteorBuffImage) {
		this.meteorBuffImage = meteorBuffImage;
	}
	
}
