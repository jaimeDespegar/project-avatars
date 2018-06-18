package control;

import java.awt.AWTException;  
import java.awt.Point;
import java.awt.event.KeyEvent;

import classProperties.KeyAvatarWithShieldProperties;
import object.GameObject;
import object.Weapon;
import tablero.Map;



public class AvatarWithShieldController extends GameObjectController{
	Integer cantShootingRange=0;
	ControlColissionShoot d;
	
	public AvatarWithShieldController(GameObject avatarWithShield, Map map, Weapon arma) 
	{
		super(avatarWithShield, map, arma);
		d= new ControlColissionShoot(avatar, map, arma);
	}

	public void controlAvatar(Point positionAvatarWithShield, Integer keyPressedInNow, GameObject enemy) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException //Esto se usa cuando se juego continuamente
	{
		KeyAvatarWithShieldProperties k= new KeyAvatarWithShieldProperties();
		ControlPositionMovement c= new ControlPositionMovement(avatar, map, arma);
		ControlTurn t= new ControlTurn(avatar, map , arma);
		
		
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
			cantShootingRange= d.disparar(enemy);
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower1()){
			//activarPoder1();
		}
		if(keyPressedInNow == k.getElectionKeyAvatarWithShield().getKeyPower2()){
			//activarPoder2();
		}

	}
	
	private void salir() {
	}
	public Integer getCantShootingRange() {
		return cantShootingRange;
	}
	public boolean isColission(){
		boolean huboChoque= d.isColission(cantShootingRange);
		return huboChoque;
	}

	public ControlColissionShoot getD() {
		return d;
	}
}