package criteriaOfAcceptance;

import static org.junit.Assert.*; 

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//import control.AvatarController;
import control.ControlFreePosition;
import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.AvatarWithShield;
import object.Rectangle;
import object.Structure;
import tablero.Builder;
import tablero.Map;

/**
 * 
 * Se crea un mapa de dimensión (3,3), con los casilleros (0,0)
 *  y (2,2) ocupados con el objeto de estructura de tipo acero.
 *
 */
public class UserStory04Test {
	//Si se crea el personaje avatar con vida =100 y 
	//orientación =derecha, este se debe crear en la
	//posición (0,1) del mapa, al pedirle al mapa la 
	//posición (0,1), me debe devolver el avatar.
	
	Map map;
	Avatar a;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	private Rectangle rectangle1;
	private Rectangle rectangle2;
	
	@Before
	public void UserStory04(){
	List<Point> positions = new ArrayList<Point>();
	positions.add(new Point(1,1));
	positions.add(new Point(1,5));

	rectangle1 = new Rectangle(new Point(0, 0), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle1).build();
	rectangle2 = new Rectangle(new Point(2, 2), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
	map.addBox(new Point(2,2), rectangle2);
	
	//System.out.println("Before\n");
	//map.printMap();
	
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.UP);
	}
	
	@Test
	public void ingresarAvatarPrimerCasilleroLibre(){
		System.out.println("\nTest1\n");
		//AvatarController ac= new AvatarController(a, map, null);
		ControlFreePosition free= new ControlFreePosition(a, map, null);
		//ASIGNAR POSICION LIBRE inicial AL AVATAR
		Point punt= free.asignarPrimerPosicionLibre(map);
		System.out.println("Primer punto libre: ("+punt.x+", "+punt.y+")\n");		
		map.addBox(punt, a);
		//map.printMap();	
		assertTrue(punt.equals(new Point(0,1)));
	}
	
	@Test
	public void ingresarAvatarWithShieldUltimoCasilleroLibre(){
		System.out.println("\nTest2\n");
		//AvatarController ac= new AvatarController(aws, map, null);
		ControlFreePosition free= new ControlFreePosition(a, map, null);
		//ASIGNAR POSICION LIBRE final AL AVATAR CON ESCUDO
		Point punt= free.asignarUltimaPosicionLibre(map);
		System.out.println("Ultimo punto libre: ("+punt.x+", "+punt.y+")\n");		
		map.addBox(punt, aws);
		//map.printMap();	
		assertTrue(punt.equals(new Point(2,1)));
	}
}
