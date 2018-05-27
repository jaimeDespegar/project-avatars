
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
		
		
		AvatarController ac= new AvatarController(a, map, null);
		//ASIGNAR POSICION LIBRE inicial AL AVATAR
		Point pun= ac.asignarPrimerPosicionLibre(map);
		System.out.println("primer punto libre: ("+pun.x+", "+pun.y+")");
				
		//AVANZAR
		ac.avanzar(aPoint);
		System.out.println("positionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		System.out.println("\n");
		map.printMap();
		System.out.println("\n");
		
		//ASIGNAR POSICION LIBRE inicial AL AVATAR
		Point punt= ac.asignarPrimerPosicionLibre(map);
		System.out.println("primer punto libre: ("+punt.x+", "+punt.y+")");
		
		//RETROCEDER
		ac.retroceder(new Point(1,0));
		System.out.println("positionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		
		System.out.println("\n");
		System.out.println("orientacion Avatar1: "+a.getOrientation().name());
		map.printMap();
		
		//ASIGNAR POSICION LIBRE inicial AL AVATAR
		Point p= ac.asignarPrimerPosicionLibre(map);
		System.out.println("primer punto libre: ("+p.x+", "+p.y+")");
		
		
		
		//GIRAR DERECHA
		Avatar a2= new Avatar(100, Orientation.LEFT);
		AvatarController ac2= new AvatarController(a2, null, null);
		System.out.println("\n orientacion Avatar4: "+a2.getOrientation().name());
		ac2.girarHaciaDerecha();
		System.out.println("\n orientacion Avatar4: "+a2.getOrientation().name());
	
		//GIRAR IZQUIERDA
		Avatar a3= new Avatar(100, Orientation.LEFT);
		AvatarController ac3= new AvatarController(a3, null, null);
		System.out.println("\n orientacion Avatar5: "+a3.getOrientation().name());
		ac3.girarHaciaIzquierda();
		System.out.println("\n orientacion Avatar5: "+a3.getOrientation().name());
		
		
		
		
		
	}
}