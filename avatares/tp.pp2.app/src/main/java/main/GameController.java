package main;

import java.awt.Point;

import draftmans.GameTick;
import enums.Orientation;
import object.Avatar;
import tablero.Map;

public class GameController implements Runnable{
	private Map map;
	private GameTick gameTick;
	
	public GameController(Map map) {
		this.map = map;
		this.gameTick = new GameTick(this.map.getBoard());
	}

	public void Initialize() {
		this.gameTick.start();
		map.getBoard().addBox(new Point(0,1), new Avatar(100, Orientation.RIGHT,1));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
