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
	 Se crea un mapa de tamano 4x4, y se crea un rectangulo ((1,2), (2,2), acero). 
	 Ademas se crea un Avatar en la posicion (0,0) con orientacion hacia la derecha, vida = 100 
	 y un Avatar con escudo en la posicion (3,0) con orientacion hacia la izquierda, vida = 100.
	 */
	@Before
	public void init(){
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
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
		assertEquals(aws.getVida(), 100);
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
		
		assertEquals(aws.getVida(),100);
	}
	
	//Si el Avatar usa el poder de disparo del tipo escopeta, la vida del Avatar con escudo vale 100 - (70/2) =65.
	@Test
	public void avatarDisparaEscopeta(){
		System.out.println("\nTest3\n");
		//AvatarController ac= new AvatarController(a, map, escopeta);
		ControlColissionShoot acc= new ControlColissionShoot(a, map, escopeta);
		Integer cantShootingRange=0;
		System.out.println(acc.getArma().getPosition().x);
		System.out.println(acc.getArma().getPosition().y);
		cantShootingRange= acc.disparar(aws);
		System.out.println("cantShootingRange: "+cantShootingRange);
		boolean huboChoque= acc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		System.out.println(aws.getVida());
		System.out.println(acc.getArma().getPosition().x);
		System.out.println(acc.getArma().getPosition().y);
		
		assertEquals(aws.getVida(),65);
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
		
		assertEquals(a.getVida(),100);
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
		
		assertEquals(a.getVida(),100);
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
			assertEquals(a.getVida(),30);
		}	
}
