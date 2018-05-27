package control;

import java.awt.Point;
import java.awt.event.KeyEvent;

import object.Avatar;
import object.AvatarWithShield;
import object.GameObject;
import object.Weapon;
import states.StateMove;
import tablero.Map;



public class AvatarWithShieldController extends GameObjectController{
	private KeyBoardAvatar keyListener;
	public Point coordenada;

	
	
	public AvatarWithShieldController(GameObject avatarWithShield, Map map, Weapon arma) 
	{
		super(avatarWithShield, map, arma);
		
	}

	public void controlAvatar(Point positionAvatarWithShield) //Esto se usa cuando se juego continuamente
	{
		Integer keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == KeyEvent.VK_UP){
			avanzar(positionAvatarWithShield);
		}
		if(keyPressedInNow == KeyEvent.VK_DOWN){
			retroceder(positionAvatarWithShield);
		}
		if(keyPressedInNow == KeyEvent.VK_LEFT){
			girarHaciaIzquierda();
		}
		if(keyPressedInNow == KeyEvent.VK_RIGHT){
			girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == KeyEvent.VK_ENTER){
			dispararArma();
		}
		if(keyPressedInNow == KeyEvent.VK_K){
			activarPoder1();
		}
		if(keyPressedInNow == KeyEvent.VK_L){
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
}