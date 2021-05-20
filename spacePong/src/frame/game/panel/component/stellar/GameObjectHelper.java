package frame.game.panel.component.stellar;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import frame.game.panel.GamePanel;

public class GameObjectHelper {
	
	private static GameObject intersectedObject;
	
	public static boolean intersects(GameObject o1, GameObject o2) {
		o1.updateRectangle();
		o2.updateRectangle();
		
		if (o1.getRectangle().intersects(o2.getRectangle())) {
			Rectangle intersection = o1.getRectangle().intersection(o2.getRectangle());
			
			for (int i=0; i<intersection.width; i++) {
				for (int j=0; j<intersection.height; j++) {
					int pixel1 = o1.getBuffImage().getRGB(i, j);
					int pixel2 = o2.getBuffImage().getRGB(i, j);
					
					if ((pixel1>>24 != 0x00) && (pixel2>>24 != 0x00)) {
						return true;
					}
				}
			}
			
			return false;
		} else {
			return false;
		}
	}
	
	public static boolean paddleIntersects(Rectangle paddle, GameObject object) {
		if (object.getRectangle().intersects(paddle)) {
			Rectangle intersection = object.getRectangle().intersection(paddle);
			
			for (int i=0; i<intersection.width; i++) {
				for (int j=0; j<intersection.height; j++) {
					int pixel = object.getBuffImage().getRGB(i, j);
					
					if (pixel>>24 != 0x00) {
						return true;
					}
				}
			}
			
			return false;
		} else {
			return false;
		}
	}
	
	public static boolean intersectsAny(Ball ball, ArrayList<GameObject> gameObjects) {
		for (int i=0; i<gameObjects.size(); i++) {
			if (intersects(ball, gameObjects.get(i))) {
				setIntersectedObject(gameObjects.get(i));
				return true;
			}
		}
		
		return false;
	}
	
	public static ArrayList<GameObject> generateObjects(GamePanel panel){
		ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
		
		Cloud cloud = new Cloud(panel);
		Meteor meteor = new Meteor(panel);
		Money money = new Money(panel);
		Poison poison = new Poison(panel);
		Star star = new Star(panel);
		SurpriseBox surpriseBox = new SurpriseBox(panel);
		Ufo ufo = new Ufo(panel);
		
		gameObjects = controlLocation(gameObjects, cloud);
		gameObjects = controlLocation(gameObjects, meteor);
		gameObjects = controlLocation(gameObjects, money);
		gameObjects = controlLocation(gameObjects, poison);
		gameObjects = controlLocation(gameObjects, star);
		gameObjects = controlLocation(gameObjects, surpriseBox);
		gameObjects = controlLocation(gameObjects, ufo);
		
		return gameObjects;
	}
	
	private static ArrayList<GameObject> controlLocation(
			ArrayList<GameObject> objects, GameObject object){
		
		boolean isValidLoc = false;
		
		do {
			Random r = new Random();
			int xLoc = r.nextInt(1024-object.getWidth()+1);
			int yLoc = r.nextInt(470-object.getHeight()+1);
			object.setPositionX(xLoc);
			object.setPositionY(yLoc);
			
			isValidLoc = true;

			for (int i=0; i<objects.size(); i++) {
				if (intersects(object, objects.get(i))) {
					isValidLoc = false;
					break;
				}
			}
			
		} while (!isValidLoc);
		
		objects.add(object);
		
		return objects;
	}
	
	public static ArrayList<GameObject> newObject(ArrayList<GameObject> objects, 
			ObjectMode mode, GamePanel panel){
		
		GameObject object = null;
		
		switch (mode) {
		case BALL:
			object = new Ball(panel);
			break;
		case CLOUD:
			object = new Cloud(panel);
			break;
		case METEOR:
			object = new Meteor(panel);
			break;
		case MONEY:
			object = new Money(panel);
			break;
		case POISON:
			object = new Poison(panel);
			break;
		case STAR:
			object = new Star(panel);
			break;
		case SURPRISEBOX:
			object = new SurpriseBox(panel);
			break;
		case UFO:
			object = new Ufo(panel);
			break;
		}
		
		objects = controlLocation(objects, object);
		
		return objects;
	}
	
	public static void actionIntersectedObject(GameObject gameObject) {
		gameObject.action();
	}
	
	public static void resetIntersectedObject() {
		GameObjectHelper.intersectedObject =  null;
	}

	public static GameObject getIntersectedObject() {
		return intersectedObject;
	}

	public static void setIntersectedObject(GameObject intersectedObject) {
		GameObjectHelper.intersectedObject = intersectedObject;
	}
	
}
