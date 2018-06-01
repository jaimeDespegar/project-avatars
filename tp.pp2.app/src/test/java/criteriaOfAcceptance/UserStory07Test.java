package criteriaOfAcceptance;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import object.Avatar;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import tablero.Builder;
import tablero.Map;
import control.ControlColissionShoot;
import enums.Orientation;
import enums.TypeOfStructure;

/**
 * 
Se crea un Avatar de vida=100. Ambos sin escudo, Avatares A y B.
Si el Avatar A recibe un daño , quedando con vida menor igual a 0. Este muere y se muestra un mensaje con su vida y  la del Avatar B marcado como ganador.
Si el Avatar B recibe un daño , quedando con vida menor igual a 0. Este muere y se muestra un mensaje con su vida y  la del Avatar A marcado como ganador.
Si el Avatar A en la posición (1,1) recibe un daño, quedando con vida menor igual a 0. Este muere, quedando la posición (1,1) vacía.
 *
 */
public class UserStory07Test {
	Map map;
	Rectangle rectangle;
	Avatar A;
	Avatar B;
	Ax hacha;
	Bazooka bazooka1;
	Shotgun escopeta;
	
	@Before
	public void UserStory04(){
	rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
		
	A= new Avatar(40, Orientation.RIGHT);
	B= new Avatar(50, Orientation.RIGHT);
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	A.gameObjectMaxHealthy(); //vida a1= 100
	B.gameObjectMaxHealthy(); //vida a2= 100
	}
	
	
	//Si el Avatar A recibe un daño , quedando con vida menor igual a 0. Este muere y se muestra un mensaje con su vida 
	//y  la del Avatar B marcado como ganador.
	@Test
	public void avatarAEsDerrotadoPorAvatarB(){
		System.out.println("\nTest1\n");
		//AvatarController ac= new AvatarController(aDañado, null, null);
		ControlColissionShoot Acc= new ControlColissionShoot(A, null, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, null, null);
		
		System.out.println("Vida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Acc.colissionWeaponByEnemy(A, hacha, B);
		System.out.println("\nVida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Bcc.colissionWeaponByEnemy(B, escopeta, A);
		System.out.println("\nVida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Acc.colissionWeaponByEnemy(A, bazooka1, B);
		
		assertTrue(A.getVida()<0);
	}
	
	//Si el Avatar B recibe un daño , quedando con vida menor igual a 0. Este muere y se muestra un mensaje con su vida 
	//y  la del Avatar A marcado como ganador.
	@Test
	public void avatarBEsDerrotadoPorAvatarA(){
		System.out.println("\nTest2\n");
		//AvatarController ac= new AvatarController(aDañado, null, null);
		ControlColissionShoot Acc= new ControlColissionShoot(A, null, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, null, null);
		
		System.out.println("Vida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Bcc.colissionWeaponByEnemy(B, hacha, A);
		System.out.println("\nVida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Acc.colissionWeaponByEnemy(A, bazooka1, B);
		System.out.println("\nVida A:"+ A.getVida());
		System.out.println("Vida B:"+ B.getVida());
		
		Bcc.colissionWeaponByEnemy(B, escopeta, A);
		
		assertTrue(B.getVida()<0);
	}
	
	//Si el Avatar A en la posición (1,1) recibe un daño, quedando con vida menor igual a 0. 
	//Este muere, quedando la posición (1,1) vacía.
	@Test
	public void avatarDerrotadoDesapareceDelMapa(){
		System.out.println("\nTest3\n");
		map.addBoxGameObject(new Point(0,0), A);
		A.setPosition(new Point(0,0));
		map.addBoxGameObject(new Point(1,0), B);
		B.setPosition(new Point(1,0));
		map.printMap();
		
		ControlColissionShoot Acc= new ControlColissionShoot(A, map, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, map, null);
		
		Acc.colissionWeaponByEnemy(A, hacha, B);
		Bcc.colissionWeaponByEnemy(B, bazooka1, A);
		Acc.colissionWeaponByEnemy(A, hacha, B);
		
		map.printMap();
		assertTrue(A.getVida()<0);
	}
	
}
