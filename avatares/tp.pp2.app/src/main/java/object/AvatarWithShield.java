package object;

import java.awt.Point;

import classProperties.ElectionKeyAvatar;
import enums.Orientation;

public class AvatarWithShield extends GameObject{
	//private Integer reduceDamage=2;
	private Integer id;
	private ElectionKeyAvatar keys;
	private Point position;
	 
	public AvatarWithShield(Integer vida, Orientation orientation) {
		super(vida, orientation);
		reduceDamage=2;
	}
	
	public AvatarWithShield(Integer vida, Orientation orientation, Integer id) {
		super(vida, orientation);
		this.id = id;
		reduceDamage=2;
		
	}

	public AvatarWithShield(Integer vida, Orientation orientation, Integer id, ElectionKeyAvatar electionKeys) {
		super(vida, orientation);
		this.id = id;
		reduceDamage=2;
		this.keys = electionKeys;
	}

	public Integer getReduceDamage() {
		return reduceDamage;
	}
	public void setReduceDamage(Integer reduceDamage) {
		this.reduceDamage = reduceDamage;
	}
	
	public Integer getId() {
		return id;
	}

	public ElectionKeyAvatar getKeys() {
		return keys;
	}
}

