package turn;

import main.Game;
import java.util.Arrays;

public class ManagerMove {

	private ControllerPlayerTurn controllerTurns;
	private Game game;
	private String playerIsPlaying;

	public ManagerMove(Game game) {
		this.controllerTurns = ControllerPlayerTurn.instancie(Arrays.asList("1","2"));
		this.game = game;
	}

	public boolean isFinishGame() {
		return game.isFinish();
	}

	public boolean isMyTurn(String idPlayer) {
		return playerIsPlaying.equals(idPlayer);
	}

	public void manageMoves() {
		Thread turns = new Thread() {
			@Override
			public void run()
			{
				while (!isFinishGame())
				{
					playerIsPlaying = controllerTurns.next();
					Turn turn = new Turn(playerIsPlaying);
					turn.play();
				}
			}
		};
		turns.start();
	}
	
}