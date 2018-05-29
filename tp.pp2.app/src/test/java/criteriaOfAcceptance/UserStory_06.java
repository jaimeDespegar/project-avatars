package criteriaOfAcceptance;

import static org.junit.Assert.assertTrue; 
import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Shotgun;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
import control.AvatarWithShieldController;
import enums.Orientation;


/**
 * Se crea un Avatar de vida=100 y orientación derecha. 
 * Además se crea un Avatar With Shield de vida=100 y orientación derecha
 *
 */
public class UserStory_06 {
	Avatar a;
	Avatar aDañado;
	AvatarWithShield aws;
	Ax hacha;
	Bazooka bazooka1;
	Shotgun escopeta;
	
	@Before
	public void UserStory04(){
	a= new Avatar(100, Orientation.RIGHT);
	aDañado= new Avatar(40, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	}
	
	@Test
	public void avatarRecibeHachazo(){
		System.out.println("\nTest1\n");
		AvatarController ac= new AvatarController(a, null, null);
		System.out.println("Vida del Avatar antes del hachazo: "+a.getVida());
		ac.colissionWeapon(a, hacha);
		System.out.println("Vida del Avatar despues del hachazo: "+a.getVida());

		assertTrue(a.getVida()==10);
	}

	@Test
	public void avatarRecibeBazooka(){
		System.out.println("\nTest2\n");
		AvatarController ac= new AvatarController(a, null, null);
		System.out.println("Vida del Avatar antes de la bazooka: "+a.getVida());
		ac.colissionWeapon(a, bazooka1);
		System.out.println("Vida del Avatar despues de la bazooka: "+a.getVida());

		assertTrue(a.getVida()==20);
	}
	
	@Test
	public void avatarRecibeEscopetazo(){
		System.out.println("\nTest3\n");
		AvatarController ac= new AvatarController(a, null, null);
		System.out.println("Vida del Avatar antes del escopetazo: "+a.getVida());
		ac.colissionWeapon(a, escopeta);
		System.out.println("Vida del Avatar despues del escopetazo: "+a.getVida());

		assertTrue(a.getVida()==30);
	}

	@Test
	public void avatarConEscudoRecibeHachazo(){
		System.out.println("\nTest4\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, null, null);
		System.out.println("Vida del Avatar Con Escudo antes del hachazo: "+aws.getVida());
		awsc.colissionWeapon(aws, hacha);
		System.out.println("Vida del Avatar Con Escudo despues del hachazo: "+aws.getVida());

		assertTrue(aws.getVida()==55);
	}
	
	@Test
	public void avatarConEscudoRecibeBazooka(){
		System.out.println("\nTest5\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, null, null);
		System.out.println("Vida del Avatar Con Escudo antes de la bazooka: "+aws.getVida());
		awsc.colissionWeapon(aws, bazooka1);
		System.out.println("Vida del Avatar Con Escudo despues de la bazooka: "+aws.getVida());

		assertTrue(aws.getVida()==60);
	}
	
	@Test
	public void avatarConEscudoRecibeEscopeta(){
		System.out.println("\nTest6\n");
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, null, null);
		System.out.println("Vida del Avatar Con Escudo antes del escopetazo: "+aws.getVida());
		awsc.colissionWeapon(aws, escopeta);
		System.out.println("Vida del Avatar Con Escudo despues del escopetazo: "+aws.getVida());

		assertTrue(aws.getVida()==65);
	}
	
	@Test
	public void avatarDañadoRecibeHachazo(){
		System.out.println("\nTest7\n");
		AvatarController ac= new AvatarController(aDañado, null, null);
		System.out.println("Vida del Avatar Dañado antes del hacha: "+aDañado.getVida());
		ac.colissionWeapon(aDañado, hacha);
		System.out.println("Vida del Avatar Dañado despues del hacha: "+aDañado.getVida());
		
		
		assertTrue(aDañado.getVida()<0);
	}
	
}
