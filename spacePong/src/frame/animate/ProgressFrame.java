package frame.animate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import frame.animate.panel.LabelPanel;
import frame.animate.panel.MainPanel;
import java.awt.Color;

public class ProgressFrame extends JFrame {

	private JPanel contentPane;
	private MainPanel mainPanel;
	private LabelPanel labelPanel1;
	private LabelPanel labelPanel2;

	public ProgressFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1024, 768);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		layoutManager();
	}
	
	private void layoutManager() {
		mainPanel = new MainPanel();
		labelPanel1 = new LabelPanel();
		labelPanel2 = new LabelPanel();
		
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, labelPanel1, 0, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, labelPanel1, 440, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, labelPanel1, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, labelPanel1, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 440, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 570, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, mainPanel, 1024, SpringLayout.WEST, contentPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, labelPanel2, 570, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, labelPanel2, 768, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, labelPanel2, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, labelPanel2, 1024, SpringLayout.WEST, contentPane);
		
		labelPanel1.setBackground(Color.CYAN);
		labelPanel2.setBackground(Color.GRAY);
		mainPanel.setBackground(Color.MAGENTA);
		
		contentPane.add(labelPanel1);
		contentPane.add(mainPanel);
		contentPane.add(labelPanel2);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public LabelPanel getLabelPanel1() {
		return labelPanel1;
	}

	public LabelPanel getLabelPanel2() {
		return labelPanel2;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void setLabelPanel1(LabelPanel labelPanel1) {
		this.labelPanel1 = labelPanel1;
	}

	public void setLabelPanel2(LabelPanel labelPanel2) {
		this.labelPanel2 = labelPanel2;
	}

}
