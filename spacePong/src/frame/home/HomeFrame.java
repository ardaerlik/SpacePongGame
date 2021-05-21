package frame.home;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import frame.home.panel.*;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private StartPanel startPanel;
	private ThemePanel themePanel;
	private ButtonsPanel buttonsPanel;

	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024, 768);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		layoutManager();
	}
	
	private void layoutManager() {
		startPanel = new StartPanel(this);
		themePanel = new ThemePanel(this);
		buttonsPanel = new ButtonsPanel(this);

		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, startPanel, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, startPanel, 115, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, startPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, startPanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, themePanel, 115, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, themePanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, themePanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, themePanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, buttonsPanel, 623, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonsPanel, 768, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, buttonsPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, buttonsPanel, 1024, SpringLayout.WEST, contentPane);
		
		startPanel.setBackground(new Color(235, 219, 178));
		themePanel.setBackground(new Color(40, 40, 40));
		buttonsPanel.setBackground(new Color(235, 219, 178));
		
		contentPane.add(startPanel);
		contentPane.add(themePanel);
		contentPane.add(buttonsPanel);
	}

}
