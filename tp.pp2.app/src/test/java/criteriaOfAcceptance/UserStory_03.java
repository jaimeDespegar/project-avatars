package criteriaOfAcceptance;
/**Crear un mapa vac�o con un tama�o de 6x6


Una l�nea horizontal (5,5) al (7,5), se va de rango, no es v�lido. Se lanza una excepci�n de parametro invalido.
Si creo una l�nea horizontal (1,1) al (2,1), est� dentro del rango, es v�lido.
Si creo una l�nea vertical (1,0) al (1,7), se va de rango, no es v�lido.
Si creo una l�nea vertical (0,0) al (0,2), est� dentro del rango, es v�lido.
Si creo una l�nea diagonal (4,4) al (7,7), se va de rango, no es v�lido.
Si creo una l�nea diagonal (0,0) al (2,2), est� dentro del rango, es v�lido.
Se ingresan las posiciones {(5,5),(1,1)} , {(1,3),(1,5)} y {(3,1), (4,1)}, por lo tanto, la l�nea va del punto (5,5), hasta el (1,1), despu�s del (1,3) al (1,5), luego del (3,1) al (4,1) como todas est�n libres, se agregan todas las estructuras. Quedando el mapa de la siguiente manera:

Se ingresan las posiciones {(2,5),(5,5)}, por lo tanto, la l�nea va del punto (2,5), hasta el (5,5), como la posici�n (5,5) est� ocupada, no se agrega ninguna estructura de la l�nea ingresada. 
Si se ingresan los puntos {(4,4), (2,4)}, no se puede ya que los casilleros que est�n dentro del recorrido se encuentra el (4,4) que est� ocupado.
Si se  ingresan los puntos {(0,0), (2,5)}, no se puede debido a que no forman una l�nea recta diagonal.
Si se ingresan los puntos {(0,0), (3,5)}, no se puede debido a que no forman una l�nea recta horizontal.
Si se ingresan los puntos {(0,0), (4,5)}, no se puede debido a que no forman una l�nea recta vertical.
*/

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.TypeOfStructure;
import object.Line;
import object.Structure;
import tablero.AddStructure;
import tablero.Builder;
import tablero.Map;
import tablero.UtilCreateListByLine;

public class UserStory_03 {
	private Map map;

	/**Crear un mapa vac�o con un tama�o de 6x6*/
	@Before
	public void init() {
		map = new Builder(new Point(6, 6)).build();
	}
	
	/**Una l�nea horizontal (5,5) al (7,5), se va de rango, no es v�lido. Se lanza una excepci�n de parametro invalido.*/
	@Test(expected=IllegalArgumentException.class)
	public void testLineOutOfRangeHorizontal() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(5,5), new Point(7,5)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Si creo una l�nea horizontal (1,1) al (2,1), est� dentro del rango, es v�lido.*/
	@Test
	public void testAddLineHorizontal() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(1,1), new Point(2,1)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
		assertNotNull(map.getBoard().getBoxes()[1][1].getObjectGraphic());
		assertNotNull(map.getBoard().getBoxes()[2][1].getObjectGraphic());
	}
	
	/**Si creo una l�nea vertical (1,0) al (1,7), se va de rango, no es v�lido.*/
	@Test(expected=IllegalArgumentException.class)
	public void testLineOutOfRangeVertical() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(1,0), new Point(1,7)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Si creo una l�nea vertical (0,0) al (0,2), est� dentro del rango, es v�lido.*/
	@Test
	public void testAddLineVertical() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(0,0), new Point(0,2)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
		assertNotNull(map.getBoard().getBoxes()[0][0].getObjectGraphic());
		assertNotNull(map.getBoard().getBoxes()[0][1].getObjectGraphic());
		assertNotNull(map.getBoard().getBoxes()[0][2].getObjectGraphic());
	}
	
	/**Si creo una l�nea diagonal (4,4) al (7,7), se va de rango, no es v�lido.*/
	@Test(expected=IllegalArgumentException.class)
	public void testOutOfRangeDiagonal() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(4,4), new Point(7,7)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Si creo una l�nea diagonal (0,0) al (2,2), est� dentro del rango, es v�lido.*/
	@Test
	public void testAddLineDiagonal() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(0,0), new Point(2,2)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
		assertNotNull(map.getBoard().getBoxes()[0][0].getObjectGraphic());
		assertNotNull(map.getBoard().getBoxes()[1][1].getObjectGraphic());
		assertNotNull(map.getBoard().getBoxes()[2][2].getObjectGraphic());
	}
	
	/**Se ingresan las posiciones {(5,5),(1,1)} , {(1,3),(1,5)} y {(3,1), (4,1)}, por lo tanto, la l�nea va 
	 * del punto (5,5), hasta el (1,1), despu�s del (1,3) al (1,5), luego del (3,1) al (4,1) como todas 
	 * est�n libres, se agregan todas las estructuras. Quedando el mapa de la siguiente manera:*/
	public void AddStructuresByLine() {
		Line line = new Line(UtilCreateListByLine.createList(new Point(5,5), new Point(1,1)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
		line = new Line(UtilCreateListByLine.createList(new Point(1,3), new Point(1,5)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
		line = new Line(UtilCreateListByLine.createList(new Point(3,1), new Point(4,1)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Se ingresan las posiciones {(2,5),(5,5)}, por lo tanto, la l�nea va del punto (2,5), hasta el (5,5), 
	 * como la posici�n (5,5) est� ocupada, no se agrega ninguna estructura de la l�nea ingresada.*/
	@Test(expected=RuntimeException.class)
	public void testTryToAddLineToPostionOcupated() {
		AddStructuresByLine();
		Line line = new Line(UtilCreateListByLine.createList(new Point(2,5), new Point(5,5)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Si se ingresan los puntos {(4,4), (2,4)}, no se puede ya que los casilleros que est�n dentro del recorrido se encuentra el (4,4) que est� ocupado.*/
	@Test(expected=RuntimeException.class)
	public void testPositionOcupatedHoizontal() {
		AddStructuresByLine();
		Line line = new Line(UtilCreateListByLine.createList(new Point(4,4), new Point(2,4)), new Structure(TypeOfStructure.ACERO));
		AddStructure.addStructureByLine(map.getBoard(), line);
	}
	
	/**Si se  ingresan los puntos {(0,0), (2,5)}, no se puede debido a que no forman una l�nea recta diagonal.*/
	@Test
	public void test() {
		
	}
	/**Si se ingresan los puntos {(0,0), (3,5)}, no se puede debido a que no forman una l�nea recta horizontal.*/
	/**Si se ingresan los puntos {(0,0), (4,5)}, no se puede debido a que no forman una l�nea recta vertical.*/
}
