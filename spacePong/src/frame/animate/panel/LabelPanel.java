package frame.animate.panel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frame.animate.ProgressFrame;

public class LabelPanel extends JPanel {

	private ProgressFrame frame;
	private JLabel label;
	private String text;
	
	public LabelPanel(ProgressFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		label = new JLabel("");
		
		setLayout(null);
		label.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 40));
		label.setBounds(35, 0, 140, 120);
		
		add(label);
	}
	
	public void setLabelBounds(int x, int y, int width, int height) {
		label.setBounds(x, y, width, height);
	}
	
	public void setLabelAllignment() {
		label.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	
	public void setText(String text) {
		this.text = text;
		label.setText(text);
	}
	
	public String getText() {
		return text;
	}

}
