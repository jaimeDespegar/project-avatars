package control;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class WeaponControllerTest {
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	private Ax hacha;
	private Bazooka bazooka1;
	private Shotgun escopeta;
	
	/**
	 Se crea un mapa de tama�o 4x4, y se crea un rect�ngulo ((1,2), (2,2), acero). 
	 Adem�s se crea un Avatar en la posici�n (0,0) con orientaci�n hacia la derecha, vida=100 
	 y un Avatar con escudo en la posici�n (3,0) con orientaci�n hacia la izquierda, vida = 100.
	 */
	@Before
	public void UserStory5(){
	a= new Avatar(100, Orientation.UP,1);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
	
	hacha= new Ax(90, 1, Orientation.UP);
	hacha.setPosition(a.getPosition());
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	bazooka1.setPosition(aws.getPosition());
	escopeta= new Shotgun(70, 3, Orientation.DOWN);
	
	Rectangle rectangle = new Rectangle(new Point(3, 3), new Point(1, 1),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}
	
	@Test
	public void weaponTest(){
		a.setPosition(new Point(0,1));
		WeaponController w= new WeaponController(a, map, hacha);
		w.avanzarRangoDisparo(hacha.getPosition());
		WeaponController w2= new WeaponController(aws, map, bazooka1);
		w2.avanzarRangoDisparo(bazooka1.getPosition());
		Avatar a2= new Avatar(100,Orientation.DOWN,1);
		a2.setPosition(new Point(2,1));
		WeaponController w3= new WeaponController(a2, map, escopeta);
		w3.avanzarRangoDisparo(escopeta.getPosition());
		
		hacha.setPosition(a.getPosition());
		escopeta.setPosition(a2.getPosition());
		w.avanzar(hacha.getPosition());
		w3.avanzar(escopeta.getPosition());
	}
	@Test
	public void weaponAvanzarTest(){
		WeaponController w= new WeaponController(a, map, hacha);
		Avatar a2= new Avatar(100,Orientation.DOWN,1);
		a2.setPosition(new Point(1,1));
		escopeta.setPosition(a2.getPosition());
		WeaponController w3= new WeaponController(a2, map, escopeta);
		w.avanzar(hacha.getPosition());
		w3.avanzar(escopeta.getPosition());
		
		w.colissionWeapon(a2, hacha);
		
	}
}
