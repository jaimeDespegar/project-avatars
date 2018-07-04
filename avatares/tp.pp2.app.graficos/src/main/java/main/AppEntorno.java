package main;

import controllers.Controller;
import draftmans.GameDraftsman;

public class AppEntorno {

	public static void main(String[] args)
	{
		Game game = new Game();
		game.getMap().printMap();
   		GameDraftsman entorno = new GameDraftsman(game.getMap());
	   	Controller controller = new Controller(game, entorno);
		controller.init();
	}

}
