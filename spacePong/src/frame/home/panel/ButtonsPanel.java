package frame.home.panel;

import javax.swing.JPanel;
import frame.home.HomeFrame;
import frame.home.panel.component.button.*;

public class ButtonsPanel extends JPanel {

	private HomeFrame frame;
	private StatisticsButton statisticsButton;
	private SettingsButton settingsButton;
	private CreditsButton creditsButton;
	
	public ButtonsPanel(HomeFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		statisticsButton = new StatisticsButton(frame);
		settingsButton = new SettingsButton(frame);
		creditsButton = new CreditsButton(frame);
		
		setLayout(null);
		
		add(statisticsButton);
		add(settingsButton);
		add(creditsButton);
	}

	public HomeFrame getFrame() {
		return frame;
	}

	public StatisticsButton getStatisticsButton() {
		return statisticsButton;
	}

	public SettingsButton getSettingsButton() {
		return settingsButton;
	}

	public CreditsButton getCreditsButton() {
		return creditsButton;
	}

	public void setFrame(HomeFrame frame) {
		this.frame = frame;
	}

	public void setStatisticsButton(StatisticsButton statisticsButton) {
		this.statisticsButton = statisticsButton;
	}

	public void setSettingsButton(SettingsButton settingsButton) {
		this.settingsButton = settingsButton;
	}

	public void setCreditsButton(CreditsButton creditsButton) {
		this.creditsButton = creditsButton;
	}

}
