package turn;

public class Turn {

	private Player player;
	private Boolean isFinish;
	
	public Turn(Player player) {
		this.player = player;
		this.isFinish = Boolean.FALSE;
	}

	
	public Boolean isFinish() {
		return isFinish;
	}

	
	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}
 
	
	public void play() {
		Move move = new Move(player);
		move.doAction();
		isFinish = Boolean.TRUE;
	}
	
}