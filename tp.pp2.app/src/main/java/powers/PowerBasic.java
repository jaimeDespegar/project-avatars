package powers;

public class PowerBasic implements Power{

	private PowerAtack powerAtack;
	private static final Integer danger = 10;
	
	public PowerBasic(Integer danger) {
		this.powerAtack = new PowerAtack(danger);
	}
	
	public PowerBasic() {
		this.powerAtack = new PowerAtack(danger);
	}
	
	@Override
	public PowerAtack atack() {
		return powerAtack;
	}
	
}
