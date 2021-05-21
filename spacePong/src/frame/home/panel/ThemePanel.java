package frame.home.panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import frame.home.HomeFrame;
import main.Main;

public class ThemePanel extends JPanel 
	implements ActionListener {

	private HomeFrame frame;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private String[] themes;
	private Timer timer;
	private boolean isSold1;
	private boolean isSold2;
	private boolean isSold3;
	private boolean canBuy1;
	private boolean canBuy2;
	private boolean canBuy3;
	private int themePrice1;
	private int themePrice2;
	private int themePrice3;
	private int whichTheme;
	private int money;
	
	public ThemePanel(HomeFrame frame) {
		this.frame = frame;
		isSold1 = false;
		isSold2 = false;
		isSold3 = false;
		
		canBuy1 = true;
		canBuy2 = true;
		canBuy3 = true;
		
		themePrice1 = 50;
		themePrice2 = 150;
		themePrice3 = 250;
		
		whichTheme = 1;
		
		layoutManager();
		
		timer = new Timer(20, this);
		timer.start();
	}
	
	private void layoutManager() {
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton("You can't buy");
		button5 = new JButton("You can't buy");
		button6 = new JButton("You can't buy");
		
		button1.setBounds(24, 20, 311, 245);
		button2.setBounds(355, 20, 311, 245);
		button3.setBounds(686, 20, 311, 245);
		button4.setBounds(27, 290, 300, 92);
		button5.setBounds(358, 290, 300, 92);
		button6.setBounds(689, 290, 300, 92);
		
		button1.setIcon(new ImageIcon("spacePong/assets/images/gameIcons/theme1.png"));
		
		button4.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/save.png"));
		button5.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/save.png"));
		button6.setIcon(new ImageIcon("spacePong/assets/images/gameButtons/save.png"));
		button4.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 21));
		button5.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 21));
		button6.setFont(new Font("Big_Bottom_Cartoon", Font.PLAIN, 21));
		
		button4.setBorderPainted(false);
		button5.setBorderPainted(false);
		button6.setBorderPainted(false);
		
		button4.setHorizontalTextPosition(SwingConstants.CENTER);
		button5.setHorizontalTextPosition(SwingConstants.CENTER);
		button6.setHorizontalTextPosition(SwingConstants.CENTER);
		
		button4.setVerticalTextPosition(SwingConstants.CENTER);
		button5.setVerticalTextPosition(SwingConstants.CENTER);
		button6.setVerticalTextPosition(SwingConstants.CENTER);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		setLayout(null);
	
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		money = Main.getMoney();
		themes = Main.getThemes();
		
		for (int i=0; i<themes.length; i++) {
			if (themes[i].equals("1")) {
				isSold1 = true;
				canBuy1 = false;
				button4.setEnabled(false);
			}
			if (themes[i].equals("2")) {
				isSold2 = true;
				canBuy2 = false;
				button5.setEnabled(false);
			}
			if (themes[i].equals("3")) {
				isSold3 = true;
				canBuy3 = false;
				button6.setEnabled(false);
			}
		}
		
		if (!isSold1) {
			button1.setEnabled(false);
		}
		if (!isSold2) {
			button2.setEnabled(false);
		}
		if (!isSold3) {
			button3.setEnabled(false);
		}
		
		if (money < themePrice1) {
			button4.setEnabled(false);
		}
		if (money < themePrice2) {
			button5.setEnabled(false);
		}
		if (money < themePrice3) {
			button6.setEnabled(false);
		}
		
		if (e.getSource() == button1) {
			whichTheme = 1;
			button1.setEnabled(false);
			if (isSold2) {
				button2.setEnabled(true);
			}
			if (isSold3) {
				button3.setEnabled(true);
			}
		}
		if (e.getSource() == button2) {
			whichTheme = 2;
			button2.setEnabled(false);
			if (isSold1) {
				button1.setEnabled(true);
			}
			if (isSold3) {
				button3.setEnabled(true);
			}
		}
		if (e.getSource() == button3) {
			whichTheme = 3;
			button3.setEnabled(false);
			if (isSold1) {
				button1.setEnabled(true);
			}
			if (isSold2) {
				button2.setEnabled(true);
			}
		}
		if (e.getSource() == button4) {
			Main.setMoney(money - themePrice1);
			button4.setEnabled(false);
			button1.setEnabled(true);
			isSold1 = true;
			
			String[] newThemes = new String[themes.length+1];
			for (int i=0; i<themes.length; i++) {
				newThemes[i] = themes[i];
			}
			
			newThemes[themes.length] = "1";
			
			Main.setThemes(newThemes);
		}
		if (e.getSource() == button5) {
			Main.setMoney(money - themePrice2);
			button5.setEnabled(false);
			button2.setEnabled(true);
			isSold2 = true;
			
			String[] newThemes = new String[themes.length+1];
			for (int i=0; i<themes.length; i++) {
				newThemes[i] = themes[i];
			}
			
			newThemes[themes.length] = "2";
			
			Main.setThemes(newThemes);
		}
		if (e.getSource() == button6) {
			Main.setMoney(money - themePrice3);
			button6.setEnabled(false);
			button3.setEnabled(true);
			isSold3 = true;
			
			String[] newThemes = new String[themes.length+1];
			for (int i=0; i<themes.length; i++) {
				newThemes[i] = themes[i];
			}
			
			newThemes[themes.length] = "3";
			
			Main.setThemes(newThemes);
		}
	}

}
