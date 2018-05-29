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
		
		//keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyUp()){
			avanzar(positionAvatar);
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyDown()){
			retroceder(positionAvatar);
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyLeft()){
			girarHaciaIzquierda();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyRight()){
			girarHaciaDerecha();
		}
		if(keyPressedInNow == KeyEvent.VK_ESCAPE){
			salir();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyShoot()){
			dispararArma();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyPower1()){
			activarPoder1();
		}
		if(keyPressedInNow == k.getElectionKeyAvatar().getKeyPower2()){
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