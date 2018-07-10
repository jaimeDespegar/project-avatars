package draftmansTest;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import object.Avatar;
import object.AvatarWithShield;
//import object.Ax;
//import object.Bazooka;
import object.Rectangle;
//import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;
import tablero.Box;
import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class GameTickTest {
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
//	private Ax hacha;
//	private Bazooka bazooka1;
//	private Shotgun escopeta;
	
	/**
	 Se crea un mapa de tamano 4x4, y se crea un rectangulo ((1,2), (2,2), acero). 
	 Ademas se crea un Avatar en la posicion (0,0) con orientacion hacia la derecha, vida = 100 
	 y un Avatar con escudo en la posicion (3,0) con orientacion hacia la izquierda, vida = 100.
	 */
	@Before
	public void init(){
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
//	hacha= new Ax(90, 1, Orientation.RIGHT);
//	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
//	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}
	
	@Test
	public void tickTest(){
		//GameTick g= new GameTick(map.getBoard());
		
		List<Box> lb =new ArrayList<Box>();
		lb.add(map.getBox(new Point(0,0)));
		lb.add(map.getBox(new Point(3,0)));
		
		List<Point> lc =new ArrayList<Point>();
		lc.add(new Point(0,0));
		lc.add(new Point(3,3));
	//	g.updateBoxes(lb, lc);
	//	g.show();
	//	g.run();
		//g.drawShoot(lb, lc);
	//	g.stop();
	}
}
