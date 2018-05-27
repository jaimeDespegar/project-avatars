package object;

import enums.Orientation;

public class Bazooka extends Weapon{

	public Bazooka(Integer damage, Integer ShootingRange, boolean isActive,Orientation orientation) {
		super(damage,ShootingRange, isActive, orientation);
	}

}
