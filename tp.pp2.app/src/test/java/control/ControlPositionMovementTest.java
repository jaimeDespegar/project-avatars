package control;

import static org.junit.Assert.assertTrue;
import java.awt.Point;
import object.Avatar;
import object.Rectangle;
import object.Structure;
import org.junit.Before;
import org.junit.Test;
import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class ControlPositionMovementTest {
	private Map map;
	private Avatar a;
	private Point aPoint;
	
	@Before
	public void UserStory5(){
	Rectangle rectangle = new Rectangle(new Point(2, 2), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	}
	
	
	@Test
	public void avanzarConOrientacionDerecha(){
		a= new Avatar(100, Orientation.RIGHT);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);
		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionAbajo(){
		a= new Avatar(100, Orientation.DOWN);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);
		Point pFinalEstimado= new Point(1,2);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionIzquierda(){
		a= new Avatar(100, Orientation.LEFT);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);
		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	@Test
	public void avanzarConOrientacionArriba(){
		a= new Avatar(100, Orientation.UP);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	}
	
	//RETROCEDER
	
	@Test
	public void retrocederConOrientacionDerecha(){
		a= new Avatar(100, Orientation.RIGHT);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);
		Point pFinalEstimado= new Point(0,1);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	@Test
	public void retrocederConOrientacionAbajo(){
		a= new Avatar(100, Orientation.DOWN);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientacionIzquierda(){
		a= new Avatar(100, Orientation.LEFT);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);
		Point pFinalEstimado= new Point(2,1);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
	
	@Test
	public void retrocederConOrientacionArriba(){
		a= new Avatar(100, Orientation.UP);
		aPoint= new Point(1,1);
		map.addBox(aPoint, a);
		a.setPosition(aPoint);
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);
		Point pFinalEstimado= new Point(1,2);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
	
	}
}