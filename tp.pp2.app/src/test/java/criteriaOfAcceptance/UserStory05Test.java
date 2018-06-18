package criteriaOfAcceptance;

import static org.junit.Assert.*; 
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import control.ControlPositionMovement;
import control.ControlTurn;
import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.AvatarWithShield;
import object.Rectangle;
import object.Structure;
import tablero.Builder;
import tablero.Map;

/**
Se crea un mapa de tamaño 3x3, y se crea un rectángulo ((1,1), (2,2), acero). 
Avatar en posición (0,0) y orientación hacia derecha.  
El Avatar con escudo en (0,2) con orientación hacia derecha.
 */

public class UserStory05Test {
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	private Point aPoint;
	private Point awsPoint;
	
	@Before
	public void UserStory5(){
	Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	aPoint= new Point(0,0);
	awsPoint= new Point(0,2); 
	map.addBox(aPoint, a);
	map.addBox(awsPoint, aws);	
	}
	
	/**Si el Avatar está con orientación a la derecha e intenta avanzar un casillero, entonces el avatar deberá ocupar la posición (1,0).*/
	@Test
	public void moveAverageAvatarWithOrientationRight(){
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.avanzar(aPoint);
		assertTrue(map.getBox(new Point(1,0)).getObjectGraphic().equals(a));
	}
	
	/**Si el Avatar intenta retroceder un casillero, entonces el avatar deberá seguir ocupando la posición (0,0).*/
	@Test
	public void backwardLeftAvatar(){
		ControlPositionMovement c= new ControlPositionMovement(a, map, null);   
		c.retroceder(aPoint);
		assertTrue(map.getBox(new Point(0,0)).getObjectGraphic().equals(a));
	}
	
	/**Si el Avatar intenta girar a la derecha, entonces el Avatar tendrá orientación hacia abajo.*/
	@Test
	public void girarAvatarDerecha(){
		ControlTurn t = new ControlTurn(a, map, null);
		t.girarHaciaDerecha();
		assertTrue(a.getOrientation().equals(Orientation.DOWN));
	}
	
	/**Si el Avatar con escudo intenta retroceder un casillero, entonces el avatar con escudo deberá seguir ocupando la posición (0,2).*/
	@Test
	public void avanzarDerechaAvatarConEscudo(){
		ControlPositionMovement c= new ControlPositionMovement(aws, map, null);   
		c.avanzar(awsPoint);
		assertTrue(aws.getPosition().equals(new Point(0,2)));
	}

	/**Si el Avatar con escudo  girar a la izquierda, entonces el Avatar con escudo tendrá orientación hacia arriba.*/
	@Test
	public void girarAvatarConEscudoIzquierda(){
		ControlTurn t= new ControlTurn(aws, map, null);
		t.girarHaciaIzquierda();;
		assertTrue(aws.getOrientation().equals(Orientation.UP));
	}
}
