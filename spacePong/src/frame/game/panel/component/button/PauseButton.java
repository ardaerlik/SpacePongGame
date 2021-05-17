package frame.game.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import frame.game.GameFrame;
import frame.game.panel.Mode;

public class PauseButton extends JButton {
	
	private Mode mode;
	private GameFrame frame;
	
	public PauseButton(GameFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()/2-40, 5, 80, 80);
		setToolTipText("Click this button to resume game");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
		addActionListener(new Handler());
		
		mode = Mode.PAUSE;
	}
	
	public Mode getMode() {
		return this.mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
		
		switch (mode) {
			case PAUSE:
				frame.getGamePanel().resumeGame();
				setToolTipText("Click this button to pause game");
				setIcon(new ImageIcon("spacePong/assets/images/gameButtons/pause.png"));
				mode = Mode.RESUME;
				break;
			case RESUME:
				frame.getGamePanel().pauseGame();
				setToolTipText("Click this button to resume game");
				setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
				mode = Mode.PAUSE;
				break;
		}
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (mode) {
				case PAUSE:
					frame.getGamePanel().resumeGame();
					setToolTipText("Click this button to pause game");
					setIcon(new ImageIcon("spacePong/assets/images/gameButtons/pause.png"));
					mode = Mode.RESUME;
					break;
				case RESUME:
					frame.getGamePanel().pauseGame();
					setToolTipText("Click this button to resume game");
					setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
					mode = Mode.PAUSE;
					break;
			}
			
		}
		
	}

}
