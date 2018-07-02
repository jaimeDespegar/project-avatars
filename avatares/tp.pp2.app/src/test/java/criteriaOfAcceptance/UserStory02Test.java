package criteriaOfAcceptance;

//import static org.junit.Assert.assertNotNull; 
//import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertNull;
//
//import java.awt.Point;
//
//import object.Rectangle;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import tablero.Map;
//
////import enums.TypeOfStructure;
////import object.Rectangle;
////import object.Structure;
////import tablero.AddStructure;
////import tablero.Builder;
////import tablero.Map;
//
///**
// * 
//Crear un mapa con un tama�o de 3x3, se crea un rect�ngulo n�1 (posici�n (0,1), tama�o (1,2), tipo de estructura (acero)), en el mapa. 
//
//-Si se logra crear el rect�ngulo, las posiciones (0,1) y (0,2)  deber�n quedar ocupadas.
//-Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (0,1) , lanza una excepci�n por dato inv�lido.
//-Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (1,0) , lanza una excepci�n por dato inv�lido.
//-Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (0,0) , lanza una excepci�n por dato inv�lido.
//-Si se quiere crear un rect�ngulo n�2 (posici�n (0,2), tama�o (1,2), tipo de estructura (acero)), en el mismo mapa en el que se ingres� el objeto n�1, en este caso, no se tiene que poder, porque el mapa ya est� ocupado en la posici�n (0,2) por el rect�ngulo n�1.
//-Si se quiere crear un rect�ngulo (posici�n (4,3), tama�o (1,2), tipo de estructura (acero)) me voy de rango con el tama�o de la estructura, deber� devolver una excepci�n.
//-Si se quiere crear un rect�ngulo con posici�n (0,1) , tama�o (2,2) y tipo �Nosoyvalido� , debe lanzar una excepci�n por tipo inv�lido. 
//
// *
// */
//public class UserStory02Test {
//	private Rectangle rectangle;
//	private Map map;
//	
//	/**Crear un mapa con un tama�o de 3x3, se crea un rect�ngulo n�1 (posici�n (0,1), tama�o (1,2), tipo de estructura (acero)), en el mapa.*/
//	@Before
//	public void init() {
//		rectangle = new Rectangle(new Point(0, 1), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
//		map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
//	}
//	/**Si se logra crear el rect�ngulo, las posiciones (0,1) y (0,2)  deber�n quedar ocupadas*/
//	@Test
//	public void testCheckPositions() {
//		assertNotNull(map.getBoard().getBoxes()[0][1]);
//		assertNotNull(map.getBoard().getBoxes()[0][2]);
//	}
//	
//	/**Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (0,1) , lanza una excepci�n por dato inv�lido.*/
//	@Test(expected=AssertionError.class)
//	public void testThrowExceptionByDateInvalid() {
//		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(0, 1),new Structure(TypeOfStructure.ACERO));
//		assertNull(rectangle2);
//	}
//	
//	/**Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (1,0) , lanza una excepci�n por dato inv�lido.*/
//	@Test(expected=AssertionError.class)
//	public void testThrowExceptionByDateInvalid2() {
//		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(1, 0),new Structure(TypeOfStructure.ACERO));
//		assertNull(rectangle2);
//	} 
//	
//	/**Si se crea un rect�ngulo con posici�n (0,1) y tama�o cero (0,0) , lanza una excepci�n por dato inv�lido.*/
//	@Test(expected=AssertionError.class)
//	public void testThrowExceptionByDateInvalid3() {
//		Rectangle rectangle2 = new Rectangle(new Point(0, 1), new Point(0, 0),new Structure(TypeOfStructure.ACERO));
//		assertNull(rectangle2);
//	} 
//	
//	/**Si se quiere crear un rect�ngulo n�2 (posici�n (0,2), tama�o (1,2), tipo de estructura (acero)), 
//	 * en el mismo mapa en el que se ingres� el objeto n�1, en este caso, no se tiene que poder, porque 
//	 * el mapa ya est� ocupado en la posici�n (0,2) por el rect�ngulo n�1.*/
//	@Test(expected=RuntimeException.class)
//	public void testAddRectangleInPositionOcupated() {
//		Rectangle rectangle2 = new Rectangle(new Point(0, 2), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
//		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
//		assertNotSame(rectangle2, map.getBoard().getBoxes()[0][2]);
//	}
//	
//	/**Si se quiere crear un rect�ngulo (posici�n (4,3), tama�o (1,2), tipo de estructura (acero)) 
//	 * me voy de rango con el tama�o de la estructura, deber� devolver una excepci�n.*/
//	@Test(expected=IllegalArgumentException.class)
//	public void testOutOfRangeThrowException() {
//		Rectangle rectangle2 = new Rectangle(new Point(4, 3), new Point(1, 2),new Structure(TypeOfStructure.ACERO));
//		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
//	}
//	
//	/**Si se quiere crear un rect�ngulo con posici�n (0,1) , tama�o (2,2) y tipo �Nosoyvalido� , debe lanzar 
//	 * una excepci�n por tipo inv�lido.*/
//	@Test(expected=RuntimeException.class)
//	public void testInvalidStructure() {
//		Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(1, 1),null);
//		AddStructure.addStructureByRectangle(map.getBoard(), rectangle2);
//	}
//}
