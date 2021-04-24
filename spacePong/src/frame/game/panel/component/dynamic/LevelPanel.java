package frame.game.panel.component.dynamic;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.game.GameFrame;

public class LevelPanel extends JPanel {
	
	private GameFrame frame;
	private JLabel leftLevelLabel;
	private JLabel rightLevelLabel;

	public LevelPanel(GameFrame frame) {
		this.frame = frame;
	}

}
