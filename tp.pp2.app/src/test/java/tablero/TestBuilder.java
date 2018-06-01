package tablero;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Test;

import enums.TypeOfStructure;
import object.Rectangle;
import object.Structure;

public class TestBuilder {
	
	@Test
	public void testCreateBoard() {
		Builder builder = new Builder(new Point (3,3));
		assertNotNull(builder.getBoard());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailCreateBoard() {
		Builder builder = new Builder(null);
		assertNull(builder.getBoard());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailCreateBoard2() {
		Builder builder = new Builder(new Point(1,1));
		assertNull(builder.getBoard());
	}
	
	@Test
	public void testWithStructureRectangle() {
		Rectangle rectangle = new Rectangle(new Point(1,1), new Point(2,2),new Structure(TypeOfStructure.ACERO));
		Builder builder = new Builder(new Point(4,4)).withStructureRectangle(rectangle);
		assertNotNull(builder.getBoard().getBox(new Point(2,2)));
	}

	@Test(expected = NullPointerException.class)
	public void testFailWithStructureRectangle() {
		Builder builder = new Builder(new Point(4,4)).withStructureRectangle(null);
		assertNull(builder.getBoard().getBox(new Point(2,2)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailWithStructureRectangle2() {
		Rectangle rectangle = new Rectangle(new Point(1,1), new Point(6,6),new Structure(TypeOfStructure.ACERO));
		Builder builder = new Builder(new Point(4,4)).withStructureRectangle(rectangle);
		assertNull(builder.getBoard().getBox(new Point(2,2)));
	}
}
