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
	
	private GamePanel panel;
	private Image meteorImage;
	private BufferedImage meteorBuffImage;
	private Timer timer;
	
	public Meteor(GamePanel panel) {
		super(340, 60, 80, 80, ObjectMode.METEOR);
		this.panel = panel;
		
		try {
			meteorBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/lava.png"));
			super.setBuffImage(meteorBuffImage);
			this.meteorImage = meteorBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			timer = new Timer(20, this);
		}
	}
	
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
		;
	}
	
	public void startAction() {
		timer.start();
	}
	
	public void stopAction() {
		timer.stop();
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
