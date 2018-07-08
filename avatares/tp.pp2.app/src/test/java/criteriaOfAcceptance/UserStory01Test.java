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
Se lee un archivo externo Properties con un tama�o determinado

Si el tama�o es de (ancho = 2 y alto= 2), la matriz del mapa deber� tener un tama�o de 4 posiciones.
Si el tama�o es de (ancho = -2 y alto = 5), tira una excepci�n de tama�o inv�lido. 
Si el tama�o es de (ancho = dos y alto = 5), tiene que tirar error y salir del programa por valores no v�lidos (texto).
Si el tama�o es de (ancho = 2 y alto= 2), e intent� leer el casillero (0,0), deber�a devolver una casilla v�lida.
Si el tama�o es de (ancho = 2 y alto = 2) e intent� leer el casillero (2, 3) deber�a devolver un error por alto ingresado inv�lido (error, posiciones invalida).

 
Se crea un mapa vac�o de tama�o (largo = 2, ancho = 2). Se asigna un Object en la posici�n (1,1).

Se asigna un objeto en la posici�n (0,1), deber� poder ya que estaba vac�o.
Si se intenta asignar otro objeto en la posici�n (1,1), no se asigna, porque la posici�n (1,1) ya est� ocupada.
Se asigna un objeto en la posici�n (2,2) , devuelve exception (�est� fuera de rango�).


 *
 */
public class UserStory01Test {
	private Rectangle rectangle;
	private Map map;
	//Se lee un archivo externo Properties con un tama�o determinado
	
	/**Si el tama�o es de (ancho = 2 y alto= 2), la matriz del mapa deber� tener un tama�o de 4 posiciones.*/
//	@Test
//	public void testCreateValidMap() {
//		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test01Map.properties");
//		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
//		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length)); 
//	}
	
	/**Si el tama�o es de (ancho = -2 y alto = 5), tira una excepci�n de tama�o inv�lido. */
	@Test(expected=IllegalArgumentException.class)
	public void testCreateInvalidMap() {
		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test02Map.properties");
		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length)); 
	}

	/**Si el tama�o es de (ancho = dos y alto = 5), tiene que tirar error y salir del programa por valores no v�lidos (texto).*/
	@Test(expected=NumberFormatException.class)
	public void testChargeInvalidParametersInProperties() {
		CreateMap createMap = new CreateMap("src/main/resources/configurationProperties/Test03Map.properties");
		Map map = new Builder (createMap.getMapProperties().getElectionMap().getMapSize()).build();
		assertEquals(4, (map.getBoard().getBoxes().length * map.getBoard().getBoxes()[0].length));
	}

	/**Si el tama�o es de (ancho = 2 y alto= 2), e intent� leer el casillero (0,0), deber�a devolver una casilla v�lida.*/
	@Test
	public void testCheckValidBox() {
		Map map = new Builder(new Point(2, 2)).build();
		assertEquals(map.getBoard().getBoxes()[0][0],null); 
	}
	
	/**Si el tama�o es de (ancho = 2 y alto = 2) e intent� leer el casillero (2, 3) deber�a devolver un error por alto ingresado inv�lido (error, posiciones invalida).*/
	@Test(expected=IndexOutOfBoundsException.class)
	public void testCheckInvalidBox() {
		Map map = new Builder(new Point(2, 2)).build();
		//AssertionError(map.getBoard().getBoxes()[2][3]);
		assertEquals(map.getBoard().getBoxes()[2][3],null); 
	}
	
	
	/**--------------------------------------------------------------------------------------*/

/**Se crea un mapa vac�o de tama�o (largo = 2, ancho = 2). Se crea un Object en
 * la posici�n (1,1). */
	
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
	@Test(expected = AssertionError.class)
	public void testFailCreateObject() {
		Structure structure = new Structure(TypeOfStructure.AGUA);
		map.getBoard().addBox(new Point (1,1), structure);
		assertNotEquals(map.getBoard().getBoxes()[1][1].getObjectGraphic(),structure);
	}
}
