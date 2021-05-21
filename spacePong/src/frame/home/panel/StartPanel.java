package frame.home.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import frame.home.HomeFrame;
import frame.home.panel.component.button.StartButton;
import main.Main;

public class StartPanel extends JPanel 
	implements ActionListener {
	
	private HomeFrame frame;
	private StartButton startButton;
	private JLabel label;
	private Timer timer;
	private String money;
	
	public StartPanel(HomeFrame frame) {
		requestFocus();
		requestFocusInWindow();
		
		this.frame = frame;
		
		layoutManager();
		
		timer = new Timer(20, this);
		timer.start();
	}
	
	private void layoutManager() {
		startButton = new StartButton(frame);
		label = new JLabel();
		
		label.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 24));
		label.setVerticalTextPosition(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		label.setIcon(new ImageIcon("spacePong/assets/images/gameObjects/money.png"));
		label.setBounds(810, 5, 300, 90);
		
		setLayout(null);
		
		add(startButton);
		add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.money = "$"+ Main.getMoney();
		label.setText(money);
	}

}
