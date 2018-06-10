package powers;

public class PowerDecoratorDoubleImpact extends PowerDecorator {
	
	private static final Integer DOUBLEIMPACT = 2;
	
	public PowerDecoratorDoubleImpact(Power power) {
		super(power);
	}

	@Override
	public PowerAtack atack() {
	   return this.atackDouble(super.atack());
	}

	private PowerAtack atackDouble(PowerAtack power) {
		return new PowerAtack(power.getDangerAtack() * DOUBLEIMPACT);
	}
	
}
