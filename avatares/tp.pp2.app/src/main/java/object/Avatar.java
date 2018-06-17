package object;

import enums.Orientation; 

public class Avatar extends GameObject{

	private Integer reduceDamage=1;

	public Avatar(Integer vida, Orientation orientation) {
		super(vida, orientation);
		reduceDamage=1;
	}
	

	public Integer getReduceDamage() {
		return reduceDamage;
	}
	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}
}
