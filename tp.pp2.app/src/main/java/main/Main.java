
package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import control.AvatarController;
import object.Avatar;
import enums.Orientation;
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
		map.printMap();
		
//		System.out.println("orientacion avatar: "+a.getOrientation());
//		if( map.getBox(new Point(1,0)) == null){
//			System.out.println("position(1,0) = null");
//		}
//		System.out.println("posicion(1,0) is ocupate: "+map.getBoard().isOcupatePosition(new Point(1,0)));
			
		AvatarController ac= new AvatarController(a, map, null);
		ac.avanzar(aPoint);
		//ac.getAvatar().setPosition(aPoint);
		System.out.println("positionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		System.out.println("casillero= "+map.getBox(new Point(1,0)).getObjectGraphic().getClass().getName());
		System.out.println("\n");
		map.printMap();
		System.out.println("\n");
		
		ac.retroceder(new Point(1,0));
		//ac.getAvatar().setPosition(new Point(1,0));
		System.out.println("positionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		System.out.println("\n");
		
		map.printMap();
	}
}