package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Star extends GameObject {
	
	private GamePanel panel;
	private Image starImage;
	private BufferedImage starBuffImage;
	
	public Star(GamePanel panel) {
		super(0, 0, 85, 81, ObjectMode.STAR);
		this.panel = panel;
		
		try {
			starBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/star.png"));
			super.setBuffImage(starBuffImage);
			this.starImage = starBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
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