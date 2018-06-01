package criteriaOfAcceptance;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.Rectangle;
import object.Structure;
import tablero.AddStructure;
import tablero.Builder;
import tablero.Map;

/**
 * 
Crear un mapa con un tamaño de 3x3, se crea un rectángulo nº1 (posición (0,1), tamaño (1,2), tipo de estructura (acero)), en el mapa. 

-Si se logra crear el rectángulo, las posiciones (0,1) y (0,2)  deberán quedar ocupadas.
-Si se crea un rectángulo con posición (0,1) y tamaño cero (0,1) , lanza una excepción por dato inválido.
-Si se crea un rectángulo con posición (0,1) y tamaño cero (1,0) , lanza una excepción por dato inválido.
-Si se crea un rectángulo con posición (0,1) y tamaño cero (0,0) , lanza una excepción por dato inválido.
-Si se quiere crear un rectángulo nº2 (posición (0,2), tamaño (1,2), tipo de estructura (acero)), en el mismo mapa en el que se ingresó el objeto nº1, en este caso, no se tiene que poder, porque el mapa ya está ocupado en la posición (0,2) por el rectángulo nº1.
-Si se quiere crear un rectángulo (posición (4,3), tamaño (1,2), tipo de estructura (acero)) me voy de rango con el tamaño de la estructura, deberá devolver una excepción.
-Si se quiere crear un rectángulo con posición (0,1) , tamaño (2,2) y tipo “Nosoyvalido” , debe lanzar una excepción por tipo inválido. 

 *
 */
public class UserStory02Test {
	private Rectangle rectangle;
	private Map map;
	
	/**Crear un mapa con un tamaño de 3x3, se crea un rectángulo nº1 (posición (0,1), tamaño (1,2), tipo de estructura (acero)), en el mapa.*/
	@Before
	public void init() {
		rectangle = new Rectangle(new Point(0, 1), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
		map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
	}
	/**Si se logra crear el rectángulo, las posiciones (0,1) y (0,2)  deberán quedar ocupadas*/
	@Test
	public void testCheckPositions() {
		assertNotNull(map.getBoard().getBoxes()[0][1]);
		assertNotNull(map.getBoard().getBoxes()[0][2]);
	}
	
	/**Si se crea un rectángulo con posición (0,1) y tamaño cero (0,1) , lanza una excepción por dato inválido.*/
	@Test(expected=AssertionError.class)
	public void testThrowExceptionByDateInvalid() {
		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(0, 1),new Structure(TypeOfStructure.ACERO));
		assertNull(rectangle2);
	}
	
	/**Si se crea un rectángulo con posición (0,1) y tamaño cero (1,0) , lanza una excepción por dato inválido.*/
	@Test(expected=AssertionError.class)
	public void testThrowExceptionByDateInvalid2() {
		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(1, 0),new Structure(TypeOfStructure.ACERO));
		assertNull(rectangle2);
	} 
	
	/**Si se crea un rectángulo con posición (0,1) y tamaño cero (0,0) , lanza una excepción por dato inválido.*/
	@Test(expected=AssertionError.class)
	public void testThrowExceptionByDateInvalid3() {
		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(0, 0),new Structure(TypeOfStructure.ACERO));
		assertNull(rectangle2);
	} 
	
	/**Si se quiere crear un rectángulo nº2 (posición (0,2), tamaño (1,2), tipo de estructura (acero)), 
	 * en el mismo mapa en el que se ingresó el objeto nº1, en este caso, no se tiene que poder, porque 
	 * el mapa ya está ocupado en la posición (0,2) por el rectángulo nº1.*/
	@Test(expected=RuntimeException.class)
	public void testAddRectangleInPositionOcupated() {
		Rectangle rectangle2 = new Rectangle(new Point(0, 2), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
		assertNotSame(rectangle2, map.getBoard().getBoxes()[0][2]);
	}
	
	/**Si se quiere crear un rectángulo (posición (4,3), tamaño (1,2), tipo de estructura (acero)) 
	 * me voy de rango con el tamaño de la estructura, deberá devolver una excepción.*/
	@Test(expected=IllegalArgumentException.class)
	public void testOutOfRangeThrowException() {
		Rectangle rectangle2 = new Rectangle(new Point(4, 3), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
	}
	
	/**Si se quiere crear un rectángulo con posición (0,1) , tamaño (2,2) y tipo “Nosoyvalido” , debe lanzar 
	 * una excepción por tipo inválido.*/
	@Test(expected=AssertionError.class)
	public void testInvalidStructure() {
		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(2, 2),null);
		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
	}
}
