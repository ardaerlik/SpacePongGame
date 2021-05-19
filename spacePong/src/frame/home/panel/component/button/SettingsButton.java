package frame.home.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import frame.home.HomeFrame;

public class SettingsButton extends JButton {

	private HomeFrame frame;
	
	public SettingsButton(HomeFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(10, 5, 80, 80);
		setToolTipText("Click this button to reach settings");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/settings.png"));
		addActionListener(new Handler());
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("settings calisiyor");
		}
		
	}
	
}
