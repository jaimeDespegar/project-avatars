package main;

import control.ControlFreePosition;
import tablero.CreateMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CreateMap createMap = new CreateMap(Constants.ROUTE_PROPERTIES);
		createMap.createMap();
		GameController gameController = new GameController(createMap.getMap());
		gameController.Initialize();
		
		ControlFreePosition c = new ControlFreePosition(null, createMap.getMap(), null);
		System.out.println("PRIMERA " + c.asignarPrimerPosicionLibre());
		System.out.println("ULTIMA " + c.asignarUltimaPosicionLibre());
    }
}
