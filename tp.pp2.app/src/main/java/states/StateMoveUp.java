package states;

import enums.Orientation;

public class StateMoveUp extends StateMove
{
	public Orientation orientation = Orientation.UP;
	public StateMoveUp() 
	{
	}
	
	public void control() 
	{
//		if(tank.getCoordinate().getY() >= Configuracion.MinCoordinateY)//20)
//			tank.moverse(getOrientacion());	
	}

}
