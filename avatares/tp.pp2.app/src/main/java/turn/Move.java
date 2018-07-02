package turn;

import java.util.concurrent.TimeUnit;

public class Move {

	private Player player;
	private String action;
	
	public Move(Player p) {
		this.player = p;
	}

	public void playMove() {
		System.out.println("Esta jugando el player N°" + player.getId());
	}

	
	public String getAction() {
		return action;
	}

	public void doAction() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playMove();
	}

}