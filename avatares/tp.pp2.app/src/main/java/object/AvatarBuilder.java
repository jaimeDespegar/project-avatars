package object;

import enums.Orientation;

public class AvatarBuilder {
	// con esto creo los avatares , borro la clse avatar with shield
	private Avatar instance = new Avatar(0, null, 1, null);
	private Integer withOutshield = 1;
	private Integer shield = 2;
	
	public AvatarBuilder() {}
	
	public static AvatarBuilder create() {
		return new AvatarBuilder();
	}

	public Avatar build() {
		return instance;
	}
	
	public AvatarBuilder withShield() {
		this.instance.setReduceDamage(shield);
		return this;
	}
	
	public AvatarBuilder withLife(Integer life) {
		this.instance.setVida(life);
		return this;
	}
	
	public AvatarBuilder withOrienttion(Orientation o) {
		this.instance.setOrientation(o);
		return this;
	}
	
	public AvatarBuilder withOutShield() {
		this.instance.setReduceDamage(withOutshield);
		return this; // posiblemente quitarlo!
	}
	
}
