package frame.game.panel;

import javax.swing.JPanel;
import frame.game.GameFrame;

public class GamePanel extends JPanel {

	private GameFrame frame;
	private TopPanel topPanel;
	private Mode mode;
	
	public GamePanel(GameFrame frame, TopPanel topPanel) {
		this.frame = frame;
		this.topPanel = topPanel;
		this.mode = Mode.PAUSE;
	}
	
	public void pauseGame() {
		switch (mode) {
			case PAUSE:
				System.out.println("Game has already paused");
				break;
			case RESUME:
				System.out.println("Game has just paused");
				topPanel.getTimerPanel().pauseTimer();
				mode = Mode.PAUSE;
				break;
		}
	}
	
	public void resumeGame() {
		switch (mode) {
			case RESUME:
				System.out.println("Game has already resumed");
				break;
			case PAUSE:
				System.out.println("Game has just resumed");
				topPanel.getTimerPanel().startTimer();
				mode = Mode.RESUME;
				break;
		}
	}
	
}
