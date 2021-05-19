package frame.animate.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel 
	implements ActionListener {
	
	private Timer timer;
	private double percentage;
	private int location;
	
	public MainPanel() {
		location = 50;
		percentage = 0;
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		paintBar(g);
	}
	
	private void paintBar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(100, 0, location, this.getHeight());
		
		g.setColor(Color.RED);
		g.drawRect(100, 0, 822, this.getHeight()-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (location+1 < this.getWidth()-200) {
			percentage += 0.1295;
			location++;
		}

		repaint();
	}
	
	public double getPercentage() {
		return percentage;
	}
	
}
