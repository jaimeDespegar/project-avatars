package control;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Rectangle;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class ControlFreePositionTest {
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	private Ax hacha;

	
	/**
	 Se crea un mapa de tama�o 4x4, y se crea un rect�ngulo ((1,2), (2,2), acero). 
	 Adem�s se crea un Avatar en la posici�n (0,0) con orientaci�n hacia la derecha, vida=100 
	 y un Avatar con escudo en la posici�n (3,0) con orientaci�n hacia la izquierda, vida = 100.
	 */
	@Before
	public void UserStoryGeneral(){
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
	hacha= new Ax(90, 1, Orientation.RIGHT);
	Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}
	
	@Test
	public void freePoTest(){
		
		ControlFreePosition c= new ControlFreePosition(a, map, hacha);
		OperatorScroll os= new OperatorScrollFirstValue(1,1);
		OperatorScroll os2= new OperatorScrollLastValue(1,1,1,1);
		
		c.asignarPrimerPosicionLibre();
		c.asignarUltimaPosicionLibre();
		c.scrollMap(map, os);
		os.getFirstInit();
		os.getSecondInit();
		os.getOperation(1);
		os.isFinish(1, 1);
		os.getInitSize();
		os.getSecondSize();
		c.scrollMap(map, os2);
		os2.getFirstInit();
		os2.getSecondInit();
		os2.getOperation(1);
		os2.isFinish(1, 1);
		os2.getInitSize();
		os2.getSecondSize();
	}
	
}
