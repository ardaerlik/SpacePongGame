package main;

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
	private static JFrame currentFrame;
	
	public static void main(String[] args) throws InterruptedException {
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
	
	public static void progressPageToGame() {
		progressPage();
		progressFrame.setMode(Mode.TO_GAME);
	}
	
	public static void progressPageToHome() {
		progressPage();
		progressFrame.setMode(Mode.TO_HOME);
	}
	
	public static void progressPageToLicense() {
		progressPage();
		progressFrame.setMode(Mode.TO_LICENSE);
	}
	
	public static void killProgressTimer() {
		progressFrame.getMainPanel().stopTimer();
	}

}
