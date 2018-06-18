package criteriaOfAcceptance;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//import control.AvatarController;
//import control.AvatarWithShieldController;
import control.ControlColissionShoot;
import enums.Orientation;
import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Shotgun;


/**
 * Se crea un Avatar de vida = 100 y orientación derecha. 
 * Además se crea un Avatar With Shield de vida = 100 y orientación derecha.
 */
public class UserStory06Test {
	private Avatar a;
	private AvatarWithShield aws;
	private Ax hacha;
	private Bazooka bazooka1;
	private Shotgun escopeta;
	
	@Before
	public void UserStory04(){
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	hacha = new Ax(90, 1, Orientation.RIGHT);
	bazooka1 = new Bazooka(80, 2, Orientation.RIGHT);
	escopeta = new Shotgun(70, 3, Orientation.RIGHT);
	}

	/**Si el Avatar (sin escudo) recibe un hachazo de 90 de daño, luego la vida del Avatar vale 10.*/
	@Test
	public void avatarReceiveAx(){
		ControlColissionShoot acc = new ControlColissionShoot(a, null, null);
		acc.colissionWeapon(a, hacha);
		assertTrue(a.getVida()==10);
	}
	
	/**Si el Avatar (sin escudo) recibe un disparo de Bazooka  de 80 de daño, luego la vida del Avatar vale 20.*/
	@Test
	public void avatarRecibeBazooka(){
		ControlColissionShoot acc= new ControlColissionShoot(a, null, null);
		acc.colissionWeapon(a, bazooka1);
		assertTrue(a.getVida()==20);
	}
	
	/**Si el Avatar (sin escudo) recibe un disparo de escopeta de 70 de daño, luego la vida del Avatar vale 30.*/
	@Test
	public void avatarRecibeEscopetazo(){
		ControlColissionShoot acc= new ControlColissionShoot(a, null, null);
		acc.colissionWeapon(a, escopeta);
		assertTrue(a.getVida()==30);
	}

	/**Si el Avatar (con escudo) recibe un hachazo de 90 de daño, luego la vida vale 55.*/
	@Test
	public void avatarConEscudoRecibeHachazo(){
		ControlColissionShoot awscc= new ControlColissionShoot(aws, null, null);
		awscc.colissionWeapon(aws, hacha);
		assertTrue(aws.getVida()==55);
	}
	
	/**Si el Avatar (con escudo) recibe un disparo de Bazooka  de 80 de daño, luego la vida vale 60.*/
	@Test
	public void avatarConEscudoRecibeBazooka(){
		ControlColissionShoot awscc= new ControlColissionShoot(aws, null, null);
		awscc.colissionWeapon(aws, bazooka1);
		assertTrue(aws.getVida()==60);
	}
	
	/**Si el Avatar (con escudo) recibe un disparo de escopeta de 70 de daño, luego la vida vale 65.*/
	@Test
	public void avatarConEscudoRecibeEscopeta(){
		ControlColissionShoot awscc= new ControlColissionShoot(aws, null, null);
		awscc.colissionWeapon(aws, escopeta);
		assertTrue(aws.getVida()==65);
	}
	
	/**Si se crea un avatar con vida 40 y recibe una bala de un disparo de tipo bazooka de 80 de daño, 
	 * el avatar deberá ser destruido ya que la vida del Avatar es menor a 0.*/
	@Test
	public void avatarDaniadoRecibeHachazo(){
		Avatar aDaniado= new Avatar(40, Orientation.RIGHT);
		ControlColissionShoot acc= new ControlColissionShoot(aDaniado, null, null);
		acc.colissionWeapon(aDaniado, hacha);
		assertTrue(aDaniado.getVida()<0);
	}
}
