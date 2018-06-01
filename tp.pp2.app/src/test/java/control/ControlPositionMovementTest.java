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
	public void avanzarConOrientaci�nDerecha(){
		System.out.println("\nTest1\n");
		a= new Avatar(100, Orientation.RIGHT);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientaci�nAbajo(){
		System.out.println("\nTest2\n");
		
		a= new Avatar(100, Orientation.DOWN);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(1,2);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientaci�nIzquierda(){
		System.out.println("\nTest3\n");
		
		a= new Avatar(100, Orientation.LEFT);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientaci�nArriba(){
		System.out.println("\nTest4\n");
		
		a= new Avatar(100, Orientation.UP);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);

		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	//RETROCEDER
	
	@Test
	public void retrocederConOrientaci�nDerecha(){
		System.out.println("\nTest5\n");
		a= new Avatar(100, Orientation.RIGHT);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	@Test
	public void retrocederConOrientaci�nAbajo(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.DOWN);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientaci�nIzquierda(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.LEFT);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientaci�nArriba(){
		System.out.println("\nTest6\n");
		a= new Avatar(100, Orientation.UP);
		
		aPoint= new Point(1,1);
		
		map.addBoxGameObject(aPoint, a);
		
		a.setPosition(aPoint);
		
		
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);

		Point pFinalEstimado= new Point(1,2);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		//map.printMap();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
}