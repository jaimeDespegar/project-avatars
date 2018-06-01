package main;

import java.awt.Point;

import enums.Orientation;
import object.Avatar;
import tablero.Map;

public class GameController {
	private Map map;
	
	public GameController(Map map) {
		this.map = map;
	}

	public void Initialize() {
		map.getBoard().addBox(new Point(1,0), new Avatar(100, Orientation.RIGHT));
		map.printMap();
	}

}
