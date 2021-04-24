package frame.game.panel;

import javax.swing.JPanel;

import frame.game.GameFrame;
import frame.game.panel.component.dynamic.LevelPanel;
import frame.game.panel.component.dynamic.ScorePanel;
import frame.game.panel.component.dynamic.TimerPanel;

public class TopPanel extends JPanel {

	private GameFrame frame;
	private TimerPanel timerPanel;
	private LevelPanel levelPanel;
	private ScorePanel scorePanel;
	
	public TopPanel(GameFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		timerPanel = new TimerPanel(frame);
		levelPanel = new LevelPanel(frame);
		scorePanel = new ScorePanel(frame, 3, "123");
		
		setLayout(null);
		
		add(timerPanel);
		add(levelPanel);
		add(scorePanel);
	}
	
	public TimerPanel getTimerPanel() {
		return this.timerPanel;
	}

}
