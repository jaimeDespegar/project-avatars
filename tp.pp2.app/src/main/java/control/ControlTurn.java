package control;

import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class ControlTurn extends GameObjectController {
	public ControlTurn(GameObject avatar, Map map, Weapon arma) {
		super(avatar, map, arma);
	}
	
	@Override
	public void girarHaciaDerecha(){
		if(avatar.getOrientation() == Orientation.UP){
			avatar.setOrientation(Orientation.RIGHT);
		}
		if(avatar.getOrientation() == Orientation.DOWN){
			avatar.setOrientation(Orientation.LEFT);
		}
		if(avatar.getOrientation() == Orientation.LEFT){
			avatar.setOrientation(Orientation.UP);
		}
		if(avatar.getOrientation() == Orientation.RIGHT){
			avatar.setOrientation(Orientation.DOWN);
		}
	}
	
	@Override
	public void girarHaciaIzquierda(){
		if(avatar.getOrientation() == Orientation.UP){
			avatar.setOrientation(Orientation.LEFT);
		}
		if(avatar.getOrientation() == Orientation.DOWN){
			avatar.setOrientation(Orientation.RIGHT);
		}
		if(avatar.getOrientation() == Orientation.LEFT){
			avatar.setOrientation(Orientation.DOWN);
		}
		if(avatar.getOrientation() == Orientation.RIGHT){
			avatar.setOrientation(Orientation.UP);
		}
	}	
}
