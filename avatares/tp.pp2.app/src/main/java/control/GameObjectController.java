package control; 

import java.awt.Point;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class GameObjectController {
	protected GameObject avatar;
	protected Map map;
	protected Weapon arma;
	protected Point nextPointUp=null;
	protected Point previousPointUp= null;
	protected Point nextPointDown= null;
	protected Point previousPointDown= null;
	protected Point nextPointLeft= null;
	protected Point previousPointLeft= null;
	protected Point nextPointRight= null;
	protected Point previousPointRight= null;
	protected Point puntoChoque=null;
	
	public GameObjectController(GameObject avatar, Map map, Weapon arma) {
		this.avatar= avatar;
		this.map= map;
		this.arma= arma;
	}
	//GETTER & SETTER
	public GameObject getAvatar() {
		return avatar;
	}

	public void setAvatar(GameObject avatar) {
		this.avatar = avatar;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Weapon getArma() {
		return arma;
	}

	public void setArma(Weapon arma) {
		this.arma = arma;
	}
}