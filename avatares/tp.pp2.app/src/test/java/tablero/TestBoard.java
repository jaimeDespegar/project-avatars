package tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.Structure;

public class TestBoard {
	private Board board;
	
	@Before
	public void init () {
		board = new Board(new Point(4,4));
	}
	
	@Test
	public void testSizeBoard() {
		assertEquals((board.getBoxes().length * board.getBoxes()[0].length),16); 
	}
	
	@Test(expected = RuntimeException.class)
	public void testFailToGetBox() {
		assertNull(board.getBox(new Point(4,5)));
	}
	
	@Test
	public void testIsOcupatedPosition() {
		assertFalse(board.isOcupatePosition(new Point(1,1)));
		board.addBox(new Point(1,1), new Structure(TypeOfStructure.ACERO));
		assertTrue(board.isOcupatePosition(new Point(1,1)));
	}
	
	@Test
	public void testDeleteBox() {
		board.addBox(new Point(1,1), new Structure(TypeOfStructure.ACERO));
		assertTrue(board.isOcupatePosition(new Point(1,1)));
		board.deleteBox(new Point(1,1));
		assertFalse(board.isOcupatePosition(new Point(1,1)));
	}
	
	@Test
	public void testAddBox() {
		board.addBox(new Point(1,1), new Structure(TypeOfStructure.ACERO));
		assertTrue(board.isOcupatePosition(new Point(1,1)));
	}
	
	@Test
	public void testGetLimitsBoard() {
		assertEquals(board.getLimitsBoard(), new Point(4,4));
	}
}
