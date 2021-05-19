package frame.home.panel;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JPanel;
import frame.home.CreditsFrame;
import javax.swing.JTextArea;

public class CreditsPanel extends JPanel {
	
	private CreditsFrame frame;
	private JTextArea textArea;
	private String text;

	public CreditsPanel(CreditsFrame frame) {
		this.frame = frame;
		this.text = "";
		
		layoutManager();
	}
	
	private void layoutManager() {	
		textArea = new JTextArea();

		getLicenseText();
		
		textArea.setText(text);
		textArea.setEditable(false);
		textArea.setBackground(Color.MAGENTA);
		textArea.setBounds(frame.getWidth()/2-425, 50, 850, 540);
		textArea.setFont(new Font("American Typewriter", Font.PLAIN, 18));
		
		setLayout(null);
		
		add(textArea);
	}
	
	private void getLicenseText() {
		try {
			Scanner file = new Scanner(Paths.get("spacePong//txtFiles//LICENSE.txt"));
			
			while (file.hasNextLine()) {
				text += file.nextLine() + "\n";
			}
			
			file.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
