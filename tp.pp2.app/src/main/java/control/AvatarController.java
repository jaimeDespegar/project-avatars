package control;

import java.awt.AWTException;
import java.awt.Point; 
import java.awt.event.KeyEvent;

import classProperties.KeyAvatarProperties;
import object.GameObject;
import object.Weapon;
import tablero.Map;



public class AvatarController extends GameObjectController{
	
	
	public AvatarController(GameObject avatar, Map map, Weapon arma) 
	{
		super(avatar, map, arma);
	}
	
	public void controlAvatar(Point positionAvatar, Integer keyPressedInNow) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException //Esto se usa cuando se juego continuamente
	{
		KeyAvatarProperties k= new KeyAvatarProperties();
		ControlPositionMovement c= new ControlPositionMovement(avatar, map, arma);
		ControlTurn t= new ControlTurn(avatar, map , arma);
		
		
		//keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyUp()){
			c.avanzar(positionAvatar);
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyDown()){
			c.retroceder(positionAvatar);
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyLeft()){
			t.girarHaciaIzquierda();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyRight()){
			t.girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyShoot()){
			//dispararArma();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyPower1()){
			//activarPoder1();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyPower2()){
			//activarPoder2();
		}

	}
	private void salir() {
	}
}