package frame.game.panel.component.dynamic;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.game.GameFrame;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LevelPanel extends JPanel {
	
	private GameFrame frame;
	private JLabel leftLevelLabel;
	private JLabel rightLevelLabel;
	private String level = "1";

	public LevelPanel(GameFrame frame) {
		this.frame = frame;
		
		setBounds(frame.getWidth()/2-140, -25, 280, 120);
		layoutManager();
	}
	
	private void layoutManager() {
		leftLevelLabel = new JLabel("Level");
		rightLevelLabel = new JLabel(level);
		
		setBackground(Color.MAGENTA);
		setLayout(null);
		
		leftLevelLabel.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 40));
		leftLevelLabel.setBounds(35, 0, 140, 120);
		rightLevelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rightLevelLabel.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 40));
		rightLevelLabel.setBounds(126, 0, 120, 120);
		
		add(leftLevelLabel);
		add(rightLevelLabel);
	}
	
	public void setLevel(String level) {
		this.level = level;
		rightLevelLabel.setText(level);		
	}

}
