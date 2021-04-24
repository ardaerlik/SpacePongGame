package frame.game.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import frame.game.GameFrame;
import frame.game.panel.Mode;

public class HelpButton extends JButton {
	
	private Mode mode;
	private GameFrame frame;
	
	public HelpButton(GameFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(10, 5, 80, 80);
		setToolTipText("Click this button to get help");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/help.png"));
		addActionListener(new Handler());
		
		mode = Mode.RESUME;
	}
	
	public Mode getMode() {
		return this.mode;
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (mode) {
				case RESUME:
					frame.getGamePanel().pauseGame();
					mode = Mode.PAUSE;
					break;
				case PAUSE:
					frame.getGamePanel().resumeGame();
					mode = Mode.RESUME;
					break;		
			}
		}
		
	}

}
