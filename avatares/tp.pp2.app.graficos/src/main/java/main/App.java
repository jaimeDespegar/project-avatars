package main;

//import control.ControlFreePosition;
import tablero.CreateMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Game game = new Game(); // Aca poner todo sobre el juego , solo datos!

        GameController gameController = new GameController(game);
		gameController.Initialize();

    }
}
