package frame.game.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import frame.game.GameFrame;

public class GamePanel extends JPanel 
	implements ActionListener, KeyListener {
	
	private enum PressedKey {LEFT, RIGHT};
	private GameFrame frame;
	private TopPanel topPanel;
	private Mode mode;
	private Timer timer;
	private long checkedTime;
	private final int PADDLE_WIDTH = 120;
	private final int PADDLE_HEIGHT = 10;
	private final int paddlePositionY = 470;
	private int paddlePositionX = 50;
	private int paddleVelocity = 30;
	private ArrayList<PressedKey> pressedKeys;
	
	public GamePanel(GameFrame frame, TopPanel topPanel) {
		this.frame = frame;
		this.topPanel = topPanel;
		this.mode = Mode.PAUSE;
		
		pressedKeys = new ArrayList<PressedKey>();
		
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		
		timer = new Timer(20, this);
		playGame();
	}
	
	public void pauseGame() {
		switch (mode) {
			case RESUME:
				topPanel.getTimerPanel().pauseTimer();
				requestFocusInWindow();
				mode = Mode.PAUSE;
				break;
			case PAUSE:
				break;
		}
	}
	
	public void resumeGame() {
		switch (mode) {
			case PAUSE:
				topPanel.getTimerPanel().startTimer();
				requestFocusInWindow();
				mode = Mode.RESUME;
				break;
			case RESUME:
				break;
		}
	}
	
	public void playGame() {
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(paddlePositionX, paddlePositionY, PADDLE_WIDTH, PADDLE_HEIGHT);

	}
	
	private void smoothPaddle(Graphics g) {
		
	}
	
	private boolean isValidPosition(PressedKey e) {
		switch (e) {
			case LEFT:
				return (paddlePositionX-paddleVelocity >= -20);
			case RIGHT:
				return (paddlePositionX+PADDLE_WIDTH+paddleVelocity <= frame.getWidth()+20);
			default:
				return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (mode == Mode.RESUME) {repaint();}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (mode == Mode.PAUSE) {return;}
		
		switch (e.getKeyCode()) {
			case (37):
				if (isValidPosition(PressedKey.LEFT)) {
					paddlePositionX -= paddleVelocity;
				}
				break;
			case (39):
				if (isValidPosition(PressedKey.RIGHT)) {
					paddlePositionX += paddleVelocity;
				}
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
