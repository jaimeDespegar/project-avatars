package tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestCreateListOfPointsLine {

	@Before
	public void init() {
		
	}
	
	@Test
	public void testCreateListOfPositionsLine() {
		assertNotNull(CreateListOfPointsLine.createListOfPositionsLine(new Point(1,1), new Point(2,2)));
	}
	
	@Test (expected=RuntimeException.class)
	public void testFailToCreateListOfPositionsLine() {
		CreateListOfPointsLine.createListOfPositionsLine(new Point(-1,1), new Point(2,2));
	}
	
	@Test (expected=RuntimeException.class)
	public void testFailToCreateListOfPositionsLine2() {
		CreateListOfPointsLine.createListOfPositionsLine(new Point(1,1), null);
	}
	
	@Test
	public void testAddLineHorizontal() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineHorizontal(new Point(1,1), new Point(4,1), positionsOfLine);
		assertEquals(positionsOfLine.size(),4);
	}
	
	@Test(expected=AssertionError.class)
	public void testFailAddLineHorizontal() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineHorizontal(new Point(1,1), new Point(1,4), positionsOfLine);
		assertEquals(positionsOfLine.size(),4);
	}

	@Test
	public void testAddLineVertical() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineVertical(new Point(1,1), new Point(1,3), positionsOfLine);
		assertEquals(positionsOfLine.size(),3);
	}

	@Test(expected=AssertionError.class)
	public void testFailAddLineVertical() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineVertical(new Point(1,1), new Point(3,1), positionsOfLine);
		assertEquals(positionsOfLine.size(),3);
	}

	@Test
	public void testAddLineDiagonal() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineDiagonal(new Point(1,1), new Point(3,3), positionsOfLine);
		assertEquals(positionsOfLine.size(),3);
	}

	@Test(expected=AssertionError.class)
	public void testFailAddLineDiagonal() {
		List<Point> positionsOfLine = new ArrayList<Point>();
		CreateListOfPointsLine.addLineDiagonal(new Point(1,1), new Point(2,1), positionsOfLine);
		assertEquals(positionsOfLine.size(),3);
	}
}
