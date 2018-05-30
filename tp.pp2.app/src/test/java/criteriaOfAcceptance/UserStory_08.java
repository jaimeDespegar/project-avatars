package criteriaOfAcceptance;

import static org.junit.Assert.*;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Shotgun;
import org.junit.Before;
import org.junit.Test;
import control.AvatarController;
import control.AvatarWithShieldController;
import tablero.Builder;
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
	Ax hacha;
	Bazooka bazooka1;
	Shotgun escopeta;
	
	@Before
	public void UserStory5(){
	
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	
	aPoint= new Point(0,0);
	awsPoint= new Point(3,0); 
	
	a.setPosition(aPoint);
	aws.setPosition(awsPoint);
	
	rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	
	map.addBoxGameObject(aPoint, a);
	map.addBoxGameObject(awsPoint, aws);	
	
	//map.printMap();
	}
	
	
	
	
	
	//Si el Avatar usa el poder de disparo del tipo hacha la derecha, la vida del Avatar con escudo vale 100. 
	@Test
	public void avatarDisparaHacha(){
		System.out.println("\nTest1\n");
		AvatarController ac= new AvatarController(a, map, hacha);
		Integer cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
		boolean huboChoque= ac.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);

		assertTrue(aws.getVida() == 100);
	}
	
	//Si el Avatar usa el poder de disparo del tipo bazooka, la vida del Avatar con escudo vale 100. 
	@Test
	public void avatarDisparaBazooka(){
		System.out.println("\nTest2\n");
		AvatarController ac= new AvatarController(a, map, bazooka1);
		Integer cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
		boolean huboChoque= ac.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(aws.getVida() == 100);
	}
	
	//Si el Avatar usa el poder de disparo del tipo escopeta, la vida del Avatar con escudo vale 100 - (70/2) =65.
	@Test
	public void avatarDisparaEscopeta(){
		System.out.println("\nTest3\n");
		AvatarController ac= new AvatarController(a, map, escopeta);
		Integer cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
		boolean huboChoque= ac.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(aws.getVida() == 65);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo hacha, la vida del Avatar vale 100.
	@Test
	public void avatarConEscudoDisparaHacha(){
		System.out.println("\nTest4\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, hacha);
		Integer cantShootingRange=0;
		cantShootingRange= awsc.disparar(a);
		boolean huboChoque= awsc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(a.getVida() == 100);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo bazooka, la vida del Avatar vale 100. 
	@Test
	public void avatarConEscudoDisparaBazooka(){
		System.out.println("\nTest5\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, bazooka1);
		Integer cantShootingRange=0;
		cantShootingRange= awsc.disparar(a);
		boolean huboChoque= awsc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(a.getVida() == 100);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo escopeta, la vida del Avatar vale 100 - 70 =30.
		@Test
		public void avatarConEscudoDisparaEscopeta(){
			System.out.println("\nTest6\n");
			AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, escopeta);
			Integer cantShootingRange=0;
			cantShootingRange= awsc.disparar(a);
			boolean huboChoque= awsc.isColission(cantShootingRange);
			System.out.println("huboChoque: "+huboChoque);
			System.out.println("a.getVida(): "+a.getVida());
			assertTrue(a.getVida() == 30);
		}	
}
