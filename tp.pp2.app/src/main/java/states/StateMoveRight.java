package states;

import enums.Orientation;

public class StateMoveRight extends StateMove {
	
	public Orientation orientation = Orientation.RIGHT;
	public StateMoveRight() 
	{
	}

	@Override
	public void control() 
	{
//		if(tank.getCoordinate().getX() <= Configuracion.MaxCoordinateX);//946 )
//			tank.moverse(getOrientacion());
	}

}
