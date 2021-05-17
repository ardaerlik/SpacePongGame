package frame.game.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import frame.game.GameFrame;
import frame.game.panel.component.stellar.Ball;
import frame.game.panel.component.stellar.GameObject;
import frame.game.panel.component.stellar.GameObjectHelper;
import frame.game.panel.component.stellar.Meteor;

public class GamePanel extends JPanel 
	implements ActionListener, KeyListener {
	
	private ArrayList<GameObject> gameObjects;
	private enum PressedKey {LEFT, RIGHT};
	private GameFrame frame;
	private TopPanel topPanel;
	private Mode mode;
	private Timer timer;
	private final int PADDLE_WIDTH = 120;
	private final int PADDLE_HEIGHT = 10;
	private final int paddlePositionY = 470;
	private int paddlePositionX = 50;
	private Rectangle paddle;
	private int paddleVelocity = 5;
	private ArrayList<PressedKey> pressedKeys;
	private int pressedKeysLoc;
	private int pressedKeysLocInt;
	private boolean isValid;
	private Ball ball;
	private Meteor meteor;
	private final double fullTime = 60.0;
	private boolean timeIsOver;
	
	public GamePanel(GameFrame frame, TopPanel topPanel) {
		this.frame = frame;
		this.topPanel = topPanel;
		this.mode = Mode.PAUSE;
		
		pressedKeys = new ArrayList<PressedKey>();
		pressedKeysLoc = 0;
		pressedKeysLocInt = 0;
		timeIsOver = false;
		
		gameObjects = new ArrayList<GameObject>();
		
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
		
		ball = new Ball(this);
		meteor = new Meteor(this);
		timer = new Timer(20, this);
		paddle = new Rectangle(paddlePositionX, paddlePositionY, 
				PADDLE_WIDTH, PADDLE_HEIGHT);
		
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
	
	public void playLevel() {
		timer.start();
	}
	
	public void resetLevel() {
		timer.stop();
		mode = Mode.PAUSE;
		
		pressedKeys = new ArrayList<PressedKey>();
		pressedKeysLoc = 0;
		pressedKeysLocInt = 0;
		timeIsOver = false;
		
		gameObjects = new ArrayList<GameObject>();
		
		paddlePositionX = 50;
		
		ball = new Ball(this);
		meteor = new Meteor(this);
		timer = new Timer(20, this);
		paddle = new Rectangle(paddlePositionX, paddlePositionY, 
				PADDLE_WIDTH, PADDLE_HEIGHT);
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		smoothPaddle(g);		
		paintBall(g);
		paintObjects(g);
	}
	
	private void paintBall(Graphics g) {
		ball.move();
		g.drawImage(ball.getImage(), ball.getPositionX(), ball.getPositionY(), null);
	}
	
	private void paintObjects(Graphics g) {
		g.drawImage(meteor.getImage(), meteor.getPositionX(), meteor.getPositionY(), null);
	}
	
	private void smoothPaddle(Graphics g) {
		if (pressedKeysLoc < pressedKeys.size()) {
			
			if (pressedKeysLocInt == 0) {
				isValid = isValidPosition(pressedKeys.get(pressedKeysLoc));
			}
			
			if (isValid) {
				if (pressedKeysLocInt < 4) {
					if (pressedKeys.get(pressedKeysLoc) == PressedKey.LEFT){
						paddlePositionX -= paddleVelocity;
					} else {
						paddlePositionX += paddleVelocity;
					}
					pressedKeysLocInt++;
				} else {
					pressedKeysLoc++;
					pressedKeysLocInt = 0;
				}
			}
			else {
				pressedKeysLoc++;
			}
		}

		g.setColor(Color.BLACK);
		g.fillRect(paddlePositionX, paddlePositionY, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		paddle = new Rectangle(paddlePositionX, paddlePositionY, 
				PADDLE_WIDTH, PADDLE_HEIGHT);
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
		if (GameObjectHelper.intersects(meteor, ball)) {
			// mode = Mode.PAUSE;
		}
		
		if (topPanel.getTimerPanel().getCurrentTime() >= fullTime) {
			mode = Mode.PAUSE;
			timeIsOver = true;
		}
		
		if (mode == Mode.RESUME) {
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (mode == Mode.PAUSE) {return;}
		
		switch (e.getKeyCode()) {
			case (37):
				if (isValidPosition(PressedKey.LEFT)) {
					pressedKeys.add(PressedKey.LEFT);
				}
				break;
			case (39):
				if (isValidPosition(PressedKey.RIGHT)) {
					pressedKeys.add(PressedKey.RIGHT);
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
	
	public int[] getPaddlePosition() {
		int[] position = {paddlePositionX, paddlePositionY};
		return position;
	}

	public Rectangle getPaddle() {
		return paddle;
	}

	public void setPaddle(Rectangle paddle) {
		this.paddle = paddle;
	}
	
	public int getPaddleWidth() {
		return this.PADDLE_WIDTH;
	}
	
	public int getPaddleHeight() {
		return this.PADDLE_HEIGHT;
	}

	public TopPanel getTopPanel() {
		return topPanel;
	}
	
	public boolean isTimeOver() {
		return timeIsOver;
	}
}
