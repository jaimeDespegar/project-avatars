package control;

import java.util.HashMap;
import java.util.Map;

import states.StateMove;
import states.StateMoveDown;
import states.StateMoveLeft;
import states.StateMoveRight;
import states.StateMoveUp;

public class FactoryStateMove {
private Map<Integer, StateMove> mapStateMoves;
	
	public FactoryStateMove(SetKeys setkeys) 
	{
		buildMapStatesMoves(setkeys);
	}

	/*private*/public void buildMapStatesMoves(SetKeys setkeys) 
	{
		this.mapStateMoves = new HashMap<Integer, StateMove>();
		this.mapStateMoves.put(setkeys.getKeyUp(), new StateMoveUp());
		this.mapStateMoves.put(setkeys.getKeyDown(), new StateMoveDown());
		this.mapStateMoves.put(setkeys.getKeyLeft(), new StateMoveLeft());
		this.mapStateMoves.put(setkeys.getKeyRight(), new StateMoveRight());
	}
	
	public StateMove getStateMove(Integer key) 
	{
		return this.mapStateMoves.get(key);
	}
}
