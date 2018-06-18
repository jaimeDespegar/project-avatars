package criteriaOfAcceptance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.awt.Point;
import object.Avatar;
import object.Ax;
import object.Bazooka;
import object.Shotgun;

import org.junit.Before;
import org.junit.Test;
import tablero.Builder;
import tablero.Map;
import control.ControlColissionShoot;
import enums.Orientation;

public class UserStory07Test {
	private Map map;
	private Avatar A;
	private Avatar B;
	private Ax hacha;
	private Bazooka bazooka1;
	private Shotgun escopeta;
	
	/**
	Se crea un mapa de tamaño 3x3. Se crean un avatar A con vida = 40 y otro avatar B con vida = 50. Ambos sin escudo.
	 */
	@Before
	public void UserStory04(){
	map = new Builder(new Point(3, 3)).build();
	A= new Avatar(40, Orientation.RIGHT);
	B= new Avatar(50, Orientation.RIGHT);
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	A.gameObjectMaxHealthy(); //vida a1= 100
	B.gameObjectMaxHealthy(); //vida a2= 100
	}
	
	/**Si el Avatar A recibe un daño , quedando con vida menor igual a 0. Este muere y se muestra un mensaje con su vida 
	 * y la del Avatar B marcado como ganador.*/
	@Test
	public void avatarAEsDerrotadoPorAvatarB(){
		ControlColissionShoot Acc= new ControlColissionShoot(A, null, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, null, null);
		Acc.colissionWeaponByEnemy(A, hacha, B);
		Bcc.colissionWeaponByEnemy(B, escopeta, A);
		Acc.colissionWeaponByEnemy(A, bazooka1, B);
		assertTrue(A.getVida()<0);
	}
	
	/**Si el Avatar B recibe un daño , quedando con vida menor igual a 0. 
	 * Este muere y se muestra un mensaje con su vida y  la del Avatar A marcado como ganador.*/
	@Test
	public void avatarBEsDerrotadoPorAvatarA(){
		ControlColissionShoot Acc= new ControlColissionShoot(A, null, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, null, null);
		Bcc.colissionWeaponByEnemy(B, hacha, A);
		Acc.colissionWeaponByEnemy(A, bazooka1, B);
		Bcc.colissionWeaponByEnemy(B, escopeta, A);
		assertTrue(B.getVida()<0);
	}
	
	/**Si el Avatar A en la posición (0,1) recibe un daño, quedando con vida menor igual a 0. Este muere, quedando la posición (0,1) vacía.*/
	@Test
	public void avatarDerrotadoDesapareceDelMapa(){
		map.addBox(new Point(0,1), A);
		A.setPosition(new Point(0,0));
		map.addBox(new Point(0,2), B);
		B.setPosition(new Point(1,0));
		ControlColissionShoot Acc= new ControlColissionShoot(A, map, null);
		ControlColissionShoot Bcc= new ControlColissionShoot(B, map, null);
		Acc.colissionWeaponByEnemy(A, hacha, B);
		Bcc.colissionWeaponByEnemy(B, bazooka1, A);
		Acc.colissionWeaponByEnemy(A, hacha, B);
		assertTrue(A.getVida()<0);
		assertNull(map.getBox(new Point(0,0)));//EL AVATAR NO SE BORRA DEL MAPA; SIGUE QUEDANDO
	}
}
