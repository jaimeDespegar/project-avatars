package control;

import java.awt.Point;
//import javax.swing.JOptionPane;
import object.GameObject;
import object.Weapon;
import tablero.Map;
import enums.Orientation;

public class WeaponController {
	protected GameObject avatar;
	protected Map map;
	protected Weapon arma;
	
	private Point nextPointUp=null;
	private Point nextPointDown= null;
	private Point nextPointLeft= null;
	private Point nextPointRight= null;
	
	public WeaponController(GameObject avatar, Map map, Weapon arma) {
		this.avatar= avatar;
		this.map= map;
		this.arma= arma;
		
		arma.setPosition(avatar.getPosition());
		arma.setOrientation(avatar.getOrientation());
	}
	
	public Point avanzarRangoDisparo(Point positionWeapon){
		if((arma.getOrientation() == Orientation.UP)){ //avanzar arriba
			arma.setPosition(nextPointUp);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) ){ //avanzar abajo
			arma.setPosition(nextPointDown);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) ){ //avanzar izquierda
			arma.setPosition(nextPointLeft);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT)){ //avanzar derecha
			arma.setPosition(nextPointRight);
		}
		return arma.getPosition();
	}
	public void avanzar(Point positionWeapon){
		if((arma.getOrientation() == Orientation.UP) && (isFreeNextPositionUp(positionWeapon))){ //avanzar arriba
			arma.setPosition(nextPointUp);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) && (isFreeNextPositionDown(positionWeapon))){ //avanzar abajo
			arma.setPosition(nextPointDown);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) && (isFreeNextPositionLeft(positionWeapon))){ //avanzar izquierda
			arma.setPosition(nextPointLeft);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT) && (isFreeNextPositionRight(positionWeapon))){ //avanzar derecha
			arma.setPosition(nextPointRight);
		}
		else{
			nextPointUp= positionWeapon;
			arma.setPosition(positionWeapon);
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
	public boolean isFreeNextPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		nextPointRight= new Point(positionAvatar.x +1, positionAvatar.y);
		//nextPointRight= new Point(positionAvatar.y, positionAvatar.x +1);
		if (isPositionValid(nextPointRight)){
			isOcupate= map.getBoard().isOcupatePosition(nextPointRight);
			//isOcupate= map.getBoxGameObject(new Point(2,0)).equals(null);
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
		
	}
	
}
