package criteriaOfAcceptance;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import object.Avatar;
import object.AvatarWithShield;

import org.junit.Before;
import org.junit.Test;

import tablero.Builder;
import tablero.Line;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;
import enums.Orientation;
import enums.TypeOfStructure;

/**
 * 
 *Se crea un mapa de tamaño 4x4, y se crea un rectángulo ((1,2), (2,2), acero). 
 *Además se crea un Avatar en la posición (0,0) con orientación hacia la derecha, vida=100 y 
 *un Avatar con escudo en la posición (3,0) con orientación hacia la izquierda, vida = 100.
 *
 */
public class UserStory_08 {
	Map map;
	private Rectangle rectangle;
	Avatar a;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	
	@Before
	public void UserStory5(){
	
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	
	aPoint= new Point(1,0);
	awsPoint= new Point(0,3); 
	
	rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	//System.out.println("positionAvatar= (" +aPoint.x+", "+aPoint.y+")" );
	//System.out.println("positionAvatarWithShield= (" +awsPoint.x+", "+awsPoint.y+")" );
	map.addBox(aPoint, a);
	map.addBox(awsPoint, aws);	
	
	map.printMap();
	}
	
	
	
	
	
	//Si el Avatar usa el poder de disparo del tipo hacha, la vida del Avatar con escudo vale 100. 
	@Test
	public void avanzarDerechaAvatarConOrientaciónDerecha(){
		System.out.println("\nTest1\n");
	}
}
