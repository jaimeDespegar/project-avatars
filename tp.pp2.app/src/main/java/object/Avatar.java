package object;

import enums.Orientation; 

public class Avatar extends GameObject{
	private boolean reduceDamage = false;
	private int damage = 1;

	public Avatar(Integer vida, Orientation orientation) {
		super(vida, orientation);

	}

	public int finalDamageAx(Ax hacha) {
		int axDamage = hacha.getDamage();
		if (reduceDamage) {
			axDamage = axDamage / damage;
		}
		return axDamage;
	}

	public int finalDamageBazooka(Bazooka bazooka) {
		int axDamage = bazooka.getDamage();
		if (reduceDamage) {
			axDamage = axDamage / damage;
		}
		return axDamage;
	}

	public int finalDamageShotgun(Shotgun escopeta) {
		int axDamage = escopeta.getDamage();
		if (reduceDamage) {
			axDamage = axDamage / damage;
		}
		return axDamage;
	}

	public void colissionAvatarWithShield() {
		this.vida = this.vida - 0;
	}

	public void colissionAx(Ax hacha) {
		this.vida = this.vida - finalDamageAx(hacha);
	}

	public void colissionBazooka(Bazooka bazooka) {
		this.vida = this.vida - finalDamageBazooka(bazooka);
	}

	public void colissionShotgun(Shotgun escopeta) {
		this.vida = this.vida - finalDamageShotgun(escopeta);
	}

}
