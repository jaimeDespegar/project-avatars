package states;

import enums.Orientation;


public class StateMoveDown extends StateMove
{
	public Orientation orientation = Orientation.DOWN;
	@Override
	public void control() 
	{
//		if(tank.getCoordinate().getY() <= Configuracion.MaxCoordinateY)//547)
//			tank.moverse(getOrientacion());
	}

}
