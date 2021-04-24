package frame.game;

import frame.game.panel.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private TopPanel topPanel;
	private GamePanel gamePanel;
	private BelowPanel belowPanel;

	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024, 768);
		
		contentPane = new JPanel();
		setContentPane(contentPane);  
	
		layoutManager();
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