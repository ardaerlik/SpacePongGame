package frame.home.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import frame.home.HomeFrame;
import main.Main;

public class StartButton extends JButton {

	private HomeFrame frame;
	
	public StartButton(HomeFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()/2-40, 20, 80, 80);
		setToolTipText("Click this button to start game");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/resume.png"));
		addActionListener(new Handler());
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Main.progressPageToGame();
		}
		
	}
	
}
