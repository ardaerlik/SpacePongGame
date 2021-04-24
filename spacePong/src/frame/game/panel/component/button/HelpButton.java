package frame.game.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HelpButton extends JButton {
	
	public enum Mode {ON, OFF};
	private Mode mode;
	private JFrame frame;
	
	public HelpButton(JFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(10, 5, 80, 80);
		setToolTipText("Click this button to get help");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/help.png"));
		addActionListener(new Handler());
		
		mode = Mode.OFF;
	}
	
	public Mode getMode() {
		return this.mode;
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mode = Mode.ON;		
		}
		
	}

}
