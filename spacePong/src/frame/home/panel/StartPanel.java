package frame.home.panel;

import javax.swing.JPanel;
import frame.home.HomeFrame;
import frame.home.panel.component.button.StartButton;

public class StartPanel extends JPanel {
	
	private HomeFrame frame;
	private StartButton startButton;
	
	public StartPanel(HomeFrame frame) {
		requestFocus();
		requestFocusInWindow();
		
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		startButton = new StartButton(frame);
		
		setLayout(null);
		
		add(startButton);
	}

}
