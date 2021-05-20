package frame.home.panel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import frame.home.StatisticsFrame;
import main.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
		
		statisticsBuilder();
		
		setScoreChart();
		setLevelChart();
	}
	
	private void statisticsBuilder() {
		String[][] scoreValues = statisticsChecker(Mode.SCORE);
		String[][] levelValues = statisticsChecker(Mode.LEVEL);
		
		setScoreRank(scoreValues);
		setLevelRank(levelValues);
	}
	
	private String[][] statisticsChecker(Mode mode) {
		Map<Integer, String> userMap = new TreeMap<Integer, String>();
		String[][] values = new String[3][2];

		ArrayList<User> users = User.getUsers();
		
		if (mode == Mode.LEVEL) {
			for (int i=0; i<users.size(); i++) {
				userMap.put(users.get(i).getMaxLevel(), 
						users.get(i).getName());
			}
		}
		else if (mode == Mode.SCORE) {
			for (int i=0; i<users.size(); i++) {
				userMap.put(users.get(i).getMaxScore(), 
						users.get(i).getName());
			}
		} 
		
		values[0][0] = (String) (userMap.keySet().toArray()[0] + "");
		values[1][0] = (String) (userMap.keySet().toArray()[1] + "");
		values[2][0] = (String) (userMap.keySet().toArray()[2] + "");
		
		values[0][1] = (String) (userMap.values().toArray()[0] + "");
		values[1][1] = (String) (userMap.values().toArray()[1] + "");
		values[2][1] = (String) (userMap.values().toArray()[2] + "");
		
		System.out.println(values[0][0]);
		System.out.println(values[0][1]);
		System.out.println(values[1][0]);
		System.out.println(values[1][1]);
		System.out.println(values[2][0]);
		System.out.println(values[2][1]);
		
		return values;
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
	
	private void setScoreRank(String[][] scoreValues) {
		score1 = new JLabel(scoreValues[0][0] + " | " + scoreValues[0][1]);
		score2 = new JLabel(scoreValues[1][0] + " | " + scoreValues[1][1]);
		score3 = new JLabel(scoreValues[2][0] + " | " + scoreValues[2][1]);
		
		score1.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		score2.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		score3.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		
		score1.setBounds(546, 119, 172, 105);
		score2.setBounds(341, 263, 139, 86);
		score3.setBounds(778, 264, 137, 86);
		
		score1.setVisible(true);
		score2.setVisible(true);
		score3.setVisible(true);
	}
	
	private void setLevelRank(String[][] levelValues) {
		level1 = new JLabel(levelValues[0][0] + " | " + levelValues[0][1]);
		level2 = new JLabel(levelValues[1][0] + " | " + levelValues[1][1]);
		level3 = new JLabel(levelValues[2][0] + " | " + levelValues[2][1]);
		
		level1.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		level2.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		level3.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 12));
		
		level1.setBounds(546, 119, 172, 105);
		level2.setBounds(341, 263, 139, 86);
		level3.setBounds(778, 264, 137, 86);
		
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
	}
	
	private void disableScores() {
		scoreChart.setVisible(false);
		score1.setVisible(false);
		score2.setVisible(false);
		score3.setVisible(false);
	}
	
	private void disableLevels() {
		levelChart.setVisible(false);
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
	}
	
	private void enableScores() {
		scoreChart.setVisible(true);
		score1.setVisible(true);
		score2.setVisible(true);
		score3.setVisible(true);
	}
	
	private void enableLevels() {
		levelChart.setVisible(true);
		level1.setVisible(true);
		level2.setVisible(true);
		level3.setVisible(true);
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == scoreButton) {
				disableLevels();
				enableScores();
				scoreButton.setEnabled(false);
				levelButton.setEnabled(true);
			}
			else if (e.getSource() == levelButton) {
				disableScores();
				enableLevels();
				levelButton.setEnabled(false);
				scoreButton.setEnabled(true);
			}
		}
		
	}

}
