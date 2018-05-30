package object;

import enums.Orientation;

public class AvatarWithShield extends GameObject{
	private Integer reduceDamage=2;
	 
	public AvatarWithShield(Integer vida, Orientation orientation) {
		super(vida, orientation);
	}

	public Integer getReduceDamage() {
		return reduceDamage;
	}
	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}
}

