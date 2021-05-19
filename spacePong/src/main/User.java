package main;

import java.util.ArrayList;

public class User {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private String[] themes;
	private String name;
	private int maxLevel;
	private int maxScore;
	private int money;
	
	public User(String name, int maxLevel, 
			int maxScore, int money, String[] themes) {
		
		this.name = name;
		this.maxLevel = maxLevel;
		this.maxScore = maxScore;
		this.money = money;
		this.themes = themes;
	}
	
	
	public static boolean checkUserList() {
		return false;
	}
	
	private static String[] getUserList() {
		return new String[2];
	}
	
	private static User[] extractUserList() {
		return new User[2];
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public String[] getThemes() {
		return themes;
	}

	public String getName() {
		return name;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public int getMoney() {
		return money;
	}

	public static void setUsers(ArrayList<User> users) {
		User.users = users;
	}

	public void setThemes(String[] themes) {
		this.themes = themes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
