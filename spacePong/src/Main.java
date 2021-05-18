import frame.game.*;

public class Main {
	
	private static GameFrame gameFrame;
	
	public static void main(String[] args) {
		gamePage();
	}
	
	public static void homePage() {
		
	}	
	
	public static void gamePage() {
		gameFrame = new GameFrame();
		gameFrame.setVisible(true);
		gameFrame.playGame();
	}

}
