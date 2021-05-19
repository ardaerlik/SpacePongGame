package frame.home.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import main.Main;

public class ReturnHomeButton extends JButton {
	
	private JFrame frame;
	
	public ReturnHomeButton(JFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()/2-40, 5, 80, 80);
		setToolTipText("Click this button to go back to home");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/home.png"));
		addActionListener(new Handler());
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Main.progressPageToHome();
		}
		
	}

}
