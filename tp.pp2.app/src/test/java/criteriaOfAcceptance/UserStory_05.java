package criteriaOfAcceptance;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
import control.AvatarWithShieldController;
import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.AvatarWithShield;
import object.Line;
import object.Rectangle;
import object.Structure;
import tablero.Builder;
import tablero.Map;




/**
 * 
 *  Se crea un mapa de tamaño 3x3, y se crea un rectángulo ((1,1), (2,2), acero). 
 *  Avatar en posición (0,0) y orientación hacia derecha. 
 *  El Avatar con escudo en (0,2) con orientación hacia arriba.
 *
 */
public class UserStory_05 {
	Map map;
	Avatar a;
	AvatarWithShield aws;
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
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	
	aPoint= new Point(0,0);
	awsPoint= new Point(0,2); 
	
	//System.out.println("positionAvatar= (" +aPoint.x+", "+aPoint.y+")" );
	//System.out.println("positionAvatarWithShield= (" +awsPoint.x+", "+awsPoint.y+")" );
	map.addBox(aPoint, a);
	map.addBox(awsPoint, aws);	
	}
	
	//Si el Avatar está con orientación a la derecha e intenta avanzar un casillero, 
	//entonces el avatar deberá ocupar la posición (1,0).
	@Test
	public void avanzarDerechaAvatarConOrientaciónDerecha(){
		System.out.println("\nTest1\n");
		AvatarController ac= new AvatarController(a, map, null);
		//try{    
			ac.avanzar(aPoint);
		//}catch(Exception e){} 
		
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
	}
	
	//Si el Avatar está con orientación a la izquierda e intenta avanzar un casillero, entonces 
	//el avatar deberá seguir ocupando la posición (0,0).
	@Test
	public void retrocederIzquierdaAvatar(){
		System.out.println("\nTest2\n");
		
		AvatarController ac= new AvatarController(a, map, null);
		try{    
			ac.retroceder(aPoint);
		}catch(Exception e){}  
		
		Point pFinalEstimado= new Point(0,0);
		Point actual= a.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
	}
	
	//Si el Avatar intenta girar a la derecha, entonces el Avatar tendrá 
	//orientación hacia abajo.
	@Test
	public void girarAvatarDerecha(){
		System.out.println("\nTest3\n");
		AvatarController ac= new AvatarController(a, map, null);
		System.out.println("Antes de girar: "+a.getOrientation().name());
		ac.girarHaciaDerecha();
		System.out.println("Despues de girar: "+a.getOrientation().name());
		assertTrue(a.getOrientation().equals(Orientation.DOWN));
	}
	
	//Si el Avatar con escudo está con orientación a la derecha e intenta 
	//avanzar un casillero, entonces el Avatar con escudo deberá seguir ocupando la posición (0,2).
	@Test
	public void avanzarDerechaAvatarConEscudo(){
		System.out.println("\nTest4\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, null);
		  
		awsc.avanzar(awsPoint);
		
		
		Point pFinalEstimado= new Point(0,2);
		Point actual= aws.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
	}

	//Si el Avatar con escudo intenta retroceder un casillero, entonces el avatar con escudo 
	//deberá seguir ocupando la posición (0,2).
	@Test
	public void retrocederIzquierdaAvatarConEscudo(){
		System.out.println("\nTest5\n");
		
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, null);
   
		awsc.retroceder(awsPoint); 
		
		Point pFinalEstimado= new Point(0,2);
		Point actual= aws.getPosition();
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
	}
	
	@Test
	public void girarAvatarConEscudoIzquierda(){
		System.out.println("\nTest6\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, null);
		System.out.println("Antes de girar: "+aws.getOrientation().name());
		awsc.girarHaciaIzquierda();;
		System.out.println("Despues de girar: "+aws.getOrientation().name());
		assertTrue(aws.getOrientation().equals(Orientation.UP));
	}
	
	@Test
	public void avanzarDerechaAvatarConTecla_W(){
		System.out.println("\nTest7\n");
		AvatarController ac= new AvatarController(a, map, null);

		ac.controlAvatar(aPoint, KeyEvent.VK_W);
		
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
		map.printMap();
	}
}
