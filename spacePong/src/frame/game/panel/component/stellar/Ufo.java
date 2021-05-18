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
	
	private int[][] differentScales = 
		{{15, 11}, {30, 22}, {45, 33}, 
		 {60, 44}, {75, 55}, {90, 66},
		 {105, 77}, {120, 88}, {135, 99}};
	
	private GamePanel panel;
	private Image ufoImage;
	private BufferedImage ufoBuffImage;
	private final int minWidth = 15;
	private final int minHeight = 11;
	private final int maxWidth = 135;
	private final int maxHeight = 99;
	private boolean scalingUp = true;
	private int combination = 0;
	
	public Ufo(GamePanel panel) {
		super(0, 0, 90, 66, ObjectMode.UFO);
		this.panel = panel;
		
		super.setTimer(new Timer(40, this));
		
		try {
			ufoBuffImage = ImageIO.read(new File("spacePong/assets/images/gameObjects/ufo.png"));
			super.setBuffImage(ufoBuffImage);
			this.ufoImage = ufoBuffImage.getScaledInstance(-1, -1, Image.SCALE_SMOOTH);
			super.setImage(ufoImage);
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
			if (combination < differentScales.length-1) {
				super.setHeight(differentScales[combination][1]);
				super.setWidth(differentScales[combination][0]);
				combination++;
			} else {
				scalingUp = false;
			}
		} else {
			if (combination > 0) {
				super.setHeight(differentScales[combination][1]);
				super.setWidth(differentScales[combination][0]);
				combination--;
			} else {
				scalingUp = true;
			}
		}
	}
	
	private void scale() {
		updateRectangle();
		setImage(buffImage.getScaledInstance(getWidth(), 
				getHeight(), Image.SCALE_SMOOTH));
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
