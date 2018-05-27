package criteriaOfAcceptance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import tablero.Builder;
import tablero.Map;
import tablero.ObjectGraphic;
import tablero.Rectangle;
import tablero.Structure;

/**Se crea un mapa vac�o de tama�o (largo = 2, ancho = 2). Se crea un Object en
 * la posici�n (1,1). */
public class UserStory_02 {
	private Rectangle rectangle;
	private Map map;
	
	@Before
	public void init() {
		rectangle = new Rectangle(new Point(1, 1), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
		map = new Builder(new Point(2, 2)).withStructureRectangle(rectangle).build();
	}
	
	/**En la posicion (0,1), debe estar vacia*/
	@Test
	public void testEmptyBox() {
		assertNull(map.getBoard().getBoxes()[0][1]);
	}

	/** Si creo un objeto en la posici�n (0,1), deber� poder, ya que estaba vac�o. */
	@Test
	public void testCreateObject() {
		assertNull(map.getBoard().getBoxes()[0][1]);
		map.getBoard().addBox(new Point (0,1), new ObjectGraphic ());
		assertNotNull(map.getBoard().getBoxes()[0][1].getObjectGraphic());
	}

	/**Si Se intenta crear otro Object en la posici�n (1,1), no se crea, porque la
	 * posici�n (1,1) ya est� ocupada. */
	@Test
	public void testFailCreateObject() {
		map.getBoard().addBox(new Point (0,1), new ObjectGraphic ());
		assertNull(map.getBoard().getBoxes()[0][1].getObjectGraphic());
	}
}
