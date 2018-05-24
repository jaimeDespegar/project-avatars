package criteriaOfAcceptance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Test;

import enums.TypeOfStructure;
import tablero.Box;
import tablero.Builder;
import tablero.Map;
import tablero.ObjectGraphic;
import tablero.Rectangle;
import tablero.Structure;

/**
 * 
 * Se crea un mapa vacío de tamaño (largo = 2, ancho = 2). Se crea un Object en
 * la posición (1,1).
 * 
 * _Si creo un objeto en la posición (0,1), deberá poder ya que estaba vacío.
 * _Si Se intenta crear otro Object en la posición (1,1), no se crea, porque la
 * posición (1,1) ya está ocupada.
 *
 * 
 */
public class UserStory_02 {
//	private Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(1, 1),
//			new Structure(null, TypeOfStructure.ACERO));
//	private Map map = new Builder(new Point(2, 2)).withStructureRectangle(rectangle).build();
//	
//	/**En la posicion (0,1), debe estar vacia*/
//	@Test
//	public void testEmptyBox() {
//		assertNull(map.getBoard().getBoard()[0][1]);
//	}
//
//	/** Si creo un objeto en la posición (0,1), deberá poder, ya que estaba vacío. */
//	@Test
//	public void testCreateObject() {
//		map.getBoard().addObjectGraphic(new Point (0,1), new ObjectGraphic (new Point (0,1)));
//		assertNotNull(map.getBoard().getBoard()[0][1].getObjectGraphic());
//	}
//
//	/**
//	 * Si Se intenta crear otro Object en la posición (1,1), no se crea, porque la
//	 * posición (1,1) ya está ocupada.
//	 */
//	@Test
//	public void testFailCreateObject() {
//		assertNull(map.getBoard().getBoard()[0][1].getObjectGraphic());
//	}
}
