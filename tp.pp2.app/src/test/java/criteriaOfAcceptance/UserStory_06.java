package criteriaOfAcceptance;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Shotgun;
import object.Weapon;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
import tablero.Builder;
import tablero.Map;
import tablero.Rectangle;
import tablero.Structure;
import enums.Orientation;
import enums.TypeOfStructure;

/**
 * Se crea un Avatar de vida=100 y orientación derecha. 
 * Además se crea un Avatar With Shield de vida=100 y orientación derecha
 *
 */
public class UserStory_06 {
	Avatar a;
	AvatarWithShield aws;
	Ax hacha;
	Bazooka bazooka;
	Shotgun escopeta;
	
	@Before
	public void UserStory04(){
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.RIGHT);
	hacha= new Ax(90, 1, true, Orientation.RIGHT);
	bazooka= new Bazooka(80, 2, true, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, true, Orientation.RIGHT);
	}
	
	@Test
	public void avatarRecibeHachazo(){
		System.out.println("\nTest1\n");
		AvatarController ac= new AvatarController(a, null, null);
		System.out.println("Vida del Avatar antes del hachazo: "+a.getVida());

		a.colissionWeapon(hacha);
		System.out.println("Vida del Avatar despues del hachazo: "+a.getVida());

		assertTrue(a.getVida()==10);
	}
}
