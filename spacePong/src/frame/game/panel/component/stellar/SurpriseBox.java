package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class SurpriseBox extends GameObject {
	
	private GamePanel panel;
	private Image surpriseImage;
	private BufferedImage surpriseBuffImage;
	
	public SurpriseBox(GamePanel panel) {
		super(0, 0, 80, 85, ObjectMode.SURPRISEBOX);
		this.panel = panel;
		
		try {
			surpriseBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/surprise.png"));
			super.setBuffImage(surpriseBuffImage);
			this.surpriseImage = surpriseBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public GamePanel getPanel() {
		return panel;
	}

	public Image getSurpriseImage() {
		return surpriseImage;
	}

	public BufferedImage getSurpriseBuffImage() {
		return surpriseBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setSurpriseImage(Image surpriseImage) {
		this.surpriseImage = surpriseImage;
	}

	public void setSurpriseBuffImage(BufferedImage surpriseBuffImage) {
		this.surpriseBuffImage = surpriseBuffImage;
	}
	
}