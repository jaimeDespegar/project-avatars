package control;

import java.awt.Point; 
import java.awt.event.KeyEvent;

import classProperties.KeyAvatarProperties;
import object.GameObject;
import object.Weapon;
import tablero.Map;



public class AvatarController extends GameObjectController{

	private KeyBoardAvatar keyListener;
	private KeyAvatarProperties keyAvatar;
	public Point coordenada;

	
	
	public AvatarController(GameObject avatar, Map map, Weapon arma) 
	{
		super(avatar, map, arma);
		keyListener= new KeyBoardAvatar();
		//keyAvatar= new KeyAvatarProperties();
	}
	
	public void controlAvatar(Point positionAvatar, Integer keyPressedInNow) //Esto se usa cuando se juego continuamente
	{
		//keyPressedInNow = keyListener.getKeyPressed();
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
	


	

}