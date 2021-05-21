package frame.home.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import frame.home.HomeFrame;

public class ThemePanel extends JPanel 
	implements ActionListener {

	private HomeFrame frame;
	private String[] themes;
	private int money;
	
	public ThemePanel(HomeFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
