package frame.game.panel.component.dynamic;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.game.GameFrame;
import javax.swing.ImageIcon;

public class ScorePanel extends JPanel {
	
	private JLabel[] liveLabels;
	private GameFrame frame;
	private JLabel scoreLabel;
	private String score;
	private int liveCount;

	public ScorePanel(GameFrame frame, int liveCount, String score) {
		this.frame = frame;
		this.liveCount = liveCount;
		this.score = score;
		this.liveLabels = new JLabel[7];
		
		setBounds(10, 10, 55*liveCount, 100);
		layoutManager();
	}
	
	private void layoutManager() {		
		setBackground(Color.MAGENTA);
		setLayout(null);
		
		for (int i=0; i<liveLabels.length; i++) {
			JLabel tmpLabel = new JLabel("");
			tmpLabel.setIcon(new ImageIcon("spacePong/assets/images/gameObjects/heart.png"));
			tmpLabel.setBounds(10 + i*50, 55, 45, 47);
			tmpLabel.setVisible(false);
			liveLabels[i] = tmpLabel;
			add(tmpLabel);
		}
		
		for (int i=0; i<liveCount; i++) {
			liveLabels[i].setVisible(true);
		}
		
		scoreLabel = new JLabel(score);
		scoreLabel.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 40));
		scoreLabel.setBounds(40, -50, 140, 120);
		
		add(scoreLabel);
	}
	
	public void setLiveCount(int liveCount) {
		if (liveCount > 3) {
			this.liveCount = 3;
		} else {
			this.liveCount = liveCount;
		}
		
		for (int i=this.liveCount; i<liveLabels.length; i++) {
			liveLabels[i].setVisible(false);
		}
		
		for (int i=0; i<this.liveCount; i++) {
			liveLabels[i].setVisible(true);
		}
	}
	
	public void setScore(String score) {
		this.score = score;
		scoreLabel.setText(score);
	}
	
	public int getLiveCount() {
		return this.liveCount;
	}
	
	public String getScore() {
		return this.score;
	}

}
