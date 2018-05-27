package control;

import object.GameObject;
import object.Weapon;
import tablero.Map;

public class GameObjectController {
	protected GameObject avatar;
	protected Map map;
	protected Weapon arma;
	
	
	
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
	
	
	//AVANZAR
	public void avanzarGameObject(){
		
	}
	
	
	//GIRAR
	public void girarGameObject(){
		
	}
	
	
	
}
