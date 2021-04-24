package frame.game.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExitButton extends JButton {
	
	public enum Mode {ON, OFF};
	private Mode mode;
	private JFrame frame;
	
	public ExitButton(JFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()-90, 5, 80, 80);
		setToolTipText("Click this button to exit home page");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/home.png"));
		addActionListener(new Handler());
		
		mode = Mode.OFF;
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mode = Mode.ON;
			frame.dispose();
		}
		
	}

}
