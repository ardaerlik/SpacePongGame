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

public class Ufo extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image ufoImage;
	private BufferedImage ufoBuffImage;
	
	public Ufo(GamePanel panel) {
		super(0, 0, 90, 67, ObjectMode.UFO);
		this.panel = panel;
		
		try {
			ufoBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/ufo.png"));
			super.setBuffImage(ufoBuffImage);
			this.ufoImage = ufoBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void action() {
		int oldLiveCount = panel.getTopPanel()
								.getScorePanel()
								.getLiveCount();
		
		panel.getTopPanel()
			 .getScorePanel()
			 .setLiveCount(oldLiveCount-1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		;
	}

	public GamePanel getPanel() {
		return panel;
	}

	public Image getUfoImage() {
		return ufoImage;
	}

	public BufferedImage getUfoBuffImage() {
		return ufoBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setUfoImage(Image ufoImage) {
		this.ufoImage = ufoImage;
	}

	public void setUfoBuffImage(BufferedImage ufoBuffImage) {
		this.ufoBuffImage = ufoBuffImage;
	}

}
