
package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.Ax;
import tablero.Builder;
import tablero.Line;
import tablero.Map;
import tablero.ObjectGraphic;
import tablero.Rectangle;
import tablero.Structure;

public class Main {

	public static void main(String[] args) {
		List<Point> positions = new ArrayList<Point>();
		positions.add(new Point(1,1));
		positions.add(new Point(1,5));
		Map map = new Builder(new Point(7, 8))
				.withStructureRectangle(new Rectangle(new Point(2, 2), new Point(3, 5), new Structure(null, TypeOfStructure.ACERO)))
				.withStructureLine(new Line(null,positions,new Structure(null, TypeOfStructure.ACERO)))
				.build();
		//solo pueden añadir objectos que extiendan de objectGraphic
		map.addBox(new Point(1,1), new Rectangle(new Point(1, 1), new Point(1, 1), new Structure(null, TypeOfStructure.ACERO)));
		map.deleteBox(new Point(3,3));
		System.out.println(map.getBox(new Point(4,3)).getClass().getName());
		map.printMap();
		
		//map.getBoard().printBoardObjectName(new Point(2,2));
		//map.getBoard().getObjectGraphic(new Point (2,2));//me devuelve el objeto grafico de una posicion
		
		// Como agrego objetos al Map ??
		// Como se que objeto hay en cada casillero?
		// Me parece de que no dibuja la linea
		/*HashMap<Point, Object>  m= new HashMap<Point, Object>();
		m.put(new Point(0,0), new Avatar(new Point(2,2), new Point(2,2), 0, Orientation.UP));
		m.containsKey(0);
		Object a= m.get(new Point());*/
		
		
	}
}