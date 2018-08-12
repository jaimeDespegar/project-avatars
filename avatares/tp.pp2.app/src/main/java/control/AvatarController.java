package control;

import java.awt.AWTException;
import java.awt.Point;

import main.Constants;
import classProperties.KeyAvatarProperties;
import object.GameObject;
import object.Weapon;
import tablero.Map;

public class AvatarController extends GameObjectController{
	Integer cantShootingRange=0;
	ControlColissionShoot d;
	KeyAvatarProperties k;
	ControlPositionMovement c;
	boolean control= false;
	
	public AvatarController(GameObject avatar, Map map, Weapon arma) 
	{
		super(avatar, map, arma);
		d= new ControlColissionShoot(avatar, map, arma);
		k= new KeyAvatarProperties();
		k.loadPropertiesByRoute(Constants.ROUTE_PROPERTIES_Avatar);
		c= new ControlPositionMovement(avatar, map, arma);
	}
	
	public void controlAvatar(Point positionAvatar, Integer keyPressedInNow, GameObject enemy)throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException //Esto se usa cuando se juego continuamente
	{

		//keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyUp().getKeyValue())){
			c.avanzar(positionAvatar);
		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyDown().getKeyValue())){
			c.retroceder(positionAvatar);
		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyLeft().getKeyValue())){
			avatar.turnToLeft();
		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyRight().getKeyValue())){
			avatar.turnToRight();
		}
//		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
//			salir();
//		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyShoot().getKeyValue())){
			control= true;
			cantShootingRange= d.disparar(enemy);
			isDisparoRealizado= true;
			cantDisparos= cantDisparos+1;
		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyPower1().getKeyValue())){
			//activarPoder1();
		}
		if(keyPressedInNow.equals(k.getElectionKeyAvatar().getKeyPower2().getKeyValue())){
			//activarPoder2();
		}

	}
	

	private void salir() {
	}
	public Integer getCantShootingRange() {
		return cantShootingRange;
	}
	public boolean isColission(){
		if(control){
			control= false;
			return d.isColission(cantShootingRange);
		}
		else{
			return false;
		}
	}

	public ControlColissionShoot getControlColissionShoot() {
		return d;
	}
	public KeyAvatarProperties getKeyAvatarProperties() {
		return k;
	}
	public ControlPositionMovement getControlPositionMovement() {
		return c;
	}
}