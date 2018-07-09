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

public class UserStory02Test {
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
	
	/**Si A tiene el poder de fuego aumenta en 30 el disparo impactando en B.*/
	@Test
	public void test01() {
		
	}
	
	/**Si A tiene el poder de doble superfuerza duplica el disparo impactando en B.*/
	@Test
	public void test02() {
		
	}
	
	/**Si A tiene el poder de fuego y de superfuerza, aumenta su disparo en 30 y duplica este impacto sobre B*/
	@Test
	public void test03() {
		
	}
	
	/**Si A tiene el poder de superfuerza y de fuego luego, duplica su disparo y aumenta en 3 el impacto sobre B*/
	@Test
	public void test04() {
		
	}
}
