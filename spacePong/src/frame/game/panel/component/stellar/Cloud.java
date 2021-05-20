package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Cloud extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image cloudImage;
	private BufferedImage cloudBuffImage;
	
	public Cloud(GamePanel panel) {
		super(0, 0, 60, 33, ObjectMode.CLOUD);
		this.panel = panel;
		
		try {
			cloudBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/cloud.png"));
			super.setBuffImage(cloudBuffImage);
			this.cloudImage = cloudBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(cloudBuffImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void action() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
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
