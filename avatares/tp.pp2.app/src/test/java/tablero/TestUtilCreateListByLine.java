package tablero;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

public class TestUtilCreateListByLine {

	@Test
	public void testCreateListByLine() {
		assertEquals(UtilCreateListByLine.createList(new Point(1,1), new Point(2,2)).size(), 2);
	}
}
