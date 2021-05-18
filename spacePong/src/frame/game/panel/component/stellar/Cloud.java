package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Cloud extends GameObject {
	
	private GamePanel panel;
	private Image cloudImage;
	private BufferedImage cloudBuffImage;
	
	public Cloud(GamePanel panel) {
		super(0, 0, 120, 66, ObjectMode.CLOUD);
		this.panel = panel;
		
		try {
			cloudBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/cloud.png"));
			super.setBuffImage(cloudBuffImage);
			this.cloudImage = cloudBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void action() {}
	
	public GamePanel getPanel() {
		return panel;
	}

	public Image getCloudImage() {
		return cloudImage;
	}

	public BufferedImage getCloudBuffImage() {
		return cloudBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setCloudImage(Image cloudImage) {
		this.cloudImage = cloudImage;
	}

	public void setCloudBuffImage(BufferedImage cloudBuffImage) {
		this.cloudBuffImage = cloudBuffImage;
	}
	
}
