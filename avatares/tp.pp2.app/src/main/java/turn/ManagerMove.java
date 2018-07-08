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
	
	}
	
}