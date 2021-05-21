package frame.game.panel.component.dynamic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import frame.game.GameFrame;

public class TimerPanel extends JPanel implements ActionListener {
	
	private final int radius = 48;
	private final int x = 1;
	private final int y = 1;
	private double degree = 0;
	private GameFrame frame;
	private Timer timer;

	public TimerPanel(GameFrame frame) {
		this.frame = frame;
		
		setBackground(Color.MAGENTA);
		setBounds(frame.getWidth()-120, 5, 100, 100);

		timer = new Timer(25, this);
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public void pauseTimer() {
		timer.stop();
	}
	
	public void resetTimer() {
		pauseTimer();
		degree = 0;
		
		repaint();
	}
	
	private void rushTimer(Graphics g) {
		if ((int)degree%3 == 0) {
			g.setColor(Color.BLACK);
			g.fillArc(x, y, radius*2, radius*2, 90, (int) -degree);
		} else {
			g.setColor(Color.RED);
			g.fillArc(x, y, radius*2, radius*2, 90, (int) -degree);
		}
	}
	
	private void normalTimer(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillArc(x, y, radius*2, radius*2, 90, (int) -degree);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (degree < 300) {
			normalTimer(g);
		} else {
			rushTimer(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (degree < 360) {
			degree += 25.0/1000.0*6.0;
		}
		repaint();	
	}
	
	public double getCurrentTime() {
		return degree / 6;
	}

}
