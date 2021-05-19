import javax.swing.JFrame;

import frame.animate.ProgressFrame;
import frame.game.*;

public class Main {
	
	private static GameFrame gameFrame;
	private static ProgressFrame progressFrame;
	private static JFrame currentFrame;
	
	public static void main(String[] args) throws InterruptedException {
		progressFrame = new ProgressFrame();
		progressFrame.setVisible(true);
		currentFrame = progressFrame;
		Thread.sleep(5000);
		//gamePage();
	}
	
	public static void homePage() {
		
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
	}

}
