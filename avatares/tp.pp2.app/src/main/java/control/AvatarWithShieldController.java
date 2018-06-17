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

	public void controlAvatar(Point positionAvatarWithShield, Integer keyPressedInNow, GameObject enemy) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException //Esto se usa cuando se juego continuamente
	{
		KeyAvatarWithShieldProperties k= new KeyAvatarWithShieldProperties();
		ControlPositionMovement c= new ControlPositionMovement(avatar, map, arma);
		ControlTurn t= new ControlTurn(avatar, map , arma);
		ControlColissionShoot d= new ControlColissionShoot(avatar, map, arma);
		
		//keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyUp()){//KeyEvent.VK_UP){
			c.avanzar(positionAvatarWithShield);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyDown()){
			c.retroceder(positionAvatarWithShield);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyLeft()){
			t.girarHaciaIzquierda();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyRight()){
			t.girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyShoot()){
			d.disparar(enemy);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower1()){
			activarPoder1();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower2()){
			activarPoder2();
		}

	}
	
	private void activarPoder2() {
	}
	private void activarPoder1() {
	}
	private void dispararArma() {
	}
	private void salir() {
	}
}