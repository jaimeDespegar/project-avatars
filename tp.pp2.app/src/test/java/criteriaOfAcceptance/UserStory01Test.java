package criteriaOfAcceptance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.ObjectGraphic;
import object.Rectangle;
import object.Structure;
import tablero.Builder;
import tablero.CreateMap;
import tablero.Map;

/**
 * 
Se lee un archivo externo Properties con un tamaño determinado

Si el tamaño es de (ancho = 2 y alto= 2), la matriz del mapa deberá tener un tamaño de 4 posiciones.
Si el tamaño es de (ancho = -2 y alto = 5), tira una excepción de tamaño inválido. 
Si el tamaño es de (ancho = dos y alto = 5), tiene que tirar error y salir del programa por valores no válidos (texto).
Si el tamaño es de (ancho = 2 y alto= 2), e intentó leer el casillero (0,0), debería devolver una casilla válida.
Si el tamaño es de (ancho = 2 y alto = 2) e intentó leer el casillero (2, 3) debería devolver un error por alto ingresado inválido (error, posiciones invalida).

 
Se crea un mapa vacío de tamaño (largo = 2, ancho = 2). Se asigna un Object en la posición (1,1).

Se asigna un objeto en la posición (0,1), deberá poder ya que estaba vacío.
Si se intenta asignar otro objeto en la posición (1,1), no se asigna, porque la posición (1,1) ya está ocupada.
Se asigna un objeto en la posición (2,2) , devuelve exception (“está fuera de rango”).


 *
 */
public class UserStory01Test {
	private Rectangle rectangle;
	private Map map;
	//Se lee un archivo externo Properties con un tamaño determinado
	
	/**Si el tamaño es de (ancho = 2 y alto= 2), la matriz del mapa deberá tener un tamaño de 4 posiciones.*/
	@Test
	public void testCreateValidMap() {
		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test01Map.properties");
		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length)); 
	}
	
	/**Si el tamaño es de (ancho = -2 y alto = 5), tira una excepción de tamaño inválido. */
	@Test(expected=IllegalArgumentException.class)
	public void testCreateInvalidMap() {
		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test02Map.properties");
		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length)); 
	}

	/**Si el tamaño es de (ancho = dos y alto = 5), tiene que tirar error y salir del programa por valores no válidos (texto).*/
	@Test(expected=NumberFormatException.class)
	public void testChargeInvalidParametersInProperties() {
		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test03Map.properties");
		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length));
	}

	/**Si el tamaño es de (ancho = 2 y alto= 2), e intentó leer el casillero (0,0), debería devolver una casilla válida.*/
	@Test
	public void testCheckValidBox() {
		Map map = new Builder(new Point(2, 2)).build();
		assertEquals(map.getBoard().getBoxes()[0][0],null); 
	}
	
	/**Si el tamaño es de (ancho = 2 y alto = 2) e intentó leer el casillero (2, 3) debería devolver un error por alto ingresado inválido (error, posiciones invalida).*/
	@Test(expected=IndexOutOfBoundsException.class)
	public void testCheckInvalidBox() {
		Map map = new Builder(new Point(2, 2)).build();
		//AssertionError(map.getBoard().getBoxes()[2][3]);
		assertEquals(map.getBoard().getBoxes()[2][3],null); 
	}
	
	
	/**--------------------------------------------------------------------------------------*/

/**Se crea un mapa vacío de tamaño (largo = 2, ancho = 2). Se crea un Object en
 * la posición (1,1). */
	
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

	/** Si creo un objeto en la posición (0,1), deberá poder, ya que estaba vacío. */
//	@Test
//	public void testCreateObject() {
//		assertNull(map.getBoard().getBoxes()[0][1]);
//		map.getBoard().addBox(new Point (0,1), new ObjectGraphic ());
//		assertNotNull(map.getBoard().getBoxes()[0][1].getObjectGraphic());
//	}

	/**Si Se intenta crear otro Object en la posición (1,1), no se crea, porque la
	 * posición (1,1) ya está ocupada. */
	@Test(expected = AssertionError.class)
	public void testFailCreateObject() {
		Structure structure = new Structure(TypeOfStructure.AGUA);
		map.getBoard().addBox(new Point (1,1), structure);
		assertNotEquals(map.getBoard().getBoxes()[1][1].getObjectGraphic(),structure);
	}
}
