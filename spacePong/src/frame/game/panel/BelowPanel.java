package frame.game.panel;

import frame.game.panel.component.button.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BelowPanel extends JPanel {
	
	private PauseButton pauseButton;
	private HelpButton helpButton;
	private ExitButton exitButton;
	private JFrame frame;
	
	public BelowPanel(JFrame frame) {
		this.frame = frame;

		layoutManager();
	}
	
	private void layoutManager() {
		pauseButton = new PauseButton(frame);
		helpButton = new HelpButton(frame);
		exitButton = new ExitButton(frame);
		
		setLayout(null);
		
		add(pauseButton);
		add(helpButton);
		add(exitButton);
	}
	
}
