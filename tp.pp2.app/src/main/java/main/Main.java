
package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.TypeOfStructure;
import tablero.Builder;
import tablero.Line;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;

public class Main {

	public static void main(String[] args) {
		List<Point> positions = new ArrayList<Point>();
		positions.add(new Point(1,1));
		positions.add(new Point(1,5));
		Map map = new Builder(new Point(7, 8))
				.withStructureRectangle(new Rectangle(new Point(2, 2), new Point(3, 5), new Structure(TypeOfStructure.ACERO)))
				.withStructureLine(new Line(positions,new Structure(TypeOfStructure.ACERO)))
				.build();
		//solo pueden añadir objectos que extiendan de objectGraphic
		map.addBox(new Point(1,1), new Rectangle(new Point(1, 1), new Point(1, 1), new Structure(TypeOfStructure.ACERO)));
		map.deleteBox(new Point(3,3));
		System.out.println(map.getBox(new Point(4,3)).getClass().getName());
		map.printMap();
		
	}
}