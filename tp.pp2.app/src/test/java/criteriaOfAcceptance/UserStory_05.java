package criteriaOfAcceptance;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
import control.AvatarWithShieldController;
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
 *  Se crea un mapa de tamaño 3x3, y se crea un rectángulo ((1,1), (2,2), acero). 
 *  Avatar en posición (0,0) y orientación hacia derecha. 
 *  El Avatar con escudo en (0,2) con orientación hacia arriba.
 *
 */

public class UserStory_05 {
	Map map;
	Rectangle rectangle;
	Avatar a;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	
	@Before
	public void UserStory5(){
	
	rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
		
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	
	aPoint= new Point(0,0);
	awsPoint= new Point(0,2); 
	
	map.addBoxGameObject(aPoint, a);
	map.addBoxGameObject(awsPoint, aws);	
	}
	
	//Si el Avatar está con orientación a la derecha e intenta avanzar un casillero, 
	//entonces el avatar deberá ocupar la posición (1,0).wsadtyuwsadtyu
	@Test
	public void avanzarDerechaAvatarConOrientaciónDerecha(){
		System.out.println("\nTest1\n");
		AvatarController ac= new AvatarController(a, map, null);
		//try{    
			ac.avanzar(aPoint);
		//}catch(Exception e){} 
		
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
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
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
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
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
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
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
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
	public void avanzarDerechaAvatarConTecla_W() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		System.out.println("\nTest7\n");
		AvatarController ac= new AvatarController(a, map, null);

		ac.controlAvatar(aPoint, KeyEvent.VK_W);
		
		Point pFinalEstimado= new Point(1,0);
		Point actual= a.getPosition();
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertTrue(actual.equals(pFinalEstimado));
	}
	
}//wsadtyu
