package frame.animate.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import frame.animate.ProgressFrame;

public class MainPanel extends JPanel 
	implements ActionListener {
	
	private ProgressFrame frame;
	private Timer timer;
	private double percentage;
	private int location;
	
	public MainPanel(ProgressFrame frame) {
		this.frame = frame;
		this.location = 50;
		this.percentage = 0;
		
		timer = new Timer(5, this);
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
		
		frame.getLabelPanel2().setText((int) percentage + " %");
		repaint();
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	public double getPercentage() {
		return percentage;
	}
	
}
