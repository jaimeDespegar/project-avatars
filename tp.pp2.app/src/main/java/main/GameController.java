package main;

import tablero.Map;

public class GameController {
	private Map map;
	
	public GameController(Map map) {
		this.map = map;
	}

	public void Initialize() {
		map.printMap();
	}

}
