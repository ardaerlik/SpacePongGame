package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Poison extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image poisonImage;
	private BufferedImage poisonBuffImage;
	
	public Poison(GamePanel panel) {
		super(545, 21, 45, 90, ObjectMode.POISON);
		this.panel = panel;
		
		try {
			poisonBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/poison.png"));
			super.setBuffImage(poisonBuffImage);
			this.poisonImage = poisonBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(poisonBuffImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void action() {
		panel.freezePaddle();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public GamePanel getPanel() {
		return panel;
	}

	public Image getPoisonImage() {
		return poisonImage;
	}

	public BufferedImage getPoisonBuffImage() {
		return poisonBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setPoisonImage(Image poisonImage) {
		this.poisonImage = poisonImage;
	}

	public void setPoisonBuffImage(BufferedImage poisonBuffImage) {
		this.poisonBuffImage = poisonBuffImage;
	}
	
}
