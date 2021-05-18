package frame.game.panel.component.stellar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import frame.game.panel.GamePanel;

public class Ufo extends GameObject 
	implements ActionListener {
	
	private GamePanel panel;
	private Image ufoImage;
	private BufferedImage ufoBuffImage;
	private final double scaleFactor = 1.1;
	private final int minWidth = 90;
	private final int minHeight = 67;
	private final int maxWidth = 145;
	private final int maxHeight = 101;
	private boolean scalingUp = true;
	
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
		scaleControl();
		scale();
	}
	
	private void scaleControl() {
		if (scalingUp) {
			if ((getWidth()*scaleFactor) > maxWidth) {
				scalingUp = false;
			} else {
				setWidth((int) (getWidth()*scaleFactor));
				setHeight((int) (getHeight()*scaleFactor));
			}
		} else {
			if ((getWidth()/scaleFactor) < minWidth) {
				scalingUp = true;
			} else {
				setWidth((int) (getWidth()/scaleFactor));
				setHeight((int) (getHeight()/scaleFactor));
			}
		}
	}
	
	private void scale() {
		updateRectangle();
		setImage(buffImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
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

	public double getScaleFactor() {
		return scaleFactor;
	}

	public int getMinWidth() {
		return minWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public boolean isScalingUp() {
		return scalingUp;
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

	public void setScalingUp(boolean scalingUp) {
		this.scalingUp = scalingUp;
	}

}
