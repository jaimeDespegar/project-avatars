package tablero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.Line;
import object.Rectangle;
import object.Structure;

public class TestAddStructure {
	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Line line1;
	private Line line2;
	private Map map;
	
	@Before
	public void init() {
		map = new Builder(new Point(5,5)).build();
		rectangle1 = new Rectangle(new Point(1,1), new Point(2,2),new Structure(TypeOfStructure.ACERO));
		rectangle2 = new Rectangle(new Point(1,-1), new Point(2,2),new Structure(TypeOfStructure.ACERO));;
		line1 = new Line(UtilCreateListByLine.createList(new Point(1,1), new Point(3,3)), new Structure(TypeOfStructure.AGUA));
		line2 = new Line(UtilCreateListByLine.createList(new Point(1,1), new Point(5,3)), new Structure(TypeOfStructure.AGUA));
	}
	
	@Test
	public void testAddStructureByRectangle() {
		assertNull(map.getBoard().getBoxes()[1][1]);
		AddStructure.addStructureByRectangle(map.getBoard(), rectangle1);
		assertNotNull(map.getBoard().getBoxes()[1][1]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailAddStructureByRectangle() {
		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
	}

	@Test
	public void testAddStructureByLine() {
		assertNull(map.getBoard().getBoxes()[2][2]);
		AddStructure.addStructureByLine(map.getBoard(), line1);
		assertNotNull(map.getBoard().getBoxes()[2][2]);
	}

	@Test(expected = RuntimeException.class)
	public void testFailAddStructureByLine() {
		AddStructure.addStructureByLine(map.getBoard(), line2);
	}
	
	@Test
	public void testValidatePositions() {
		assertTrue(AddStructure.validatePositions(map.getBoard(), UtilCreateListByLine.createList(new Point(1,1), new Point(3,3))));
		AddStructure.addStructureByLine(map.getBoard(), line1);
		assertFalse(AddStructure.validatePositions(map.getBoard(), UtilCreateListByLine.createList(new Point(1,1), new Point(3,3))));
	}

	@Test
	public void testInvalidatePositions() {
		AddStructure.addStructureByLine(map.getBoard(), line1);
		assertFalse(AddStructure.validatePositions(map.getBoard(), UtilCreateListByLine.createList(new Point(1,1), new Point(3,3))));
	}
	
	@Test
	public void testAddStructures() {
		AddStructure.addStructureByLine(map.getBoard(), line1);
		assertNotNull(map.getBoard().getBoxes()[2][2]);
	}

	@Test(expected = RuntimeException.class)
	public void testFailAddStructures() {
		AddStructure.addStructureByLine(map.getBoard(), line1);
		AddStructure.addStructureByLine(map.getBoard(), line1);
		assertNotNull(map.getBoard().getBoxes()[2][2]);
	}
}
