package frame.animate.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import frame.animate.ProgressFrame;
import main.Main;

public class MainPanel extends JPanel 
	implements ActionListener {
	
	public enum Mode {TO_GAME, TO_HOME, TO_LICENSE, 
		TO_SETTINGS, TO_STATISTICS, DEFAULT};
	private ProgressFrame frame;
	private Timer timer;
	private Mode mode;
	private double percentage;
	private int location;
	private boolean isFinished;
	
	public MainPanel(ProgressFrame frame) {
		requestFocus();
		requestFocusInWindow();
		
		this.frame = frame;
		this.mode = Mode.DEFAULT;
		this.location = 50;
		this.percentage = 0;
		this.isFinished = false;
		
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
		} else {
			isFinished = true;
			stopTimer();
			
			switch (mode) {
			case TO_GAME:
				goToGame();
				break;
			case TO_HOME:
				goToHome();
				break;
			case TO_LICENSE:
				goToLicense();
				break;
			case TO_SETTINGS:
				goToSettings();
				break;
			case TO_STATISTICS:
				goToStatistics();
				break;
			default:
				break;
			}
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
	
	private void goToGame() {
		Main.gamePage();
	}
	
	private void goToHome() {
		Main.homePage();
	} 
	
	private void goToLicense() {
		Main.licensePage();
	}
	
	private void goToStatistics() {
		Main.statisticsPage();
	}
	
	private void goToSettings() {
		Main.settingsPage();
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	
}
