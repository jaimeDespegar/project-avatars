package control;

import java.awt.Point;
import java.awt.event.KeyEvent;

import object.Avatar;
import object.Ax;
import object.Bazooka;
import object.GameObject;
import object.Shotgun;
import states.StateMove;
import states.StateMoveDown;
import states.StateMoveLeft;
import states.StateMoveRight;
import states.StateMoveUp;
import tablero.Board;



public class AvatarController extends GameObject{
	private Avatar avatar;
	private KeyBoardAvatar keyListener;
	private FactoryStateMove factory;
	public Point coordenada;
	public Board tablero;
	public Ax hacha;
	public Bazooka bazooka;
	public Shotgun escopeta;
	
	public AvatarController(Avatar avatar, Board tablero, Ax hacha, Bazooka bazooka, Shotgun escopeta) 
	{
		super(avatar.getCoordinate(), avatar.getSize(), avatar.getVida(), avatar.getOrientation());
		this.avatar= avatar;
		this.tablero= tablero;
		this.hacha= hacha;
		this.bazooka= bazooka;
		this.escopeta= escopeta;
	}
	
	public void controlAvatar() 
	{
		Integer keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow != -1) //si se presiona una tecla registrada para el Avatar
		{
			StateMove stateMove = factory.getStateMove(keyPressedInNow);//reviso la tecla presionada
			avanzarAvatar(stateMove); //Avanza o gira o si es una tecla incorrecta no hace nada
			disparar(keyPressedInNow);
		}
	}
	
	public void disparar(Integer keyPressedInNow) {
		if(keyPressedInNow.equals(KeyEvent.VK_SPACE)){ //Dispara si presiona la barra espaciadora
			if(this.hacha != null){ //REVISO SI AL AVATAR SE LE ASIGNO UN HACHA
				dispararHacha();
			}
			if(this.bazooka != null){ //REVISO SI AL AVATAR SE LE ASIGNO UNA BAZOOKA
				dispararBazooka();
			}
			if(this.escopeta != null){ //REVISO SI AL AVATAR SE LE ASIGNO UNA ESCOPETA
				dispararEscopeta();
			}
		}
		 
	}

	private void dispararEscopeta() {
		// TODO Auto-generated method stub
		
	}

	private void dispararBazooka() {
		// TODO Auto-generated method stub
		
	}

	private void dispararHacha() {
		// TODO Auto-generated method stub
		
	}

	public void avanzarAvatar(StateMove stateMove){
		//this.avatar.setStateMove(stateMove);
		if(stateMove.equals(this.avatar.getOrientationAvatar())){//si el avatar avanza cuando se presiona por 2º vez la misma tecla
			if(stateMove.equals(new StateMoveUp())){
				coordenada.x=this.avatar.getCoordinate().x;
				coordenada.y=this.avatar.getCoordinate().y -1;	
			}
			if(stateMove.equals(new StateMoveDown())){
				coordenada.x=this.avatar.getCoordinate().x ;
				coordenada.y=this.avatar.getCoordinate().y +1;
			}
			if(stateMove.equals(new StateMoveLeft())){
				coordenada.x=this.avatar.getCoordinate().x -1;
				coordenada.y=this.avatar.getCoordinate().y;
			}
			if(stateMove.equals(new StateMoveRight())){
				coordenada.x=this.avatar.getCoordinate().x + 1;
				coordenada.y=this.avatar.getCoordinate().y;
			}
			
			if((tablero.isOcupatePosition(coordenada)) != false){
				this.avatar.setCoordinate(coordenada);
				//tablero.add(avatar);   DEBO GUARDAR EN EL TABLERO
			}
		}
		else{ //Si el avatar gira al presionarse una tecla distinta a la última
			girarAvatar(stateMove);
		}
	}
	public void girarAvatar(StateMove stateMove){
		this.avatar.setOrientationAvatar(stateMove);
		if(stateMove.equals(new StateMoveUp())){
			this.avatar.setOrientation(orientation.UP);}
		if(stateMove.equals(new StateMoveDown())){
			this.avatar.setOrientation(orientation.DOWN);}
		if(stateMove.equals(new StateMoveLeft())){
			this.avatar.setOrientation(orientation.LEFT);}
		if(stateMove.equals(new StateMoveRight())){
			this.avatar.setOrientation(orientation.RIGHT);}	
	}
}
