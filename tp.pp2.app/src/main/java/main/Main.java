
package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.TypeOfStructure;
import object.Ax;
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
				.withStructureRectangle(
						new Rectangle(new Point(2, 2), new Point(3, 5), new Structure(null, TypeOfStructure.ACERO)))
				.withStructureLine(new Line(null,positions,new Structure(null, TypeOfStructure.ACERO))).build();
		//map.getBoard().addObjectGraphic(new Point(0,0), new Ax(null, null, 0));
		map.printMap();
		map.getBoard().printBoardObjectName(new Point(2,2));
		map.getBoard().getObjectGraphic(new Point (2,2));//me devuelve el objeto grafico de una posicion
		
		// Como agrego objetos al Map ??
		// Como se que objeto hay en cada casillero?
		// Me parece de que no dibuja la linea
	}
}