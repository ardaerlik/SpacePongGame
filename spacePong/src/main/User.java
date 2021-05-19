package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
	
	private static void updateUser(User user) {
		try {
			Path path = Paths.get("spacePong//txtFiles//gameData.txt");
			
			String themes = "";
			for (int i=0; i<user.getThemes().length; i++) {
				themes += user.getThemes()[i] + ",";
			}
			
			String output = user.getName() + "|" + user.getMaxLevel() + "|"
						  + user.getMaxScore() + "|" + user.getMoney() 
						  + themes;
			
			Files.write(path, output.getBytes(), StandardOpenOption.APPEND);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void clearFile() {
		try {
			PrintWriter pw = new PrintWriter(new File("spacePong//txtFiles//gameData.txt"));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateAllUsers(ArrayList<User> users) {
		for (int i=0; i<users.size(); i++) {
			updateUser(users.get(i));
		}
	}
	
	
	public static boolean checkUserList(String userName) {
		String[] userListRaw = getUserList();
		User[] userListEdited = extractUserList(userListRaw);
		
		
		return false;
	}
	
	private static String[] getUserList() {
		return new String[2];
	}
	
	private static User[] extractUserList(String[] userList) {
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
