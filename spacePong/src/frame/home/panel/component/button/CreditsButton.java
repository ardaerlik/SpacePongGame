package frame.home.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import frame.home.HomeFrame;
import main.Main;

public class CreditsButton extends JButton {
	
	private HomeFrame frame;
	
	public CreditsButton(HomeFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()-90, 5, 80, 80);
		setToolTipText("Click this button to reach credits");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/credits.png"));
		addActionListener(new Handler());
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Main.progressPageToLicense();
		}
		
	}

}
