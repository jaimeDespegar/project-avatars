package object;

import java.awt.Point;

import enums.Orientation;

public class AvatarWithShield extends GameObject{
	private Integer reduceDamage=2;
	private Point position;
	 
	public AvatarWithShield(Integer vida, Orientation orientation) {
		super(vida, orientation);
	}

	public Integer getReduceDamage() {
		return reduceDamage;
	}
	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
}

