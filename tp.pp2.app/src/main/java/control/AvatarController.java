package control;

import java.awt.Point; 
import java.awt.event.KeyEvent;
import enums.Orientation;
import object.GameObject;
import object.Weapon;
import tablero.Map;



public class AvatarController extends GameObjectController{

	private KeyBoardAvatar keyListener;
	public Point coordenada;
	private Point nextPointUp=null;
	private Point previousPointUp= null;
	private Point nextPointDown= null;
	private Point previousPointDown= null;
	private Point nextPointLeft= null;
	private Point previousPointLeft= null;
	private Point nextPointRight= null;
	private Point previousPointRight= null;
	
	
	public AvatarController(GameObject avatar, Map map, Weapon arma) 
	{
		super(avatar, map, arma);
		
	}
	
	public void controlAvatar(Point positionAvatar) //Esto se usa cuando se juego continuamente
	{
		Integer keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == KeyEvent.VK_W){
			avanzar(positionAvatar);
		}
		if(keyPressedInNow == KeyEvent.VK_S){
			retroceder(positionAvatar);
		}
		if(keyPressedInNow == KeyEvent.VK_A){
			girarHaciaIzquierda();
		}
		if(keyPressedInNow == KeyEvent.VK_D){
			girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == KeyEvent.VK_SPACE){
			dispararArma();
		}
		if(keyPressedInNow == KeyEvent.VK_C){
			activarPoder1();
		}
		if(keyPressedInNow == KeyEvent.VK_V){
			activarPoder2();
		}

	}
	
	private void activarPoder2() {
		// TODO Auto-generated method stub
		
	}

	private void activarPoder1() {
		// TODO Auto-generated method stub
		
	}

	private void dispararArma() {
		// TODO Auto-generated method stub
		
	}

	private void salir() {
		// TODO Auto-generated method stub
		
	}

	public void disparar(Integer keyPressedInNow) {
		if(keyPressedInNow.equals(KeyEvent.VK_SPACE)){ //Dispara si presiona la barra espaciadora
			if(arma.isActive()){ //REVISO SI AL AVATAR SE LE ASIGNO UN HACHA
				dispararArma();
			}
			
		}	 
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
			avatar.setOrientation(Orientation.UP);
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
		//nextPointUp= new Point(positionAvatar.x, positionAvatar.y -1);
		nextPointUp= new Point(positionAvatar.y -1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(nextPointUp);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionUp(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//previousPointUp= new Point(positionAvatar.x, positionAvatar.y +1);
		previousPointUp= new Point(positionAvatar.y +1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(previousPointUp);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//nextPointDown= new Point(positionAvatar.x, positionAvatar.y +1);
		nextPointDown= new Point(positionAvatar.y +1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(nextPointDown);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionDown(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//previousPointDown= new Point(positionAvatar.x, positionAvatar.y -1);
		previousPointDown= new Point(positionAvatar.y -1, positionAvatar.x);
		isOcupate= map.getBoard().isOcupatePosition(previousPointDown);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//nextPointLeft= new Point(positionAvatar.x -1, positionAvatar.y);
		nextPointLeft= new Point(positionAvatar.y, positionAvatar.x -1);
		isOcupate= map.getBoard().isOcupatePosition(nextPointLeft);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionLeft(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//previousPointLeft= new Point(positionAvatar.x +1, positionAvatar.y);
		previousPointLeft= new Point(positionAvatar.y, positionAvatar.x +1);
		isOcupate= map.getBoard().isOcupatePosition(previousPointLeft);
		isFree = !isOcupate;
		return isFree;
	}
	
	public boolean isFreeNextPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//nextPointRight= new Point(positionAvatar.x +1, positionAvatar.y);
		nextPointRight= new Point(positionAvatar.y, positionAvatar.x +1);
		isOcupate= map.getBoard().isOcupatePosition(nextPointRight);
		isFree = !isOcupate;
		return isFree;
	}
	public boolean isFreePreviousPositionRight(Point positionAvatar) {
		boolean isFree= false;
		boolean isOcupate= false;
		//previousPointRight= new Point(positionAvatar.x -1, positionAvatar.y);
		previousPointRight= new Point(positionAvatar.y, positionAvatar.x -1);
		isOcupate= map.getBoard().isOcupatePosition(previousPointRight);
		isFree = !isOcupate;
		return isFree;
	}

	

}
