
package main;

import java.awt.Point;

import tablero.Builder;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;
import tablero.TypeOfStructure;

public class Main {

	public static void main(String[] args) {
		// Map map = new Map(new Point (5,6));
		// map.printMap();
		// new Hero.Builder(Profession.MAGE,
		// "Riobard").withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER).build();
		Map map = new Builder(new Point(7, 8))
				.withStructureRectangle(
						new Rectangle(new Point(2, 2), new Point(3, 5), new Structure(null, TypeOfStructure.ACERO)))
				.withStructureLine(null).build();
		map.printMap();
	}

}