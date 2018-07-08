package control;

import java.awt.Point;

import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class ControlPositionMovement extends GameObjectController {
	public ControlPositionMovement(GameObject avatar, Map map, Weapon arma) {
		super(avatar, map, arma);
	}
	
	
	public void avanzar(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreeNextPositionUp(positionAvatar))){ //avanzar arriba
			map.addBox(nextPointUp, avatar);
		//	avatar.setPosition(nextPointUp);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) && (isFreeNextPositionDown(positionAvatar))){ //avanzar abajo
			map.addBox(nextPointDown, avatar);
		//	avatar.setPosition(nextPointDown);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) && (isFreeNextPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBox(nextPointLeft, avatar);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT) && (isFreeNextPositionRight(positionAvatar))){ //avanzar derecha
			map.addBox(nextPointRight, avatar);
			map.deleteBox(positionAvatar);
		}
		else{
			nextPointUp= positionAvatar;
		}
		
	}
	
	//hoihoih
	public void retroceder(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreePreviousPositionUp(positionAvatar))){ //avanzar arriba
			map.addBox(previousPointUp, avatar);
			avatar.setPosition(previousPointUp);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) && (isFreePreviousPositionDown(positionAvatar))){ //avanzar abajo
			map.addBox(previousPointDown, avatar);
			avatar.setPosition(previousPointDown);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) && (isFreePreviousPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBox(previousPointLeft, avatar);
			avatar.setPosition(previousPointLeft);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT) && (isFreePreviousPositionRight(positionAvatar))){ //avanzar derecha
			map.addBox(previousPointRight, avatar);
			map.deleteBox(positionAvatar);
			avatar.setPosition(previousPointRight);
		}
		else{
			avatar.setPosition(positionAvatar);
		}
		
	}
	
	
	//VALIDACIONES DE AVANCE Y RETROCESO DEL AVATAR
		public boolean isFreeNextPositionUp(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			nextPointUp= new Point(positionAvatar.x, positionAvatar.y -1);
			if (isPositionValid(nextPointUp)){
				isOcupate= map.isOcupatePosition(nextPointUp);
				isFree = !isOcupate;
			}
			return isFree;
		}
		public boolean isFreePreviousPositionUp(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			previousPointUp= new Point(positionAvatar.x, positionAvatar.y +1);
			if (isPositionValid(previousPointUp)){
				isOcupate= map.isOcupatePosition(previousPointUp);
				isFree = !isOcupate;
			}
			return isFree;
		}
		
		public boolean isFreeNextPositionDown(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			nextPointDown= new Point(positionAvatar.x, positionAvatar.y +1);
			if (isPositionValid(nextPointDown)){
				isOcupate= map.isOcupatePosition(nextPointDown);
				isFree = !isOcupate;
			}
			return isFree;
		}
		public boolean isFreePreviousPositionDown(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			previousPointDown= new Point(positionAvatar.x, positionAvatar.y -1);
			if (isPositionValid(previousPointDown)){
				isOcupate= map.isOcupatePosition(previousPointDown);
				isFree = !isOcupate;
			}
			return isFree;
		}
		
		public boolean isFreeNextPositionLeft(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			nextPointLeft= new Point(positionAvatar.x -1, positionAvatar.y);

			if (isPositionValid(nextPointLeft)){
				isOcupate= map.isOcupatePosition(nextPointLeft);
				isFree = !isOcupate;
			}
			return isFree;
		}
		public boolean isFreePreviousPositionLeft(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			previousPointLeft= new Point(positionAvatar.x +1, positionAvatar.y);

			if (isPositionValid(previousPointLeft)){
				isOcupate= map.isOcupatePosition(previousPointLeft);
				isFree = !isOcupate;
			}
			return isFree;
		}
		
		public boolean isFreeNextPositionRight(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			nextPointRight= new Point(positionAvatar.x +1, positionAvatar.y);
			
			//System.out.println("nextPointRight: ("+ nextPointRight.x + " ,"+nextPointRight.y + ")");

			if (isPositionValid(nextPointRight)){
				isOcupate= map.isOcupatePosition(nextPointRight);
				isFree = !isOcupate;
			}	
			return isFree;
		}
		public boolean isFreePreviousPositionRight(Point positionAvatar) {
			boolean isFree= false;
			boolean isOcupate= false;
			previousPointRight= new Point(positionAvatar.x -1, positionAvatar.y);
			if (isPositionValid(previousPointRight)){
				isOcupate= map.isOcupatePosition(previousPointRight);
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
}
