package criteriaOfAcceptance;

import static org.junit.Assert.*;

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

/**
 * 
 * Se crea un mapa de dimensión (3,3), con los casilleros (0,0) y (2,2) ocupados
 * con el objeto de estructura de tipo acero.
 *
 */
public class UserStory04Test {

	private Map map;

	@Before
	public void UserStory04() {
		Rectangle rectangle1 = new Rectangle(new Point(0, 0), new Point(1, 1), new Structure(TypeOfStructure.ACERO));
		Rectangle rectangle2 = new Rectangle(new Point(2, 2), new Point(1, 1), new Structure(TypeOfStructure.ACERO));
		map = new Builder(new Point(3, 5)).withStructureRectangle(rectangle1).withStructureRectangle(rectangle2).build();

	}


	/**Si se crea el personaje avatar con vida = 100 y orientación = derecha, este se debe crear en la posición (0,1) del mapa, 
	 * al pedirle al mapa la posición (0,1), me debe devolver el avatar.*/
	@Test
	public void ingresarAvatarPrimerCasilleroLibre(){
		Avatar a = new Avatar(100,Orientation.RIGHT);
		map.addBox(new Point(0,1), a);
		assertTrue(map.getBox(new Point(0,1)).getObjectGraphic().equals(a));
	}
	
	/**Si se crea el personaje avatar con escudo, este se debe crear en la posición (1,2), al pedirle al mapa la posición (1,2), m
	 * e debe devolver el avatar con escudo.*/
	@Test
	public void ingresarAvatarWithShieldUltimoCasilleroLibre() {
		AvatarWithShield aws = new AvatarWithShield(100,Orientation.UP);
		map.getBoard().addBox(new Point(1,2), aws);
		assertTrue(map.getBox(new Point(1,2)).getObjectGraphic().equals(aws));
	}
}
