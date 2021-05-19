package frame.home.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import frame.home.CreditsFrame;
import frame.home.panel.component.button.ReturnHomeButton;

public class CreditsButtonsPanel extends JPanel {

	private JFrame frame;
	private ReturnHomeButton returnHomeButton;

	public CreditsButtonsPanel(JFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		returnHomeButton = new ReturnHomeButton(frame);
		
		setLayout(null);
		
		add(returnHomeButton);
	}

}
