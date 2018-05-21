package control;

import object.Avatar;
import states.StateMove;



public class EnemyAvatarController {
	private Avatar enemyAvatar;
	private KeyBoardEnemyAvatar keyListener;
	private FactoryStateMove factory;
	
	public EnemyAvatarController(Avatar enemyAvatar) 
	{
		this.enemyAvatar = enemyAvatar;
	}
	
	public void controlAvatar() 
	{
		Integer keyPressedInNow = keyListener.getKeyPressed();
		if(keyPressedInNow != -1) 
		{
			StateMove stateMove = factory.getStateMove(keyPressedInNow);
			this.enemyAvatar.setStateMove(stateMove);
			this.enemyAvatar.doActionStateMove();
		}
	}
}

