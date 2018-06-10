package powers;

import java.security.InvalidParameterException;
import java.util.Optional;

public class PowerDecorator implements Power {
	
	protected Power power;

	public PowerDecorator() {}
	
	public PowerDecorator(Power power) {
		Power powerOk = Optional.ofNullable(power).orElseThrow(InvalidParameterException::new);
		this.power = powerOk;
	}
	
	@Override
	public PowerAtack atack() {
		return this.power.atack();
	}
	
}
 										