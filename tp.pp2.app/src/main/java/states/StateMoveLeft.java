package states;

import enums.Orientation;

public class StateMoveLeft extends StateMove
{
	public Orientation orientation = Orientation.LEFT;
	public StateMoveLeft() 
	{
	}

	@Override
	public void control() 
	{
//		if(tank.getCoordinate().getX() >= Configuracion.MinCoordinateX)//20)
//			tank.moverse(getOrientacion());
	}

}
