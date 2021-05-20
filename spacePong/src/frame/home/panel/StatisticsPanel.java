package frame.home.panel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frame.home.StatisticsFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StatisticsPanel extends JPanel {
	
	private enum Mode {LEVEL, SCORE};
	private StatisticsFrame frame;
	private JButton scoreButton;
	private JButton levelButton;
	private JLabel scoreChart;
	private JLabel levelChart;
	private JLabel score1;
	private JLabel score2;
	private JLabel score3;
	private JLabel level1;
	private JLabel level2;
	private JLabel level3;
	
	public StatisticsPanel(StatisticsFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		scoreButton = new JButton();
		levelButton = new JButton();
		
		setLayout(null);
		
		scoreButton.setText("Score Rank");
		scoreButton.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		scoreButton.setBounds(20, 140, 200, 171);
		scoreButton.setBorderPainted(false);
		scoreButton.setVerticalTextPosition(SwingConstants.CENTER);
		scoreButton.setHorizontalTextPosition(SwingConstants.CENTER);
		scoreButton.setToolTipText("Click this button to get score rank");
		scoreButton.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/rank.png"));
		scoreButton.addActionListener(new Handler());
		scoreButton.setEnabled(false);
		
		levelButton.setText("Level Rank");
		levelButton.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		levelButton.setBounds(20, 315, 200, 171);
		levelButton.setBorderPainted(false);
		levelButton.setVerticalTextPosition(SwingConstants.CENTER);
		levelButton.setHorizontalTextPosition(SwingConstants.CENTER);
		levelButton.setToolTipText("Click this button to get level rank");
		levelButton.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/rank.png"));
		levelButton.addActionListener(new Handler());
		levelButton.setEnabled(true);
		
		add(scoreButton);
		add(levelButton);
		
		setScoreChart();
		setLevelChart();
		
		statisticsBuilder();
	}
	
	private void statisticsBuilder() {
		
	}
	
	private String[] statisticsChecker(Mode mode) {
		return new String[3];
	}
	
	private void setScoreChart() {
		scoreChart = new JLabel("Score Rank");
		scoreChart.setHorizontalTextPosition(SwingConstants.CENTER);
		scoreChart.setVerticalTextPosition(SwingConstants.BOTTOM);
		scoreChart.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		scoreChart.setIcon(new ImageIcon("spacePong/assets/images/gameIcons/leaderboard.png"));
		scoreChart.setBounds(270, 50, 700, 500);
		scoreChart.setVisible(true);
		
		add(scoreChart);
	}
	
	private void setLevelChart() {
		levelChart = new JLabel("Level Rank");
		levelChart.setHorizontalTextPosition(SwingConstants.CENTER);
		levelChart.setVerticalTextPosition(SwingConstants.BOTTOM);
		levelChart.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		levelChart.setIcon(new ImageIcon("spacePong/assets/images/gameIcons/leaderboard.png"));
		levelChart.setBounds(270, 50, 700, 500);
		levelChart.setVisible(false);
		
		add(levelChart);
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == scoreButton) {
				levelChart.setVisible(false);
				scoreChart.setVisible(true);
				scoreButton.setEnabled(false);
				levelButton.setEnabled(true);
			}
			else if (e.getSource() == levelButton) {
				scoreChart.setVisible(false);
				levelChart.setVisible(true);
				levelButton.setEnabled(false);
				scoreButton.setEnabled(true);
			}
		}
		
	}

}
