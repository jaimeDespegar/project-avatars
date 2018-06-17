package control;

import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class ControlTurn extends GameObjectController {
	
	public ControlTurn(GameObject avatar, Map map, Weapon arma) {
		super(avatar, map, arma);
	}
	
	
	public void girarHaciaDerecha() {
		Orientation orientationRight = avatar.getOrientation().getRight();
		avatar.setOrientation(orientationRight);
	}
	
	
	public void girarHaciaIzquierda() {
		Orientation orientationRight = avatar.getOrientation().getLeft();
		avatar.setOrientation(orientationRight);		
	}	
}
