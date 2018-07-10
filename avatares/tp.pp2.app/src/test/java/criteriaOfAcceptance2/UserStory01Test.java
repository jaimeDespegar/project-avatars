package criteriaOfAcceptance2;


import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Rectangle;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import control.ControlColissionShoot;
import control.ControlPositionMovement;
import tablero.Builder;
import tablero.Map;
import turn.ControllerPlayerTurn;
import enums.Orientation;
import enums.TypeOfStructure;

public class UserStory01Test {

	/**Se crea un mapa de Tamaño 3*3, un Avatar A (con vida 50) en la posición (0,0) y un Enemy B (con vida 50) en la posición (2,0), 
	 * también se crea un rectángulo ((1,1), (2,2), acero)*/
	private Map map;
	private Avatar a;
	private Avatar a2;
	private Ax hacha;
	private ControllerPlayerTurn cpt;
	
	@Before
	public void init(){
	this.a= new Avatar(100, Orientation.RIGHT,1);
	this.a2= new Avatar(100, Orientation.LEFT,2);
	Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	this.map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
	this.map.getBoard().addBox(new Point(0,0), a);
	a.setPosition(new Point(0,0));
	this.map.getBoard().addBox(new Point(2,0), a2);	
	a2.setPosition(new Point(2,0));
	map.printMap();
	hacha= new Ax(90, 1, Orientation.RIGHT);
	
	List<String> ids= new ArrayList<String>();
	ids.add(a.getId().toString());
	ids.add(a2.getId().toString());
	cpt= new ControllerPlayerTurn(ids);
	}
	
	/**Si A se mueve a la derecha, y disparar a la derecha. Se termina su turno para hacer una jugada,
	 *  si presiona una tecla para cambiar de posición no tiene efecto.
	 */
	@Test
	public void test01() {
		ControlPositionMovement cpm= new ControlPositionMovement(a, map, hacha);
		cpm.avanzar(a.getPosition());
		assertEquals(new Point(1,0), a.getPosition());//a avanza 1 casillero
		
		ControlColissionShoot ccs= new ControlColissionShoot(a,map,hacha);
		ccs.disparar(a2);
		assertEquals(10, a2.getVida());//a dispara a a2, dañandolo
		cpt.next();
		
		
	}
}