package frame.home.panel.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import frame.home.HomeFrame;

public class StatisticsButton extends JButton {

	private HomeFrame frame;
	
	public StatisticsButton(HomeFrame frame) {
		this.frame = frame;
		
		setText("");
		setBorderPainted(false);
		setBounds(frame.getWidth()/2-40, 5, 80, 80);
		setToolTipText("Click this button to reach statistics");
		setIcon(new ImageIcon("spacePong/assets/images/gameButtons/scores.png"));
		addActionListener(new Handler());
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("statistics calisiyor");
		}
		
	}
	
}
