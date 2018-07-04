package object;

import enums.Orientation; 

public class Avatar extends GameObject{
	private Integer id;
	private Integer reduceDamage=1;

	public Avatar(Integer vida, Orientation orientation, Integer id) {
		super(vida, orientation);
		this.id = id;
		reduceDamage=1;
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
}
