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

public class Star extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image starImage;
	private BufferedImage starBuffImage;
	private double velocityY;
	
	public Star(GamePanel panel) {
		super(25, 30, 85, 81, ObjectMode.STAR);
		this.panel = panel;
		this.velocityY = 2;
		
		try {
			starBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/star.png"));
			super.setBuffImage(starBuffImage);
			this.starImage = starBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(starBuffImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void action() {
		int oldScore = Integer.parseInt(panel.getTopPanel()
											 .getScorePanel()
											 .getScore());
		
		String newScore = (oldScore + 10) + "";
		
		panel.getTopPanel()
			 .getScorePanel()
			 .setScore(newScore);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
	}
	
	private void move() {
		if (moveController()) {
			super.positionY += velocityY;
		} else {
			super.timer.stop();
		}
	}
	
	private boolean moveController() {
		if ((getPositionY() + velocityY) < panel.getHeight()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOutOfFrame() {
		return (super.positionY > panel.getHeight()) ? true: false;
	}
	
	public GamePanel getPanel() {
		return panel;
	}

	public Image getStarImage() {
		return starImage;
	}

	public BufferedImage getStarBuffImage() {
		return starBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setStarImage(Image starImage) {
		this.starImage = starImage;
	}

	public void setStarBuffImage(BufferedImage starBuffImage) {
		this.starBuffImage = starBuffImage;
	}
	
}
