package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Planet extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image planetImage;
	private BufferedImage planetBuffImage;
	
	public Planet(GamePanel panel) {
		super(340, 60, 89, 50, ObjectMode.PLANET);
		this.panel = panel;
		
		try {
			planetBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/planet.png"));
			super.setBuffImage(planetBuffImage);
			this.planetImage = planetBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
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

	public Image getPlanetImage() {
		return planetImage;
	}

	public BufferedImage getPlanetBuffImage() {
		return planetBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setPlanetImage(Image planetImage) {
		this.planetImage = planetImage;
	}

	public void setPlanetBuffImage(BufferedImage planetBuffImage) {
		this.planetBuffImage = planetBuffImage;
	}
	
}
