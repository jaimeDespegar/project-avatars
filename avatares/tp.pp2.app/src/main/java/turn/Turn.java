package turn;

public class Turn {

	private String player;
	private Timer timer;

	public Turn(String player) {
		this.player = player;
		this.timer = new Timer();
	}


	public Boolean isFinish() {
		return timer.isFinish();
	}
 
	
	public void play() {
		System.out.println("Juega solo el player " + player);
		timer.initTime();
	}
	
}