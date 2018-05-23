package control;

import object.Avatar;
import object.AvatarWithShield;
import states.StateMove;



public class EnemyAvatarController {
	private AvatarWithShield enemyAvatar;
	private KeyBoardEnemyAvatar keyListener;
	private FactoryStateMove factory;
	
	public EnemyAvatarController(AvatarWithShield enemyAvatar) 
	{
		this.enemyAvatar = enemyAvatar;
	}
	
	public void controlEnemyAvatar() 
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

