package criteriaOfAcceptance;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import control.ControlColissionShoot;
import enums.Orientation;
import enums.TypeOfStructure;
import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;
import tablero.Builder;
import tablero.Map;


public class UserStory08Test {
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
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}

	/**
Si el Avatar usa el poder de disparo del tipo bazooka, la vida del Avatar con escudo vale 100. 
Si el Avatar usa el poder de disparo del tipo escopeta, la vida del Avatar con escudo vale 100 - (70/2) =65.
Si el Avatar con escudo usa el poder de disparo del tipo hacha, la vida del Avatar vale 100.
Si el Avatar con escudo usa el poder de disparo del tipo bazooka, la vida del Avatar vale 100. 
Si el Avatar con escudo usa el poder de disparo del tipo escopeta, la vida del Avatar vale 100 - 70 =30.
*/
	/**Si el Avatar usa el poder de disparo del tipo hacha, la vida del Avatar con escudo vale 100. */
	@Test
	public void avatarDisparaHacha(){
		ControlColissionShoot acc = new ControlColissionShoot(a, map, hacha);
		acc.disparar(aws);
		assertTrue(aws.getVida() == 100);
	}
	
	//Si el Avatar usa el poder de disparo del tipo bazooka, la vida del Avatar con escudo vale 100. 
	@Test
	public void avatarDisparaBazooka(){
		System.out.println("\nTest2\n");
		//AvatarController ac= new AvatarController(a, map, bazooka1);
		ControlColissionShoot acc= new ControlColissionShoot(a, map, bazooka1);
		Integer cantShootingRange=0;
		cantShootingRange= acc.disparar(aws);
		boolean huboChoque= acc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(aws.getVida() == 100);
	}
	
	//Si el Avatar usa el poder de disparo del tipo escopeta, la vida del Avatar con escudo vale 100 - (70/2) =65.
	@Test
	public void avatarDisparaEscopeta(){
		System.out.println("\nTest3\n");
		//AvatarController ac= new AvatarController(a, map, escopeta);
		ControlColissionShoot acc= new ControlColissionShoot(a, map, escopeta);
		Integer cantShootingRange=0;
		cantShootingRange= acc.disparar(aws);
		boolean huboChoque= acc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(aws.getVida() == 65);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo hacha, la vida del Avatar vale 100.
	@Test
	public void avatarConEscudoDisparaHacha(){
		System.out.println("\nTest4\n");
		//AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, hacha);
		ControlColissionShoot awscc= new ControlColissionShoot(aws, map, hacha);
		Integer cantShootingRange=0;
		cantShootingRange= awscc.disparar(a);
		boolean huboChoque= awscc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(a.getVida() == 100);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo bazooka, la vida del Avatar vale 100. 
	@Test
	public void avatarConEscudoDisparaBazooka(){
		System.out.println("\nTest5\n");
		//AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, bazooka1);
		ControlColissionShoot awscc= new ControlColissionShoot(aws, map, bazooka1);
		Integer cantShootingRange=0;
		cantShootingRange= awscc.disparar(a);
		boolean huboChoque= awscc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		
		assertTrue(a.getVida() == 100);
	}
	
	//Si el Avatar con escudo usa el poder de disparo del tipo escopeta, la vida del Avatar vale 100 - 70 =30.
		@Test
		public void avatarConEscudoDisparaEscopeta(){
			System.out.println("\nTest6\n");
			//AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, escopeta);
			ControlColissionShoot awscc= new ControlColissionShoot(aws, map, escopeta);
			Integer cantShootingRange=0;
			cantShootingRange= awscc.disparar(a);
			boolean huboChoque= awscc.isColission(cantShootingRange);
			System.out.println("huboChoque: "+huboChoque);
			System.out.println("a.getVida(): "+a.getVida());
			assertTrue(a.getVida() == 30);
		}	
}
