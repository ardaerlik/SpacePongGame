package frame.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import frame.game.panel.GamePanel;

public class HelpFrame extends JFrame 
	implements ActionListener {
	
	private JPanel contentPane;
	private GameFrame frame;
	private JPanel helpPanel;
	private JLabel label;
	private JButton button;
	
	public HelpFrame(GameFrame frame) {
		this.frame = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(frame.getBounds());
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		layoutManager();
	}
	
	private void layoutManager() {
		helpPanel = new JPanel();
		label = new JLabel();
		button = new JButton();
		
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, helpPanel, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, helpPanel, 768, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, helpPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, helpPanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, label, 50, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 350, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, label, 112, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, label, 912, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, button, 608, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, button, 688, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, button, 472, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, button, 552, SpringLayout.WEST, contentPane);
		
		helpPanel.setBackground(new Color(40, 40, 40));
		label.setIcon(new ImageIcon("spacePong/assets/images/gameIcons/helpFrame.png"));
		button.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/exit.png"));
		button.setBorderPainted(false);
		
		button.addActionListener(this);

		add(label);
		add(button);
		add(helpPanel);
		
		setVisible(true);
	}
	
	
	private void exit() {
		frame.setVisible(true);
		frame.getGamePanel().resumeGame();
		this.setVisible(false);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		exit();
	}

}
