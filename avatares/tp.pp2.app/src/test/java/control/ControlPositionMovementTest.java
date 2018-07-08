package control;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Rectangle;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class ControlPositionMovementTest {
	Map map;
	Rectangle rectangle;
	Avatar a;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	
	@Before
	public void UserStory5(){
	
	rectangle = new Rectangle(new Point(2, 2), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
		
	
	}
	
	
	@Test
	public void avanzarConOrientacionDerecha(){
		System.out.println("\nTest1\n");
		a= new Avatar(100, Orientation.RIGHT,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionAbajo(){
		System.out.println("\nTest2\n");
		
		a= new Avatar(100, Orientation.DOWN,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(1,2);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionIzquierda(){
		System.out.println("\nTest3\n");
		
		a= new Avatar(100, Orientation.LEFT,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionArriba(){
		System.out.println("\nTest4\n");
		
		a= new Avatar(100, Orientation.UP,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	//RETROCEDER
	
	@Test
	public void retrocederConOrientacionDerecha(){
		System.out.println("\nTest5\n");
		a= new Avatar(100, Orientation.RIGHT,1);
		
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	@Test
	public void retrocederConOrientacionAbajo(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.DOWN,1);
		
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientacionIzquierda(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.LEFT,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientacionArriba(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.UP,1);
		aPoint= new Point(1,1);
		a.setPosition(aPoint);
		map.addBox(aPoint, a);
		//map.printMap();
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(1,2);
		actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
}