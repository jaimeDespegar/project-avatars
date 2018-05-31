package control;

import java.awt.Point;

import object.GameObject;
import object.Weapon;
import tablero.Map;

public class ControlFreePosition extends GameObjectController {
	
	public ControlFreePosition(GameObject avatar, Map map, Weapon arma) {
		super(avatar, map, arma);
	}
	//ASIGNAR POSICION LIBRE
		@Override
		public Point asignarPrimerPosicionLibre(Map map){
			Point p= null;
			for (int x = 0; x < map.getBoard().getBoxes().length; x++) {
				for (int y = 0; y < map.getBoard().getBoxes()[0].length; y++) {
					if(map.getBoard().getBoxes()[x][y] == null) {
						p= new Point(x,y);
						return p;
					}
				}	
			}
			return p;
		}
		@Override
		public Point asignarUltimaPosicionLibre(Map map){
			Point p= null;
			for (int x = map.getBoard().getBoxes().length -1; x >= 0 ; x--) {
				for (int y = map.getBoard().getBoxes()[0].length -1; y >= 0 ; y--) {
					if(map.getBoard().getBoxes()[x][y] == null) {
						p= new Point(x,y);
						return p;
					}
				}	
			}
			return p;
		}
}
