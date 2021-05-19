package frame.home.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatisticsPanel extends JPanel {
	
	private JFrame frame;
	
	public StatisticsPanel(JFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		setLayout(null);
	}

}
