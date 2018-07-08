package main;

import java.awt.Point;

import draftmans.GameTick;
import enums.Orientation;
import graphics.Drawer;
import object.Avatar;
import tablero.Map;
import turn.ManagerMove;

public class GameController implements Runnable{
	private Map map;
	private GameTick gameTick;
	private Avatar avatar1;
	private Avatar avatar2;
	
	public GameController(Map map) {
		this.map = map;
		this.gameTick = new GameTick(this.map.getBoard());
		this.avatar1 = new Avatar(100, Orientation.RIGHT,1);
		this.avatar2 = new Avatar(100, Orientation.UP,2);
	}

	public void Initialize() {
		this.gameTick.start();
		map.getBoard().addBox(new Point(0,1), avatar1);
		map.getBoard().addBox(new Point(6,8), avatar2);
	}

	@Override
	public void run() {
		ManagerMove m = new ManagerMove();
		
		while(true) 
		{
			m.manageMoves();
		}
		
	}

}
