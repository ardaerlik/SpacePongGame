package main;

import java.util.ArrayList;
import javax.swing.JFrame;
import frame.animate.ProgressFrame;
import frame.animate.panel.MainPanel.Mode;
import frame.game.*;
import frame.home.*;

public class Main {
	
	private static GameFrame gameFrame;
	private static HomeFrame homeFrame;
	private static ProgressFrame progressFrame;
	private static CreditsFrame creditsFrame;
	private static StatisticsFrame statisticsFrame;
	private static SettingsFrame settingsFrame;
	private static JFrame currentFrame;
	private static String userName;
	private static String[] themes;
	private static int maxLevel;
	private static int maxScore;
	private static int money;
	
	public static void main(String[] args) throws InterruptedException {
		userName = "PlayerDEMO";
		User.getOldUserList();
		
		progressFrame = new ProgressFrame();
		progressFrame.setVisible(true);
		progressFrame.getMainPanel().startTimer();
		currentFrame = progressFrame;
		
		Thread.sleep(6700);
		
		homePage();
	}
	
	public static void homePage() {
		homeFrame = new HomeFrame();
		homeFrame.setBounds(currentFrame.getBounds());
		homeFrame.setVisible(true);
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = homeFrame;
	}	
	
	public static void gamePage() {
		gameFrame = new GameFrame();
		gameFrame.setBounds(currentFrame.getBounds());
		gameFrame.playGame();
		gameFrame.setVisible(true);
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = gameFrame;
	}
	
	public static void progressPage() {
		progressFrame = new ProgressFrame();
		progressFrame.setBounds(currentFrame.getBounds());
		progressFrame.setVisible(true);
		progressFrame.getMainPanel().startTimer();
		currentFrame.setVisible(false);
		currentFrame.dispose();

		currentFrame = progressFrame;
	}
	
	public static void licensePage() {
		creditsFrame = new CreditsFrame();
		creditsFrame.setBounds(currentFrame.getBounds());
		creditsFrame.setVisible(true);
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = creditsFrame;
	}
	
	public static void statisticsPage() {
		statisticsFrame = new StatisticsFrame();
		statisticsFrame.setBounds(currentFrame.getBounds());
		statisticsFrame.setVisible(true);
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = statisticsFrame;
	}
	
	public static void settingsPage() {
		settingsFrame = new SettingsFrame();
		settingsFrame.setBounds(currentFrame.getBounds());
		settingsFrame.setVisible(true);
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = settingsFrame;
	}
	
	public static void progressPageToGame() {
		progressPage();
		User.updateAllUsers(User.getUsers());
		progressFrame.setMode(Mode.TO_GAME);
	}
	
	public static void progressPageToHome() {
		progressPage();
		User.updateAllUsers(User.getUsers());
		progressFrame.setMode(Mode.TO_HOME);
	}
	
	public static void progressPageToLicense() {
		progressPage();
		User.updateAllUsers(User.getUsers());
		progressFrame.setMode(Mode.TO_LICENSE);
	}
	
	public static void progressPageToStatistics() {
		progressPage();
		User.updateAllUsers(User.getUsers());
		progressFrame.setMode(Mode.TO_STATISTICS);
	}
	
	public static void progressPageToSettings() {
		progressPage();
		User.updateAllUsers(User.getUsers());
		progressFrame.setMode(Mode.TO_SETTINGS);
	}
	
	public static void killProgressTimer() {
		progressFrame.getMainPanel().stopTimer();
	}
	
	public static void setLastGameSettings(int maxLevel, int maxScore, int money) {
		int userNo = User.checkUserList(userName);
		Main.money = money;
		Main.maxLevel = maxLevel;
		Main.maxScore = maxScore;
		
		if (userNo != -1) {
			if (User.getUsers().get(userNo).getMaxLevel() < maxLevel) {
				User.getUsers().get(userNo).setMaxLevel(maxLevel);
			}
			
			if (User.getUsers().get(userNo).getMaxScore() < maxScore) {
				User.getUsers().get(userNo).setMaxScore(maxScore);
			}
			
			User.getUsers().get(userNo).setMoney(
					User.getUsers().get(userNo).getMoney() + money);
			
		} else {
			ArrayList<User> oldUsers = User.getUsers();
			String[] themes = {"1"};
			oldUsers.add(new User(userName, maxLevel, maxScore, money, themes));
		}
	}
	
	public static String getUserName() {
		return userName;
	}
	
	public String[] getThemes() {
		return themes;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public int getMoney() {
		return money;
	}
	
	public static void setUserName(String userName) {
		Main.userName = userName;
	}

	public void setThemes(String[] themes) {
		Main.themes = themes;
	}

	public void setMaxLevel(int maxLevel) {
		Main.maxLevel = maxLevel;
	}

	public void setMaxScore(int maxScore) {
		Main.maxScore = maxScore;
	}

	public void setMoney(int money) {
		Main.money = money;
	}

}
