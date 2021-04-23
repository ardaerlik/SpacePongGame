package frame.game.panel;

import javax.swing.JPanel;

import frame.game.panel.component.*;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BelowPanel extends JPanel {
	
	private PauseButton pauseButton;
	
	public BelowPanel() {
		layoutManager();
	}
	
	private void layoutManager() {
		pauseButton = new PauseButton();
		add(pauseButton);
	}

}
