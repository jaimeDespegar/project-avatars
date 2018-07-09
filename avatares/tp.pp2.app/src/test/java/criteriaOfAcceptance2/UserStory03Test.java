package criteriaOfAcceptance2;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.AvatarWithShield;
import object.Rectangle;
import object.Structure;
import tablero.Builder;
import tablero.Map;

public class UserStory03Test {
	/**Se crea un mapa de Tamaño 3*3, un Avatar A (con vida 50) en la posición (0,0) y un Enemy B (con vida 50) en la posición (2,0), 
	 * también se crea un rectángulo ((1,1), (2,2), acero)*/
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	
	@Before
	public void init(){
	this.a= new Avatar(100, Orientation.RIGHT,1);
	this.aws= new AvatarWithShield(100, Orientation.LEFT);
	Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	this.map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
	this.map.getBoard().addBox(new Point(0,0), a);
	this.map.getBoard().addBox(new Point(2,0), aws);	
	}	
	
	/**	Después de 4 turnos (2 por Avatar), en los cuáles los avatares no se movieron, a cada uno de ellos le aparece un poder aleatorio, no necesariamente es el mismo.
	A y B al iniciar el juego no tiene poderes temporales.*/
	@Test
	public void test01() {
		
	}
	
	/**Si para A pasan dos turnos se le asigna un poder temporal aleatorio.*/
	@Test
	public void test02() {
		
	}
	
	/**Si A tiene un poder temporal en un turno y lo utiliza en el siguiente turno ya no lo tiene disponible*/
	@Test
	public void test03() {
		
	}
	
	/**Si A tiene un poder temporal en un turno y no lo utiliza en el siguiente turno ya no lo tiene disponible*/
	@Test
	public void test04() {
		
	}
}
