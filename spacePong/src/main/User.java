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
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
			
			String themes = Arrays.asList(user.getThemes())
								  .stream()
								  .collect(Collectors.joining("-"))
								  .toString();
			
			String output = user.getName() + "," + user.getMaxLevel() + ","
						  + user.getMaxScore() + "," + user.getMoney() + "," 
						  + themes + System.lineSeparator();
			
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
		clearFile();
		
		for (int i=0; i<users.size(); i++) {
			updateUser(users.get(i));
		}
	}
	
	
	public static int checkUserList(String userName) {
		for (int i=0; i<users.size(); i++) {
			if (userName.equals(users.get(i).getName())) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void getOldUserList() {
		ArrayList<String> userListRaw = getUserList();
		User.users = extractUserList(userListRaw);
	}
	
	private static ArrayList<String> getUserList() {
		ArrayList<String> users = new ArrayList<String>(); 
		
		try {
			Scanner file = new Scanner(Paths.get("spacePong//txtFiles//gameData.txt"));
			
			while (file.hasNextLine()) {
				users.add(file.nextLine());
			}
			
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	private static ArrayList<User> extractUserList(ArrayList<String> userList) {
		ArrayList<User> usersEdited = new ArrayList<User>();

		for (int i=0; i<userList.size(); i++) {
			String[] userInfo = userList.get(i).split(",");

			User user = new User(userInfo[0],
					Integer.parseInt(userInfo[1]),
					Integer.parseInt(userInfo[2]),
					Integer.parseInt(userInfo[3]),
					userInfo[4].split("-"));
			
			usersEdited.add(user);
		}
		
		return usersEdited;
	}

	public void updateThemes(String theme) {
		String[] newThemes = new String[themes.length+1];
		
		for (int i=0; i<themes.length; i++) {
			newThemes[i] = themes[i];
		}
		
		newThemes[themes.length] = theme;
		
		this.themes = newThemes.clone();
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
