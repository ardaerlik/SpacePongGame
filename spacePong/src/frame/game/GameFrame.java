package frame.game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import frame.game.panel.*;
import main.Main;

public class GameFrame extends JFrame 
	implements ActionListener {

	private JPanel contentPane;
	private TopPanel topPanel;
	private GamePanel gamePanel;
	private BelowPanel belowPanel;
	private Timer timer;
	private boolean isFinished;

	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024, 768);
		
		isFinished = false;
		
		contentPane = new JPanel();
		setContentPane(contentPane);  
	
		layoutManager();
		
		timer = new Timer(20, this);
	}
	
	private void layoutManager() {
		topPanel = new TopPanel(this);
		gamePanel = new GamePanel(this, topPanel);
		belowPanel = new BelowPanel(this);

		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, topPanel, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, topPanel, 115, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, topPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, topPanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, gamePanel, 115, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, gamePanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, gamePanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, gamePanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, belowPanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, belowPanel, 768, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, belowPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, belowPanel, 1024, SpringLayout.WEST, contentPane);
		
		topPanel.setBackground(Color.MAGENTA);
		gamePanel.setBackground(Color.GREEN);
		belowPanel.setBackground(Color.BLUE);
		
		contentPane.add(topPanel);
		contentPane.add(gamePanel);
		contentPane.add(belowPanel);
	}
	
	public void setTheme(GameTheme theme) {
		
	}
	
	public void playGame() {
		timer.start();
		gamePanel.playLevel();
	}
	
	public void finishGame() {
		Main.setLastGameSettings(Integer.parseInt(topPanel.getLevelPanel().getLevel()),
				Integer.parseInt(topPanel.getScorePanel().getScore()), 
				Integer.parseInt(topPanel.getScorePanel().getScore()),
				gamePanel.getSurpriseBoxCount());
		
		Main.progressPageToHome();
	}
	
	public void pauseGame() {
		gamePanel.pauseGame();
	}
	
	public void resumeGame() {
		gamePanel.resumeGame();
	}
	
	private void newLevel() {
		String levelCount = (Integer.parseInt(topPanel.getLevelPanel()
								    .getLevel()) + 1) + "";
		
		String scoreCount = (Integer.parseInt(topPanel.getScorePanel()
								    .getScore()) + 50) + "";
		
		int liveCount = topPanel.getScorePanel()
								.getLiveCount();
		
		topPanel.getLevelPanel()
				.setLevel(levelCount);
		
		topPanel.getScorePanel()
				.setScore(scoreCount);
		
		topPanel.getScorePanel()
				.setLiveCount(liveCount);
		
		topPanel.getTimerPanel()
				.resetTimer();
		
		gamePanel.resetLevel();
		
		gamePanel.getBall()
			     .setVelocityX(gamePanel.getBall()
			    		 				.getVelocityX()*1.2);
		
		gamePanel.getBall()
	     		 .setVelocityY(gamePanel.getBall()
	    		 				        .getVelocityY()*1.2);
		
		gamePanel.playLevel();
		gamePanel.resumeGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if (gamePanel.isTimeIsOver() && topPanel.getScorePanel().getLiveCount() > 0) {
			newLevel();
		}
		
		if ((topPanel.getScorePanel().getLiveCount() <= 0) && !isFinished) {
			isFinished = true;
			finishGame();
		}
	}
	
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
	
	public TopPanel getTopPanel() {
		return this.topPanel;
	}
	
	public BelowPanel getBelowPanel() {
		return this.belowPanel;
	}

}
