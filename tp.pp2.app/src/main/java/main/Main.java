
package main;

import java.awt.Point;

import enums.TypeOfStructure;
import tablero.Builder;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;

public class Main {

	public static void main(String[] args) {
		Map map = new Builder(new Point(7, 8))
				.withStructureRectangle(
						new Rectangle(new Point(2, 2), new Point(3, 5), new Structure(null, TypeOfStructure.ACERO)))
				.withStructureLine(null).build();
		map.printMap();
	}
}