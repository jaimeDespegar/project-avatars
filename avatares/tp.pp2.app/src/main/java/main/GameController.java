package main;

import java.awt.Point;

import enums.Orientation;
import graphics.Drawer;
import object.Avatar;
import tablero.Map;
import turn.Turn;

public class GameController {
	private Map map;
	private Drawer drawer;
	
	public GameController(Map map) {
		this.map = map;
		this.drawer = new Drawer(map.getBoard());
	}

	public void Initialize() {
		//Turn turn = new Turn(null);
		//aplicar turnos, hacer la gestion de los turnos aca, una vez que muera un avatar termina el juego
		//pasar todo el tablero al dibujador del juego
		
		map.getBoard().addBoxGameObject(new Point(1,0), new Avatar(100, Orientation.RIGHT,1));
		map.printMap();
	}

}
