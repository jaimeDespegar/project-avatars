package tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.Rectangle;
import object.Structure;

public class TestMap {
	private Map map;
	private Rectangle rectangle;
	
	@Before
	public void init() {
		rectangle = new Rectangle(new Point(0, 1), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
		map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
	}
	
	@Test
	public void testGetBoard() {
		assertNotNull(map.getBoard());
	}
	@Test
	public void testGetBox() {
		map.printMap();
		assertNull(map.getBox(new Point(2,1)));
		assertNotNull(map.getBox(new Point(1,0)));
	}
	
	@Test
	public void testAddBox() {
		map.getBoard().addBox(new Point(2,2),rectangle);
		assertNotNull(map.getBox(new Point(2,2)));
	}
	
	@Test
	public void testDeleteBox() {
		map.getBoard().deleteBox(new Point(0,0));
		assertNull(map.getBox(new Point(0,0)));
	}
	
	@Test
	public void testGetLimitsBoard() {
		assertEquals(map.getBoard().getLimitsBoard(), new Point(3,3));
	}
}
