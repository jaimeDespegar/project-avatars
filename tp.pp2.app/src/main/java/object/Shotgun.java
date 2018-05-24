package object;


import enums.Orientation;


public class Shotgun extends Weapon{

	public Shotgun(Integer damage, Integer ShootingRange, boolean isActive,Orientation orientation) {
		super(damage,ShootingRange, isActive, orientation);
	}

}