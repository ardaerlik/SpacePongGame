import javax.swing.JFrame;

import frame.animate.ProgressFrame;
import frame.game.*;
import frame.home.*;

public class Main {
	
	private static GameFrame gameFrame;
	private static HomeFrame homeFrame;
	private static ProgressFrame progressFrame;
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
	
	public static void gamePage() throws InterruptedException {
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
		currentFrame.setVisible(false);
		currentFrame.dispose();
		
		currentFrame = progressFrame;
	}

}
