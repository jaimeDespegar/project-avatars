package powers;

public class PowerDecoratorFire extends PowerDecorator {
	
	private static final Integer DANGERFIRE = 30;
	
	public PowerDecoratorFire() {
		this.power = new PowerBasic(0);
	}
	
	public PowerDecoratorFire(Power power) {
		super(power);
	}

	@Override
	public PowerAtack atack() {
		return this.atackFire(this.power.atack()); 		
	}

	private PowerAtack atackFire(PowerAtack power) {
		return new PowerAtack(power.getDangerAtack() + DANGERFIRE);
	}

}
