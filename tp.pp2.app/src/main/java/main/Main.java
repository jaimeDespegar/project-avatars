
package main;

import java.awt.AWTException;  
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import object.Avatar;
import object.Line;
import object.Rectangle;
import object.Structure;
import enums.Orientation;
import enums.TypeOfStructure;
import tablero.Builder;
import tablero.Map;

public class Main {

	public static void main(String[] args) throws AWTException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Point> positions = new ArrayList<Point>();
		positions.add(new Point(1,1));
		positions.add(new Point(1,5));
		Map map = new Builder(new Point(4, 4))
				.withStructureRectangle(new Rectangle(new Point(1, 1), new Point(2, 2), new Structure(TypeOfStructure.ACERO)))
				.withStructureLine(new Line(positions,new Structure(TypeOfStructure.ACERO)))
				.build();
		//solo pueden añadir objectos que extiendan de objectGraphic
//		map.addBox(new Point(1,1), new Rectangle(new Point(1, 1), new Point(1, 1), new Structure(TypeOfStructure.ACERO)));
//		map.deleteBox(new Point(3,3));
//		System.out.println(map.getBox(new Point(4,3)).getClass().getName());
//		map.printMap();
		
		Avatar a= new Avatar(100, Orientation.RIGHT);
		Point aPoint=new Point(0,0);
		System.out.println("positionAvatar= (" +aPoint.x+", "+aPoint.y+")" );
		map.addBox(aPoint, a);
		System.out.println("casillero= "+map.getBox(new Point(0,0)).getObjectGraphic().getClass().getName());
		System.out.println("\n");
		//map.printMap();
		
		
		
	}
	
}