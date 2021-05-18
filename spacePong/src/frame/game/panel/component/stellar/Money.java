package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Money extends GameObject {
	
	private GamePanel panel;
	private Image moneyImage;
	private BufferedImage moneyBuffImage;
	
	public Money(GamePanel panel) {
		super(340, 60, 70, 84, ObjectMode.MONEY);
		this.panel = panel;
		
		try {
			moneyBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/money.png"));
			super.setBuffImage(moneyBuffImage);
			this.moneyImage = moneyBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void action() {}
	
	public GamePanel getPanel() {
		return panel;
	}

	public Image getMoneyImage() {
		return moneyImage;
	}

	public BufferedImage getMoneyBuffImage() {
		return moneyBuffImage;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}

	public void setMoneyImage(Image moneyImage) {
		this.moneyImage = moneyImage;
	}

	public void setMoneyBuffImage(BufferedImage moneyBuffImage) {
		this.moneyBuffImage = moneyBuffImage;
	}
	
}
