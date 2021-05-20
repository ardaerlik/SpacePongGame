package frame.home.panel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import frame.home.StatisticsFrame;
import main.User;

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
	private JLabel point11;
	private JLabel point12;
	private JLabel point13;
	private JLabel point21;
	private JLabel point22;
	private JLabel point23;
	
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
		String[][] scoreValues = statisticsChecker(Mode.SCORE);
		String[][] levelValues = statisticsChecker(Mode.LEVEL);
		
		setScoreRank(scoreValues);
		setLevelRank(levelValues);
	}
	
	private String[][] statisticsChecker(Mode mode) {
		Map<String, Integer> userMap = getUserMap(mode);
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		String[][] values = new String[3][2];
		
		userMap.entrySet()
			   .stream()
			   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			   .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		values[0][0] = (String) (sortedMap.keySet().toArray()[0] + "");
		values[1][0] = (String) (sortedMap.keySet().toArray()[1] + "");
		values[2][0] = (String) (sortedMap.keySet().toArray()[2] + "");
		
		values[0][1] = (String) (sortedMap.values().toArray()[0] + "");
		values[1][1] = (String) (sortedMap.values().toArray()[1] + "");
		values[2][1] = (String) (sortedMap.values().toArray()[2] + "");
		
		return values;
	}
	
	private Map<String, Integer> getUserMap(Mode mode){
		Map<String, Integer> map = new HashMap<>();
		
		ArrayList<User> users = User.getUsers();
		
		if (mode == Mode.LEVEL) {
			for (int i=0; i<users.size(); i++) {
				map.put(users.get(i).getName(),
						users.get(i).getMaxLevel());
			}
		}
		else if (mode == Mode.SCORE) {
			for (int i=0; i<users.size(); i++) {
				map.put(users.get(i).getName(),
						users.get(i).getMaxScore());
			}
		}
		
		return map;
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
		score1 = new JLabel(scoreValues[0][0]);
		score2 = new JLabel(scoreValues[1][0]);
		score3 = new JLabel(scoreValues[2][0]);
		
		point11 = new JLabel(scoreValues[0][1]);
		point12 = new JLabel(scoreValues[1][1]);
		point13 = new JLabel(scoreValues[2][1]);

		score1.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		score2.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		score3.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		
		point11.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		point12.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		point13.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		
		score1.setHorizontalTextPosition(SwingConstants.CENTER);
		score2.setHorizontalTextPosition(SwingConstants.CENTER);
		score3.setHorizontalTextPosition(SwingConstants.CENTER);
		
		point11.setHorizontalTextPosition(SwingConstants.CENTER);
		point12.setHorizontalTextPosition(SwingConstants.CENTER);
		point13.setHorizontalTextPosition(SwingConstants.CENTER);
		
		score1.setBounds(586, 124, 172, 105);
		score2.setBounds(371, 268, 139, 86);
		score3.setBounds(788, 269, 137, 86);
		
		point11.setBounds(616, 99, 172, 105);
		point12.setBounds(391, 243, 139, 86);
		point13.setBounds(828, 244, 137, 86);
		
		score1.setVisible(true);
		score2.setVisible(true);
		score3.setVisible(true);
		point11.setVisible(true);
		point12.setVisible(true);
		point13.setVisible(true);
		
		add(score1);
		add(score2);
		add(score3);
		add(point11);
		add(point12);
		add(point13);
	}
	
	private void setLevelRank(String[][] levelValues) {
		level1 = new JLabel(levelValues[0][0]);
		level2 = new JLabel(levelValues[1][0]);
		level3 = new JLabel(levelValues[2][0]);
		
		point21 = new JLabel(levelValues[0][1]);
		point22 = new JLabel(levelValues[1][1]);
		point23 = new JLabel(levelValues[2][1]);
		
		level1.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		level2.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		level3.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		
		point21.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		point22.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		point23.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 13));
		
		level1.setHorizontalTextPosition(SwingConstants.CENTER);
		level2.setHorizontalTextPosition(SwingConstants.CENTER);
		level3.setHorizontalTextPosition(SwingConstants.CENTER);
		
		point21.setHorizontalTextPosition(SwingConstants.CENTER);
		point22.setHorizontalTextPosition(SwingConstants.CENTER);
		point23.setHorizontalTextPosition(SwingConstants.CENTER);
		
		level1.setBounds(586, 124, 172, 105);
		level2.setBounds(371, 268, 139, 86);
		level3.setBounds(788, 269, 137, 86);
		
		point21.setBounds(616, 99, 172, 105);
		point22.setBounds(391, 243, 139, 86);
		point23.setBounds(828, 244, 137, 86);
		
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
		point21.setVisible(false);
		point22.setVisible(false);
		point23.setVisible(false);
		
		add(level1);
		add(level2);
		add(level3);
		add(point21);
		add(point22);
		add(point23);
	}
	
	private void disableScores() {
		scoreChart.setVisible(false);
		score1.setVisible(false);
		score2.setVisible(false);
		score3.setVisible(false);
		point11.setVisible(false);
		point12.setVisible(false);
		point13.setVisible(false);
	}
	
	private void disableLevels() {
		levelChart.setVisible(false);
		level1.setVisible(false);
		level2.setVisible(false);
		level3.setVisible(false);
		point21.setVisible(false);
		point22.setVisible(false);
		point23.setVisible(false);
	}
	
	private void enableScores() {
		scoreChart.setVisible(true);
		score1.setVisible(true);
		score2.setVisible(true);
		score3.setVisible(true);
		point11.setVisible(true);
		point12.setVisible(true);
		point13.setVisible(true);
	}
	
	private void enableLevels() {
		levelChart.setVisible(true);
		level1.setVisible(true);
		level2.setVisible(true);
		level3.setVisible(true);
		point21.setVisible(true);
		point22.setVisible(true);
		point23.setVisible(true);
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
