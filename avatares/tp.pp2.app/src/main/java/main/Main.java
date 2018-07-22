package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		GameController gameController = new GameController(game);
		gameController.Initialize();
		gameController.start();
	}
}
