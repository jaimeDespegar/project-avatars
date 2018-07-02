package turn;

public class ManagerMove {

	private ControllerPlayerTurn controller;
	private FactoryPlayer factory;
	
	
	public ManagerMove() {
		this.init();
	}
	
	
	private void init() {
		this.factory = new FactoryPlayer();
		this.controller = ControllerPlayerTurn.instancie(factory.getIds());
	}
	
	
	public void manageMoves() {
		String idPlayerNext = controller.next();	
		Player player = factory.getPLayerById(idPlayerNext);
		
		Turn turn = new Turn(player);
		
		if(!turn.isFinish())
		{
			turn.play();
		}
	}
	
}