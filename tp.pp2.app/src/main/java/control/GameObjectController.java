package control;

import java.awt.Point;

import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class GameObjectController {
	protected GameObject avatar;
	protected Map map;
	protected Weapon arma;
	private Point nextPointUp=null;
	private Point previousPointUp= null;
	private Point nextPointDown= null;
	private Point previousPointDown= null;
	private Point nextPointLeft= null;
	private Point previousPointLeft= null;
	private Point nextPointRight= null;
	private Point previousPointRight= null;
	
	
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
	
	//ASIGNAR POSICION LIBRE
	public Point asignarPrimerPosicionLibre(Map map){
		Point p= null;
		for (int x = 0; x < map.getBoard().getBoxes().length; x++) {
			for (int y = 0; y < map.getBoard().getBoxes()[0].length; y++) {
				if(map.getBoard().getBoxes()[x][y] == null) {
					p= new Point(x,y);
					return p;
				}
			}	
		}
		return p;
	}
	
	public Point asignarUltimaPosicionLibre(Map map){
		Point p= null;
		return p;
	}
	
	public void avanzar(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreeNextPositionUp(positionAvatar))){ //avanzar arriba
			map.addBox(nextPointUp, avatar);
			avatar.setPosition(nextPointUp);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.DOWN) && (isFreeNextPositionDown(positionAvatar))){ //avanzar abajo
			map.addBox(nextPointDown, avatar);
			avatar.setPosition(nextPointDown);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.LEFT) && (isFreeNextPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBox(nextPointLeft, avatar);
			avatar.setPosition(nextPointLeft);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.RIGHT) && (isFreeNextPositionRight(positionAvatar))){ //avanzar derecha
			map.addBox(nextPointRight, avatar);
			avatar.setPosition(nextPointRight);
			map.deleteBox(positionAvatar);
		}
		nextPointUp= positionAvatar;
		avatar.setPosition(nextPointRight);
	}
	
	public void retroceder(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreePreviousPositionUp(positionAvatar))){ //avanzar arriba
			map.addBox(previousPointUp, avatar);
			avatar.setPosition(previousPointUp);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.DOWN) && (isFreePreviousPositionDown(positionAvatar))){ //avanzar abajo
			map.addBox(previousPointDown, avatar);
			avatar.setPosition(previousPointDown);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.LEFT) && (isFreePreviousPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBox(previousPointLeft, avatar);
			avatar.setPosition(previousPointLeft);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.RIGHT) && (isFreePreviousPositionRight(positionAvatar))){ //avanzar derecha
			map.addBox(previousPointRight, avatar);
			
			map.deleteBox(positionAvatar);
			avatar.setPosition(previousPointRight);
		}
		previousPointUp= positionAvatar;
		avatar.setPosition(previousPointRight);
	}
	
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
	
	
	
	//VALIDACIONES DE AVANCE Y RETROCESO DEL AVATAR
	public boolean isFreeNextPositionUp(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointUp= new Point(positionAvatar.x, positionAvatar.y -1);
		//nextPointUp= new Point(positionAvatar.y -1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(nextPointUp);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionUp(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointUp= new Point(positionAvatar.x, positionAvatar.y +1);
		//previousPointUp= new Point(positionAvatar.y +1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(previousPointUp);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointDown= new Point(positionAvatar.x, positionAvatar.y +1);
		//nextPointDown= new Point(positionAvatar.y +1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(nextPointDown);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointDown= new Point(positionAvatar.x, positionAvatar.y -1);
		//previousPointDown= new Point(positionAvatar.y -1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(previousPointDown);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointLeft= new Point(positionAvatar.x -1, positionAvatar.y);
		//nextPointLeft= new Point(positionAvatar.y, positionAvatar.x -1);
		isOcupate= map.getBoard().isOcupatePosition(nextPointLeft);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointLeft= new Point(positionAvatar.x +1, positionAvatar.y);
		//previousPointLeft= new Point(positionAvatar.y, positionAvatar.x +1);
		isOcupate= map.getBoard().isOcupatePosition(previousPointLeft);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointRight= new Point(positionAvatar.x +1, positionAvatar.y);
		//nextPointRight= new Point(positionAvatar.y, positionAvatar.x +1);
		isOcupate= map.getBoard().isOcupatePosition(nextPointRight);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointRight= new Point(positionAvatar.x -1, positionAvatar.y);
		//previousPointRight= new Point(positionAvatar.y, positionAvatar.x -1);
//		if (positionExist()){
//			
//		}
		isOcupate= map.getBoard().isOcupatePosition(previousPointRight);
		isFree = !isOcupate;
		return isFree;
	}

	
	
}