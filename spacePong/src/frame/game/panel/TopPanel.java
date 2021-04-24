package frame.game.panel;

import javax.swing.JPanel;

import frame.game.GameFrame;
import frame.game.panel.component.dynamic.TimerPanel;

public class TopPanel extends JPanel {

	private GameFrame frame;
	private TimerPanel timerPanel;
	
	public TopPanel(GameFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		timerPanel = new TimerPanel(frame);
		
		setLayout(null);
		
		add(timerPanel);
	}
	
	public TimerPanel getTimerPanel() {
		return this.timerPanel;
	}

}
