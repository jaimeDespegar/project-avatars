package criteriaOfAcceptance;

import java.awt.Point;
import java.awt.event.KeyEvent;

import object.Avatar;
import object.AvatarWithShield;

import org.junit.Test;

import states.StateMove;
import control.AvatarController;
import control.EnemyAvatarController;
import control.FactoryStateMove;
import control.KeyBoardAvatar;
import control.SetKeys;


/**
 * 
 *Se crea un mapa de dimensión (4,4), con todos los casilleros libres.
 
  _Si se crea el personaje avatar en la posición (2,2) del mapa, si es que ese casillero se encuentra libre, al pedirle al mapa la posición del avatar (2,2), me debe devolver el avatar.
  _Si se crea un rectángulo con los siguientes parámetros ((1,1), (2,2), acero), si es que esos casillero se encuentran libres). Se crea el personaje avatar en la posición (2,2) del mapa, pero esa posición está ocupada y no se agrega. Al pedirle al mapa la posición del avatar (2,2), me debe devolver el tipo de estructura “acero”.

 *
 */
public class UserStory_05 {
	@SuppressWarnings("unused")
	@Test
	public void TestAvatar() {
		Point coordinate= new Point(0,0);
		Point size= new Point(1,1);
		int live= 100;
		
		Avatar avatar= new Avatar(coordinate, size, live);
		AvatarController avaControl= new AvatarController(avatar);
		KeyBoardAvatar keyListener= new KeyBoardAvatar();
		keyListener.actualizar();
		SetKeys setkeys= new SetKeys(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE, KeyEvent.VK_C, KeyEvent.VK_V) ;
		FactoryStateMove factory= new FactoryStateMove(setkeys);
		
		Point coordinate2= new Point(2,2);
		Point size2= new Point(1,1);
		int live2= 100;
		
		AvatarWithShield enemyAvatar= new AvatarWithShield(coordinate2, size2, live2);
		EnemyAvatarController enemyAvaControl= new EnemyAvatarController(enemyAvatar);
		KeyBoardAvatar keyListener2= new KeyBoardAvatar();
		keyListener2.actualizar();
		SetKeys setkeys2= new SetKeys(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER, KeyEvent.VK_K, KeyEvent.VK_L) ;
		FactoryStateMove factory2= new FactoryStateMove(setkeys2);
		
		
		//avaControl.controlAvatar();
		Integer keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow != -1) 
		{
			StateMove stateMove = factory.getStateMove(keyPressedInNow);
			avatar.setStateMove(stateMove);
			avatar.doActionStateMove();
		}
		
		
		//enemyAvaControl.controlAvatar();
		Integer keyPressedInNow2 = keyListener2.getKeyPressed();
		if(keyPressedInNow2 != -1) 
		{
			StateMove stateMove2 = factory2.getStateMove(keyPressedInNow2);
			enemyAvatar.setStateMove(stateMove2);
			enemyAvatar.doActionStateMove();
		}	
		
	}
}
