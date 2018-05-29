package control;

import java.awt.AWTException; 
import java.awt.Point;
import java.awt.event.KeyEvent;

import classProperties.KeyAvatarWithShieldProperties;
import object.GameObject;
import object.Weapon;
import tablero.Map;



public class AvatarWithShieldController extends GameObjectController{
	
	public AvatarWithShieldController(GameObject avatarWithShield, Map map, Weapon arma) 
	{
		super(avatarWithShield, map, arma);
		
	}

	public void controlAvatar(Point positionAvatarWithShield, Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException //Esto se usa cuando se juego continuamente
	{
		KeyAvatarWithShieldProperties k= new KeyAvatarWithShieldProperties();
		
		//keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyUp()){//KeyEvent.VK_UP){
			avanzar(positionAvatarWithShield);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyDown()){
			retroceder(positionAvatarWithShield);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyLeft()){
			girarHaciaIzquierda();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyRight()){
			girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyShoot()){
			dispararArma();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower1()){
			activarPoder1();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower2()){
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