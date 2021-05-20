package frame.home.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Main;

import java.awt.Color;
import java.awt.Font;

public class SettingsPanel extends JPanel {
	
	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JButton resetButton;
	private JButton saveButton;
	private JLabel titleLabel;
	private JLabel label1;
	private JLabel label2;
	private String userName;

	public SettingsPanel(JFrame frame) {
		this.frame = frame;
		
		layoutManager();
	}
	
	private void layoutManager() {
		textField = new JTextField();
		resetButton = new JButton("RESET PROGRESS");
		saveButton = new JButton("SAVE PROGRESS");
		label1 = new JLabel("ENTER YOUR");
		label2 = new JLabel("NAME");
		titleLabel = new JLabel("SETTINGS");
		panel = new JPanel();
		
		setLayout(null);
		
		setPanel();
		setTitleLabel();
		setLabel1();
		setLabel2();
		setTextField();
		setSaveButton();
		setResetButton();
		
		textField.addActionListener(new Handler());
		saveButton.addActionListener(new Handler());
		resetButton.addActionListener(new Handler());
		
		add(titleLabel);
		add(label1);
		add(label2);
		add(textField);
		add(saveButton);
		add(resetButton);
		add(panel);
	}
	
	private void setPanel() {
		panel.setBackground(Color.CYAN);
		panel.setBounds(61, 100, 496, 451);
	}
	
	private void setTitleLabel() {
		titleLabel.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 30));
		titleLabel.setBounds(412, 0, 300, 70);
	}
	
	private void setLabel1() {
		label1.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 24));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(105, 130, 409, 50);
	}
	
	private void setLabel2() {
		label2.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 24));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(105, 180, 409, 50);
	}
	
	private void setTextField() {
		textField.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		textField.setBounds(105, 335, 409, 151);
		textField.setText(Main.getUserName());
		textField.setBackground(Color.BLUE);
		textField.setColumns(10);
	}
	
	private void setSaveButton() {
		saveButton.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		saveButton.setBounds(612, 170, 300, 92);
		saveButton.setBorderPainted(false);
		saveButton.setVerticalTextPosition(SwingConstants.CENTER);
		saveButton.setHorizontalTextPosition(SwingConstants.CENTER);
		saveButton.setToolTipText("Click this button to save username");
		saveButton.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/save.png"));
	}
	
	private void setResetButton() {
		resetButton.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 18));
		resetButton.setBounds(612, 389, 300, 92);
		resetButton.setBorderPainted(false);
		resetButton.setVerticalTextPosition(SwingConstants.CENTER);
		resetButton.setHorizontalTextPosition(SwingConstants.CENTER);
		resetButton.setToolTipText("Click this button to reset username");
		resetButton.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/save.png"));
	}
	
	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == textField) {
				userName = e.getActionCommand();
				saveButton.setEnabled(true);
				resetButton.setEnabled(true);
			}
			else if (e.getSource() == saveButton) {
				if (userName == null) {
					userName = "tmp" + Math.random();
				}
				
				Main.setUserName(userName);
				textField.setEditable(false);
				saveButton.setEnabled(false);
				resetButton.setEnabled(true);
			}
			else if (e.getSource() == resetButton) {
				Main.setUserName("PlayerDEMO");
				textField.setText("Press here to type");
				textField.setEditable(true);
				saveButton.setEnabled(true);
				resetButton.setEnabled(false);
			}	
		}
		
	}

}
