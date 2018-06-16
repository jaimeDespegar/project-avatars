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
		
	public Point asignarPrimerPosicionLibre() {
		OperatorScroll operatorFirst = new OperatorScrollFirstValue(map.getRowsSize(), map.getColumnsSize());
		return scrollMap(map, operatorFirst);
	}
		
	public Point asignarUltimaPosicionLibre() {
		OperatorScroll operatorLast = new OperatorScrollLastValue(map.getRowsSize(), map.getColumnsSize(), 0, 0);
		return scrollMap(map, operatorLast);
	}
	
	
	public Point scrollMap(Map map, OperatorScroll os) {
		Point box = null;
		for (int x = os.getFirstInit(); os.isFinish(os.getInitSize(), x); x = os.getOperation(x)) 
		{
			for (int y = os.getSecondInit(); os.isFinish(os.getSecondSize(), y); y = os.getOperation(y)) 
			{
				box = new Point(x,y);
				if (!map.isOcupatePosition(box) ) 
				{
					return box;
				}
			}
		}
		return box;
	}
	
}
