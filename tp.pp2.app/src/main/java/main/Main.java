
package main;

import java.awt.Point;

import tablero.Map;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(new Point (5,6));
		map.printMap();
		//new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER).build();
	}

}