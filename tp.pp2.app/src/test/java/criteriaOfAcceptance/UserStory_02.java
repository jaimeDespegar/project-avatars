package criteriaOfAcceptance;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Test;

import enums.TypeOfStructure;
import tablero.Builder;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;

/**
 * 
 * Se crea un mapa vacío de tamaño (largo = 2, ancho = 2). Se crea un Object en la posición (1,1).
 
   _Si creo un objeto en la posición (0,1), deberá poder ya que estaba vacío.
   _Si Se intenta crear otro Object en la posición (1,1), no se crea, porque la posición (1,1) ya está ocupada.

 *
 */
public class UserStory_02 {
	//public static void main(String[] args) {
	//Map map = new Builder(new Point(2, 2)).withStructureRectangle(
	//		new Rectangle(new Point(0, 1), new Point(1, 1), new Structure(null, TypeOfStructure.ACERO))).build();
	//map.printMap();
	//}
	@Test
	public void testCreateObject() {
		Map map = new Builder(new Point(2, 2)).withStructureRectangle(
				new Rectangle(new Point(0, 1), new Point(1, 1), new Structure(null, TypeOfStructure.ACERO))).build();
		assertEquals((new Structure(null, TypeOfStructure.ACERO)), map.getBoard().getBoard()[0][1].getObjectGraphic());//Null(map.getBoard().getBoard()[0][1]);
	}
}
