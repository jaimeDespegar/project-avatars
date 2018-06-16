package object;

import org.junit.Test;

import enums.Orientation;

public class WeaponTest {
	@Test
	public void testWeapon() {
		Weapon w= new Weapon(1,2,Orientation.RIGHT);
		
		w.getDamage();
		w.setDamage(1);
		w.setShootingRange(2);
		w.isActive();
		w.setActive(true);
		w.getOrientation();
		w.setOrientation(w.getOrientation());
		w.colissionGameObject(w);
		w.colissionStructure(w);
	}
	
	
}
