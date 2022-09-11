# Space Pong Game

![GitHub repo size](https://img.shields.io/github/repo-size/ardaerlik/SpacePongGame?style=plastic)
![GitHub](https://img.shields.io/github/license/ardaerlik/SpacePongGame?style=plastic)
![Website](https://img.shields.io/website?down_message=offline&style=plastic&up_message=online&url=https%3A%2F%2Fardaerlik.com)

![GitHub commit activity](https://img.shields.io/github/commit-activity/y/ardaerlik/SpacePongGame?style=plastic)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/ardaerlik/SpacePongGame?style=plastic)
![Lines of code](https://img.shields.io/tokei/lines/github/ardaerlik/SpacePongGame?style=plastic)
![GitHub top language](https://img.shields.io/github/languages/top/ardaerlik/SpacePongGame?style=plastic)

## Project Overview
Created by: [Arda Erlik](https://github.com/ardaerlik) (0076108)

Date: 21.05.2021

    About: This project is prepared for COMP132 term homework.

    Various implementations have been made in order to reinforce the gains obtained from various lectures covered during the period.

Link to my Discussing Forum thread: [Blackboard (1)](https://ku.blackboard.com/webapps/discussionboard/do/message?action=list_messages&course_id=_39693_1&nav=discussion_board_entry&conf_id=_49503_1&forum_id=_16476_1&message_id=_84251_1)  && [Blackboard (2)](https://ku.blackboard.com/webapps/discussionboard/do/message?action=list_messages&course_id=_39693_1&nav=discussion_board_entry&conf_id=_49503_1&forum_id=_16476_1&message_id=_86677_1)

| Topic| Where was I used|
|------|----:|
|Inheritance| All Project|
|Abstract Classes| GameObject.java|
|Polymorphism| GamPanel.java|
|Exception Handling| User.java|
|String and Regex| User.java|
|Files and IO Streams| User.java|
|Generic Collections|User.java|
|Lambdas and Streams|User.java|
|Java Swing|All Project|
|Java ActionListener*|All Project|
|Multithreading|Main.java|


---
## How To Run The Game
    The game can be run from the main class in the main package. This is the only main method in the project. All JFrames are run from this class.

```bash
# In the Default Package
cd ./Main
java Main
```

```java
public static void main(String[] args) throws InterruptedException {
		userName = "PlayerDEMO";
		User.getOldUserList();
		setMoneyAndTheme();
		
		whichTheme = 1;
		
		progressFrame = new ProgressFrame();
		progressFrame.setVisible(true);
		progressFrame.getMainPanel().startTimer();
		currentFrame = progressFrame;
		
		Thread.sleep(6700);
		
		homePage();
	}
```

---
## Improvements and Changes on Game
* **Home Page**
    * *Theme Selection*[1]*
        * Default (Vivid)
        * Old
        * Dark
    * *Buying different themes with game money(scores)*
        * $50 for default
        * $150 for old
        * $250 for dark
    * *Settings*
        * Username field
        * Save button
        * Reset button
    * *Statistics*
        * Score Rank
        * Level Rank
    * *Start game*
* **Different Game Objects**
    * *Cloud*
    * *Money*
    * *Poison*
    * *Surprise Box*
* **Realistic Physical Graphics**
    * *Ball Velocity*[2]*
    * *Paddle Velocity*[3]*
    * *Paddle Force*[4]*
    * *Object Colliders*[5]*
    * *Some objects have some motion properties*
* **Multiplayer option**
    * *Statistics is available*
    * *Data is stored in txtFiles/gameData.txt*
* **More Eye-Catching Stopwatch Graphics**
    * *Animation that changes color of stopwatch when game time decreases*
    * *Circle graphic for realistic timer*
* **Progress Pages**
    * *Progress page has appears while routing between diffent frames*
    * *Progress bar is made with Java Swing Timer and Thread class*
    * *For more realistic software design*
    * *Stays between 5 to 6 seconds*
* **Game Help Button**
    * *Object actions are described here*

[1] -> Inspired by [Ameer Taweel's](https://ku.blackboard.com/webapps/discussionboard/do/message?action=list_messages&course_id=_39693_1&nav=discussion_board_entry&conf_id=_49503_1&forum_id=_16476_1&message_id=_83558_1) theme colors.

[2] -> 
    
    velocityY = 2;
    velocityX = 4.5;
    ACCELERATION = 0.25f;
    positionX = 10;
    positionY = 60;
    WIDTH = 30;
    HEIGHT = 30;

    When new level, it's speed incremented by 20% for more physical game experience.

    speedLimit() method restrics ball's speed to more than 17px (in Y axis), and more than 7px (in X axis)


[3] ->

    Instance variables of paddle

```java
private ArrayList<PressedKey> pressedKeys;
public enum PressedKey {LEFT, RIGHT};
private final int PADDLE_WIDTH = 120;
private final int PADDLE_HEIGHT = 10;
private final int paddlePositionY = 470;
private int paddlePositionX = 100;
private int paddleVelocity = 6;
private int pressedKeysLoc;
private int pressedKeysLocInt;
private boolean isFreezed;
```

    Paddle's useful methods

```java
public void freezePaddle() {
		isFreezed = true;
		startTime = System.currentTimeMillis();
}

public void runPaddle() {
		isFreezed = false;
	}
	
	public void resetPaddle() {
		paddlePositionX = 100;
	}
	
	private void smoothPaddle(Graphics g) {
		if (pressedKeysLoc < pressedKeys.size()) {
			
			if (pressedKeysLocInt == 0) {
				isValid = isValidPosition(pressedKeys.get(pressedKeysLoc));
			}
			
			if (isValid) {
				if (pressedKeysLocInt < 5) {
					if (pressedKeys.get(pressedKeysLoc) == PressedKey.LEFT){
						paddlePositionX -= paddleVelocity;
					} else {
						paddlePositionX += paddleVelocity;
					}
					pressedKeysLocInt++;
				} else {
					pressedKeysLoc++;
					pressedKeysLocInt = 0;
				}
			}
			else {
				pressedKeysLoc++;
			}
		}

		g.setColor(Color.BLACK);
		g.fillRect(paddlePositionX, paddlePositionY, PADDLE_WIDTH, PADDLE_HEIGHT);
		
		paddle = new Rectangle(paddlePositionX, paddlePositionY, 
				PADDLE_WIDTH, PADDLE_HEIGHT);
	}
```

    freezePaddle() is used for freezing paddle for 1500mS.
    It is poison's action for game scenario.

    smoothPaddle() is used for more smooth paddle usage.
    It stores keyboard actions in ArrayList and processes it with cutting to pieces.

    One keyboard action = 6 X 5 px
    6px in 20mS

[4] -> 

    Paddle Force

```java
private void paddleForce() {
		if (GameObjectHelper.paddleIntersects(panel.getPaddle(), this)) {
			int paddlePositionX = panel.getPaddlePosition()[0];
			
			int oldScore = Integer.parseInt(panel.getTopPanel()
					  .getScorePanel()
					  .getScore());
			
			panel.getTopPanel()
			 .getScorePanel()
			 .setScore((oldScore+5)+"");
			
			velocityY = -velocityY+1;
			velocityX += (positionX + width/2 - (paddlePositionX + panel.getPaddle().width/2))/10;
		}
	}
```

    This method works with momentum laws in physics and paddle applies different forces (in different directions and different magnitudes) from its parts to ball.

[5] -> Inspired by [Ameer Taweel's](https://ku.blackboard.com/webapps/discussionboard/do/message?action=list_messages&course_id=_39693_1&nav=discussion_board_entry&conf_id=_49503_1&forum_id=_16476_1&message_id=_85979_1) algorithm for collision detector for png images.

---
## For Further Updates
* **Sound System**
    * *Different soundtrack in different scenarios*
* **Gift Hunt**
    * *Some parts have implemented*
    * *One of three different boxes will be selected, different types of rewards or penalties can be received*
    * *For now, surprise box is only an object with image*

---
## Class Informations
### Class and Package Hierarchy

* src
    * frame
        * animate
            * panel
                * LabelPanel.java
                * MainPanel.java
            * ProgressFrame.java
        * game
            * panel
                * component
                    * button
                        * ExitButton.java
                        * HelpButton.java
                        * PauseButton.java
                    * dynamic
                        * LevelPanel.java
                        * ScorePanel.java
                        * TimerPanel.java
                    * stellar
                        * Ball.java
                        * Cloud.java
                        * GameObject.java
                        * GameObjectHelper.java
                        * Meteor.java
                        * Money.java
                        * ObjectMode.java
                        * Poison.java
                        * Star.java
                        * SurpriseBox.java
                        * Ufo.java
                * BelowPanel.java
                * GamePanel.java
                * TopPanel.java
                * Mode.java
            * GameAnimations.java
            * GameFrame.java
            * GameTheme.java
            * HelpFrame.java
        * home
            * panel
                * component
                    * button
                        * CreditsButton.java
                        * ReturnHomeButton.java
                        * SettingsButton.java
                        * StartButton.java
                        * Statistics.java
                * ButtonsPanel.java
                * CreditsButtonsPanel.java
                * CreditsPanel.java
                * SettingsPanel.java
                * StartPanel.java
                * StatisticsPanel.java
                * ThemePanel.java
            * CreditsFrame.java
            * HomeFrame.java
            * SettingsFrame.java
            * StatisticsFrame.java
    * main
        * Main.java
        * User.java
* assets
    * images
        * gameButtons
        * gameIcons
        * gameObjects
    * sounds
* txtFiles
    * gameData.txt
    * LICENSE.txt
* bin

### Game Objects
-> GameObject (Abstract class)

    action() abstract method
    
-> Ball

-> Cloud

    It increments liveCount by 1 if liveCount is less than 3.
    It increments score by 25.

-> Meteor

    It has some specific move in game area.
    It increments ball's velocity by x1.2.

-> Poison

    It freezes the paddle for 1500mS.

-> Star

    It falls out from the gamepanel and other star appears after.
    It increments score by 25.

-> SurpriseBox

-> Ufo

    It is scaling up and down in game frame.
    It reduces liveCount by 1.
    It reduces score by 25.

### Helper Objects

-> GameObjectHelper.java

    It includes collider methods.

-> User.java

    It includes IO methods.


---
## References and Credits

Game Images from [Pixabay](https://pixabay.com/tr/)

---
## License
    MIT License

    Copyright (c) 2021 Arda Erlik

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

---
## Contact With Me:

[Mail me](mailto:aerlik20@ku.edu.tr)

[Github](https://github.com/ardaerlik)

[Linkedin](https://www.linkedin.com/in/ardaerlik/)
