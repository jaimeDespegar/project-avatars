package control;

import java.awt.Point;

import javax.swing.JOptionPane;

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
	private Point puntoChoque=null;
	
	public GameObjectController(GameObject avatar, Map map, Weapon arma) {
		this.avatar= avatar;
		this.map= map;
		this.arma= arma;
	}


	private void controlLive() {
		if( this.avatar.getVida() <=0 ){
			 JOptionPane.showMessageDialog(null, "GAME OVER !");
		}
	}
	private void controlLiveInConsole() {
		if( this.avatar.getVida() <=0 ){
			 System.out.println("GAME OVER!");
		}
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
		for (int x = map.getBoard().getBoxes().length -1; x >= 0 ; x--) {
			for (int y = map.getBoard().getBoxes()[0].length -1; y >= 0 ; y--) {
				if(map.getBoard().getBoxes()[x][y] == null) {
					p= new Point(x,y);
					return p;
				}
			}	
		}
		return p;
	}
	
	public void avanzar(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreeNextPositionUp(positionAvatar))){ //avanzar arriba
			map.addBoxGameObject(nextPointUp, avatar);
			avatar.setPosition(nextPointUp);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) && (isFreeNextPositionDown(positionAvatar))){ //avanzar abajo
			map.addBoxGameObject(nextPointDown, avatar);
			avatar.setPosition(nextPointDown);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) && (isFreeNextPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBoxGameObject(nextPointLeft, avatar);
			avatar.setPosition(nextPointLeft);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT) && (isFreeNextPositionRight(positionAvatar))){ //avanzar derecha
			map.addBoxGameObject(nextPointRight, avatar);
			avatar.setPosition(nextPointRight);
			map.deleteBox(positionAvatar);
		}
		else{
			nextPointUp= positionAvatar;
			avatar.setPosition(positionAvatar);
		}
		
	}
	
	public void retroceder(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreePreviousPositionUp(positionAvatar))){ //avanzar arriba
			map.addBoxGameObject(previousPointUp, avatar);
			avatar.setPosition(previousPointUp);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.DOWN) && (isFreePreviousPositionDown(positionAvatar))){ //avanzar abajo
			map.addBoxGameObject(previousPointDown, avatar);
			avatar.setPosition(previousPointDown);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.LEFT) && (isFreePreviousPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBoxGameObject(previousPointLeft, avatar);
			avatar.setPosition(previousPointLeft);
			map.deleteBox(positionAvatar);
		}
		if((avatar.getOrientation() == Orientation.RIGHT) && (isFreePreviousPositionRight(positionAvatar))){ //avanzar derecha
			map.addBoxGameObject(previousPointRight, avatar);
			
			map.deleteBox(positionAvatar);
			avatar.setPosition(previousPointRight);
		}
		previousPointUp= positionAvatar;
		avatar.setPosition(positionAvatar);
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
		if (isPositionValid(nextPointUp)){
			isOcupate= map.getBoard().isOcupatePosition(nextPointUp);
			isFree = !isOcupate;
		}
		return isFree;
	}
	public boolean isFreePreviousPositionUp(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointUp= new Point(positionAvatar.x, positionAvatar.y +1);
		//previousPointUp= new Point(positionAvatar.y +1, positionAvatar.x);
		if (isPositionValid(previousPointUp)){
			isOcupate= map.getBoard().isOcupatePosition(previousPointUp);
			isFree = !isOcupate;
		}
		return isFree;
	}
	
	public boolean isFreeNextPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointDown= new Point(positionAvatar.x, positionAvatar.y +1);
		//nextPointDown= new Point(positionAvatar.y +1, positionAvatar.x);
		if (isPositionValid(nextPointDown)){
			isOcupate= map.getBoard().isOcupatePosition(nextPointDown);
			isFree = !isOcupate;
		}
		return isFree;
	}
	public boolean isFreePreviousPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointDown= new Point(positionAvatar.x, positionAvatar.y -1);
		//previousPointDown= new Point(positionAvatar.y -1, positionAvatar.x);
		if (isPositionValid(previousPointDown)){
			isOcupate= map.getBoard().isOcupatePosition(previousPointDown);
			isFree = !isOcupate;
		}
		return isFree;
	}
	
	public boolean isFreeNextPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointLeft= new Point(positionAvatar.x -1, positionAvatar.y);
		//nextPointLeft= new Point(positionAvatar.y, positionAvatar.x -1);
		if (isPositionValid(nextPointLeft)){
			isOcupate= map.getBoard().isOcupatePosition(nextPointLeft);
			isFree = !isOcupate;
		}
		return isFree;
	}
	public boolean isFreePreviousPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointLeft= new Point(positionAvatar.x +1, positionAvatar.y);
		//previousPointLeft= new Point(positionAvatar.y, positionAvatar.x +1);
		if (isPositionValid(previousPointLeft)){
			isOcupate= map.getBoard().isOcupatePosition(previousPointLeft);
			isFree = !isOcupate;
		}
		return isFree;
	}
	
	public boolean isFreeNextPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointRight= new Point(positionAvatar.x +1, positionAvatar.y);
		//nextPointRight= new Point(positionAvatar.y, positionAvatar.x +1);
		if (isPositionValid(nextPointRight)){
			isOcupate= map.getBoard().isOcupatePosition(nextPointRight);
			isFree = !isOcupate;
		}	
		return isFree;
	}
	public boolean isFreePreviousPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		previousPointRight= new Point(positionAvatar.x -1, positionAvatar.y);
		//previousPointRight= new Point(positionAvatar.y, positionAvatar.x -1);
		if (isPositionValid(previousPointRight)){
			isOcupate= map.getBoard().isOcupatePosition(previousPointRight);
			isFree = !isOcupate;
		}
		
		return isFree;
	}

	public boolean isPositionValid(Point p){
		Point limit= new Point(map.getLimitsBoard().x, map.getLimitsBoard().y);
		if((p.x <0) || (p.x >= limit.x)){
			return false;}
		if((p.y <0) || (p.y >= limit.y)){
			return false;}
		return true;
	}
	
	public void colissionWeapon(GameObject g, Weapon w){
		int finalDamage= w.getDamage() / g.getReduceDamage();
		w.setActive(false);
		g.setVida(g.getVida() - finalDamage);
		
		//controlLive();
		controlLiveInConsole();
	}
	
	public Integer disparar(GameObject g){
		int cantShootingRange=0;
		WeaponController w= new WeaponController(avatar, map, arma);
		arma.setOrientation(avatar.getOrientation());
		Point old;
		for(int i=0; i < arma.getShootingRange(); i++ ){
			old= arma.getPosition();
			w.avanzar(arma.getPosition());
			if(old.equals(arma.getPosition())){
				puntoChoque= controlColissionPoint(arma, cantShootingRange, w);
				controlChoqueConEnemy(puntoChoque, g);
				return cantShootingRange;
			}
			cantShootingRange= cantShootingRange+1;
		}
		
		return cantShootingRange;
	}
	
	private void controlChoqueConEnemy(Point puntoChoque2, GameObject g) {
		if(puntoChoque2.equals(g.getPosition())){
			colissionWeapon(g, arma);
		}
		
	}


	private Point controlColissionPoint(Weapon arma, int cantShootingRange, WeaponController w) {
		Point p= null;
		for(int i=0; i < cantShootingRange+1; i++ ){
			p= w.avanzarRangoDisparo(arma.getPosition());
		}
		return p;
	}


	public boolean isWeaponrecorridaCompleta(Integer cantShootingRange){
		return (arma.getShootingRange().equals(cantShootingRange));
	}
	
	public boolean isColission(Integer cantShootingRange){
		boolean i= isWeaponrecorridaCompleta(cantShootingRange);
		boolean r= !i;
		return r;
	}
}