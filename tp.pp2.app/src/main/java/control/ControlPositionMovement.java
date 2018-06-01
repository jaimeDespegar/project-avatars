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
	
	@Override
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
	
	@Override
	public void retroceder(Point positionAvatar){
		if((avatar.getOrientation() == Orientation.UP) && (isFreePreviousPositionUp(positionAvatar))){ //avanzar arriba
			map.addBoxGameObject(previousPointUp, avatar);
			avatar.setPosition(previousPointUp);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.DOWN) && (isFreePreviousPositionDown(positionAvatar))){ //avanzar abajo
			map.addBoxGameObject(previousPointDown, avatar);
			avatar.setPosition(previousPointDown);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.LEFT) && (isFreePreviousPositionLeft(positionAvatar))){ //avanzar izquierda
			map.addBoxGameObject(previousPointLeft, avatar);
			avatar.setPosition(previousPointLeft);
			map.deleteBox(positionAvatar);
		}
		else if((avatar.getOrientation() == Orientation.RIGHT) && (isFreePreviousPositionRight(positionAvatar))){ //avanzar derecha
			map.addBoxGameObject(previousPointRight, avatar);
			
			map.deleteBox(positionAvatar);
			avatar.setPosition(previousPointRight);
		}
		else{
			//previousPointUp= positionAvatar;
			avatar.setPosition(positionAvatar);
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
}
