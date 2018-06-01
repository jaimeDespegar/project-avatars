package tablero;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import enums.TypeOfStructure;
import object.Structure;

public class TestBox {
	
	@Test
	public void testCreateBox() {
		Box box = new Box(new Structure(TypeOfStructure.AGUA));
		assertNotNull(box);
	}

	@Test
	public void testGetBox() {
		Box box = new Box(new Structure(TypeOfStructure.AGUA));
		assertNotNull(box.getObjectGraphic());
	}

	@Test
	public void testSetBox() {
		Box box1 = new Box(new Structure(TypeOfStructure.AGUA));
		Box box2 = new Box(new Structure(TypeOfStructure.AGUA));
		box1.setObjectGraphic(new Structure(TypeOfStructure.ACERO));
		assertNotEquals(box1, box2);
	}
}
