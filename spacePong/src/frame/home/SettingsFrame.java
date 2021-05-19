package frame.home;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import frame.home.panel.*;

public class SettingsFrame extends JFrame {

	private JPanel contentPane;
	private CreditsButtonsPanel  creditsButtonsPanel;
	private SettingsPanel settingsPanel;

	public SettingsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024, 768);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		layoutManager();
	}
	
	private void layoutManager() {
		settingsPanel = new SettingsPanel(this);
		creditsButtonsPanel = new CreditsButtonsPanel(this);
		
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, settingsPanel, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, settingsPanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, settingsPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, settingsPanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, creditsButtonsPanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, creditsButtonsPanel, 768, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, creditsButtonsPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, creditsButtonsPanel, 1024, SpringLayout.WEST, contentPane);
		
		settingsPanel.setBackground(Color.MAGENTA);
		creditsButtonsPanel.setBackground(Color.GREEN);
		
		contentPane.add(settingsPanel);
		contentPane.add(creditsButtonsPanel);
	}

}
