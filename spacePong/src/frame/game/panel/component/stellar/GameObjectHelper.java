package frame.game.panel.component.stellar;

import java.awt.Rectangle;
import java.util.ArrayList;

public class GameObjectHelper {
	
	private static GameObject intersectedObject;
	
	public static boolean intersects(GameObject o1, GameObject o2) {
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
