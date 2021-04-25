package frame.game.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import frame.game.GameFrame;

public class GamePanel extends JPanel 
	implements ActionListener, KeyListener {

	private GameFrame frame;
	private TopPanel topPanel;
	private Mode mode;
	private Timer timer;
	private final int PADDLE_WIDTH = 120;
	private final int PADDLE_HEIGHT = 10;
	private final int paddlePositionY = 600;
	private int paddlePositionX = 50;
	private int paddleVelocity = 30;

	
	public GamePanel(GameFrame frame, TopPanel topPanel) {
		this.frame = frame;
		this.topPanel = topPanel;
		this.mode = Mode.PAUSE;
		
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		
		timer = new Timer(25, this);
		timer.start();
	}
	
	public void pauseGame() {
		switch (mode) {
			case RESUME:
				System.out.println("Game has just paused");
				topPanel.getTimerPanel().pauseTimer();
				requestFocusInWindow();
				mode = Mode.PAUSE;
				break;
			case PAUSE:
				System.out.println("Game has already paused");
				break;
		}
	}
	
	public void resumeGame() {
		switch (mode) {
			case PAUSE:
				System.out.println("Game has just resumed");
				topPanel.getTimerPanel().startTimer();
				requestFocusInWindow();
				mode = Mode.RESUME;
				break;
			case RESUME:
				System.out.println("Game has already resumed");
				break;
		}
	}
	
	public void play() {
		
	}
	
	public boolean isValidPosition() {return false;}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (mode == Mode.PAUSE) {return;}
		
		switch (e.getKeyCode()) {
			case (37):
				System.out.println("left");
				paddlePositionX -= paddleVelocity;
				break;
			case (39):
				System.out.println("right");
				paddlePositionX += paddleVelocity;
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void setPaddleVelocity(int paddleVelocity) {
		this.paddleVelocity = paddleVelocity;
	}
	
	public int getPaddleVelocity() {
		return this.paddleVelocity;
	}
	
}
