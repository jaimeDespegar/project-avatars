package object;

import classProperties.ElectionKeyAvatar;
import classProperties.ElectionKeyGameObject;
import enums.Orientation;

public class Avatar extends GameObject{

	private Integer id;
	private ElectionKeyAvatar keys;

	public Avatar(Integer vida, Orientation orientation, Integer id) {
		super(vida, orientation);
		this.id = id;
		reduceDamage=1;
	}

	public Avatar(Integer vida, Orientation orientation, Integer id, ElectionKeyAvatar electionKeys) {
		super(vida, orientation);
		this.id = id;
		reduceDamage=1;
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

	public void turnToRight() {
		this.orientation = orientation.getRight();
	}

	public void turnToLeft() {
		this.orientation = orientation.getLeft();
	}

	public void turnToReverse() {
		this.orientation = orientation.getReverse();
	}

	public ElectionKeyAvatar getKeys() {
		return keys;
	}

}
