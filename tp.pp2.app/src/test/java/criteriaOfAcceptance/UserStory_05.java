package criteriaOfAcceptance;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
import enums.Orientation;
import object.Avatar;
import object.AvatarWithShield;
import tablero.Builder;
import tablero.Map;
import tablero.Rectangle;




/**
 * 
 *Se crea un mapa de tamaño 3x3, y se crea un rectángulo ((1,1), (2,2), acero). Avatar en posición (0,0) y Avatar con escudo en (0,2)
 
Si el Avatar está con orientación a la derecha e intenta avanzar un casillero, entonces el avatar deberá ocupar la posición (1,0).
Si el Avatar está con orientación a la izquierda e intenta avanzar un casillero, entonces el avatar deberá seguir ocupando la posición (0,0).
Si el Avatar está con orientación hacia arriba, y se presiona la tecla de girar a la derecha, entonces el Avatar tendrá orientación a la izquierda.
Si el Avatar con escudo está con orientación a la derecha e intenta avanzar un casillero, entonces el Avatar con escudo deberá seguir ocupando la posición (0,2).
Si el Avatar con escudo está con orientación a la izquierda e intenta avanzar un casillero, entonces el avatar deberá seguir ocupando la posición (0,2).
Si el Avatar con escudo  está con orientación hacia la derecha, y se presiona la tecla de girar a la izquierda, entonces el Avatar con escudo tendrá orientación hacia arriba.

 *
 */
public class UserStory_05 {
	Map map;
	Avatar a;
	Point aPoint;
	Point awsPoint;
	
	
	@Before
	public void UserStory5(){
	List<Point> positions = new ArrayList<Point>();
	positions.add(new Point(1,1));
	positions.add(new Point(1,5));
	map = new Builder(new Point(3, 3))
	.withStructureRectangle(new Rectangle(new Point(1, 1), new Point(2, 2), new Structure(TypeOfStructure.ACERO)))
	.withStructureLine(new Line(positions,new Structure(TypeOfStructure.ACERO)))
	.build();
	
	a= new Avatar(100, Orientation.RIGHT);
	AvatarWithShield aws= new AvatarWithShield(100, Orientation.UP);
	
	aPoint= new Point(0,0);
	awsPoint= new Point(0,2); 
	
	System.out.println("positionAvatar= (" +aPoint.x+", "+aPoint.y+")" );
	System.out.println("positionAvatarWithShield= (" +awsPoint.x+", "+awsPoint.y+")" );
	map.addBox(aPoint, a);
	map.addBox(awsPoint, aws);
	
	System.out.println("\n");
	map.printMap();
	
	}
	
	//Si el Avatar está con orientación a la derecha e intenta avanzar un casillero, 
	//entonces el avatar deberá ocupar la posición (1,0).
	@Test
	public void avanzarDerechaAvatarConOrientaciónDerecha(){
		AvatarController ac= new AvatarController(a, map, null);
		ac.avanzar(aPoint);
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("\npositionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
		System.out.println("\n");
	}
	
	//Si el Avatar está con orientación a la izquierda e intenta avanzar un casillero, entonces 
	//el avatar deberá seguir ocupando la posición (0,0).
	@Test
	public void avanzarIzquierdaAvatarConOrientaciónIzquierda(){
		AvatarController ac= new AvatarController(a, map, null);
		ac.retroceder(aPoint);
		Point pFinalEstimado= new Point(0,0);
		Point actual= a.getPosition();
		System.out.println("\npositionAvatar= (" +a.getPosition().x+", "+a.getPosition().y+")" );
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
		System.out.println("\n");
	}
}
