package frame.game.panel;

import frame.game.GameFrame;
import frame.game.panel.component.button.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BelowPanel extends JPanel {
	
	private PauseButton pauseButton;
	private HelpButton helpButton;
	private ExitButton exitButton;
	private GameFrame frame;
	
	public BelowPanel(GameFrame frame) {
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

	public PauseButton getPauseButton() {
		return pauseButton;
	}

	public HelpButton getHelpButton() {
		return helpButton;
	}

	public ExitButton getExitButton() {
		return exitButton;
	}

	public void setPauseButton(PauseButton pauseButton) {
		this.pauseButton = pauseButton;
	}

	public void setHelpButton(HelpButton helpButton) {
		this.helpButton = helpButton;
	}

	public void setExitButton(ExitButton exitButton) {
		this.exitButton = exitButton;
	}
	
}
