package frame.game.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PauseButton extends JButton {
	
	public enum Mode {PAUSE, RESUME};
	private Mode mode;
	private JFrame frame;
	
	public PauseButton(JFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()/2-40, 5, 80, 80);
		setToolTipText("Click this button to get help");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
		addActionListener(new Handler());
		
		mode = Mode.PAUSE;
	}
	
	public Mode getMode() {
		return this.mode;
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (mode) {
				case PAUSE:
					setToolTipText("Click this button to pause game");
					setIcon(new ImageIcon("spacePong/assets/images/gameButtons/pause.png"));
					mode = Mode.RESUME;
					break;
				case RESUME:
					setToolTipText("Click this button to resume game");
					setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
					mode = Mode.PAUSE;
					break;
			}
			
		}
		
	}

}
