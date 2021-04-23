package frame.game.panel.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PauseButton extends JButton {
	
	private int mode;
	
	public PauseButton() {
		setText("");
		setToolTipText("Click this button to resume game");
		setIcon(new ImageIcon("spacePong/assets/images/resume.png"));
		addActionListener(new Handler());
		
		mode = 0;
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (mode == 0) {
				setToolTipText("Click this button to pause game");
				setIcon(new ImageIcon("spacePong/assets/images/pause.png"));
				mode = 1;
			} else {
				setToolTipText("Click this button to resume game");
				setIcon(new ImageIcon("spacePong/assets/images/resume.png"));
				mode = 0;
			}
			
		}
		
	}

}
