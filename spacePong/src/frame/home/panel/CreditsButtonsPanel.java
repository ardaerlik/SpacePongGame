package frame.home.panel;

import javax.swing.JPanel;
import frame.home.CreditsFrame;
import frame.home.panel.component.button.ReturnHomeButton;

public class CreditsButtonsPanel extends JPanel {

	private CreditsFrame frame;
	private ReturnHomeButton returnHomeButton;

	public CreditsButtonsPanel(CreditsFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		returnHomeButton = new ReturnHomeButton(frame);
		
		setLayout(null);
		
		add(returnHomeButton);
	}

	public CreditsFrame getFrame() {
		return frame;
	}

	public ReturnHomeButton getReturnHomeButton() {
		return returnHomeButton;
	}

	public void setFrame(CreditsFrame frame) {
		this.frame = frame;
	}

	public void setReturnHomeButton(ReturnHomeButton returnHomeButton) {
		this.returnHomeButton = returnHomeButton;
	}

}
