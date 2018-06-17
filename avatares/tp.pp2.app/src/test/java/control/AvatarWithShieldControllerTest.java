package control;

import static org.junit.Assert.assertTrue; 

import java.awt.AWTException;
import java.awt.Point;
import java.awt.event.KeyEvent;
import org.junit.Test;
import classProperties.KeyAvatarWithShieldProperties;
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

public class AvatarWithShieldControllerTest {
	Map map;
	Rectangle rectangle;
	Avatar a;
	Avatar aDaniado;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	Ax hacha;
	Bazooka bazooka1;
	Shotgun escopeta;
	
	@Test
	public void avatarControllerTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		
		rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
		map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
		a= new Avatar(100, Orientation.RIGHT);
		aDaniado= new Avatar(40, Orientation.RIGHT);
		aws= new AvatarWithShield(100, Orientation.RIGHT);
		aPoint= new Point(0,0);
		awsPoint= new Point(0,2); 
		hacha= new Ax(90, 1, Orientation.RIGHT);
		bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
		escopeta= new Shotgun(70, 3, Orientation.RIGHT);
		AvatarWithShieldController awsc= new AvatarWithShieldController(a, map, hacha);
		
		awsc.controlAvatar(aPoint, KeyEvent.VK_O,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_L,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_K,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_K,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_J,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_I,null);
		awsc.controlAvatar(aPoint, KeyEvent.VK_P,null);
		
		KeyAvatarWithShieldProperties k= new KeyAvatarWithShieldProperties();
		assertTrue(KeyEvent.VK_O == k.getElectionKeyAvatarWithShield().getKeyUp());
		
	}
}
