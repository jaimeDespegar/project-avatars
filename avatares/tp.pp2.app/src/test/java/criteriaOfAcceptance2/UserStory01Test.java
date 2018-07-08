package criteriaOfAcceptance2;

import static org.junit.Assert.*; 

import java.awt.AWTException;
import java.awt.Point;
import java.awt.event.KeyEvent;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;
import object.Turns;


import control.AvatarController;
import control.AvatarWithShieldController;
import control.ControlColissionShoot;
import control.ControlTurns;
import org.junit.Before;
import org.junit.Test;
import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class UserStory01Test {

	Map map;
	private Rectangle rectangle;
	Avatar a;
	AvatarWithShield aws;
	Point aPoint;
	Point awsPoint;
	Ax hacha;
	Bazooka bazooka1;
	Shotgun escopeta;
	Turns turno;
	ControlColissionShoot ac;
	ControlColissionShoot awsc;
	ControlTurns ct;
	
	@Before
	public void UserStory5(){
	
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.LEFT);
	
	aPoint= new Point(1,1);
	awsPoint= new Point(3,1); 
	
/*	a.setPosition(aPoint);
	aws.setPosition(awsPoint);*/
	
	rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	
	map.getBoard().addBoxGameObject(aPoint, a);
	map.getBoard().addBoxGameObject(awsPoint, aws);	
	
	//map.printMap();
	

	ac= new ControlColissionShoot(a, map, bazooka1);
	awsc= new ControlColissionShoot(aws, map, escopeta);
	ct= new ControlTurns(ac, awsc);
	}
	
	@Test
	public void controlTurnsTest(){
		System.out.println("\nTest1\n");
		ct.controlDisparo();
		
//		System.out.println("\nPRIMER DISPARO AVATAR!!");
//		System.out.println("\ncantDisparos0: "+ac.getCantDisparos());
//		System.out.println("arma Activo (antes): "+ ac.isDisparoRealizado());
		Integer cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
//		System.out.println("arma Activo (disparo): "+ ac.isDisparoRealizado());
		boolean huboChoque= ac.isColission(cantShootingRange);
//		System.out.println("huboChoque: "+huboChoque);
		ac.actualizarDisparoRealizado();
//		System.out.println("arma Activo (despues): "+ ac.isDisparoRealizado());
		
//		System.out.println("cantDisparosPlayer1: "+ac.getCantDisparos());
//		System.out.println("vida aws: "+aws.getVida());
		assertEquals(60, aws.getVida());
		
		ct.controlDisparo();
		//
		System.out.println("\nPRIMER DISPARO AVATAR WITH SHIELD!!");
		
		
		System.out.println("arma Activo (antes): "+ awsc.isDisparoRealizado());
		cantShootingRange=0;
		cantShootingRange= awsc.disparar(a);
		System.out.println("arma Activo (disparo): "+ awsc.isDisparoRealizado());
		huboChoque= awsc.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		awsc.actualizarDisparoRealizado();
		System.out.println("arma Activo (despues): "+ awsc.isDisparoRealizado());
		
		System.out.println("cantDisparosPlayer2: "+awsc.getCantDisparos());
		System.out.println("vida a: "+a.getVida());
		assertEquals(30, a.getVida());
		
		ct.controlDisparo();
		
		System.out.println("\nSEGUNDO DISPARO AVATAR!!");
		
		System.out.println("arma Activo (antes): "+ ac.isDisparoRealizado());
		cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
		System.out.println("arma Activo (disparo): "+ ac.isDisparoRealizado());
		huboChoque= ac.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		ac.actualizarDisparoRealizado();
		System.out.println("arma Activo (despues): "+ ac.isDisparoRealizado());
		
		System.out.println("cantDisparosPlayer1: "+ac.getCantDisparos());
		System.out.println("vida aws: "+aws.getVida());
		assertEquals(20, aws.getVida());
		ct.controlDisparo();
	}
	
	@Test
	public void controlTurnsKeyTurnTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		System.out.println("\nTest2\n");
		AvatarController ac= new AvatarController(a, map, bazooka1);
		
		ac.controlAvatar(aPoint, KeyEvent.VK_D, aws);
	
		Point pFinalEstimado= new Point(1,1);
		Point actual= null;
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertEquals(actual,pFinalEstimado);
		assertEquals(Orientation.DOWN, ac.getAvatar().getOrientation());
	}
	
	@Test
	public void controlTurnsKeyMovementTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		System.out.println("\nTest3\n");
		AvatarController ac= new AvatarController(a, map, bazooka1);
		
		ac.controlAvatar(aPoint, KeyEvent.VK_W, aws);
	
		Point pFinalEstimado= new Point(2,1);
		Point actual= null;
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
	}
	
	@Test
	public void controlTurnsKeyShootTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		System.out.println("\nTest4\n");
		
		AvatarController ac= new AvatarController(a, map, bazooka1);
		AvatarWithShieldController awsc= new AvatarWithShieldController(aws, map, escopeta);
		
		ControlTurns cShoot= new ControlTurns(ac.getD(), awsc.getD());
		
		boolean huboChoque1= ac.isColission();
		System.out.println("huboChoque ANTES: "+huboChoque1);
		
		ac.controlAvatar(aPoint, KeyEvent.VK_T, aws);
		boolean huboChoque= ac.isColission();
		System.out.println("huboChoque DESPUES: "+huboChoque);
		cShoot.controlDisparo();
		ac.getD().actualizarDisparoRealizado();
		
		cShoot.controlDisparo();
		
		Point pFinalEstimado= new Point(1,1);
		Point actual= null;
		System.out.println("actual: ("+actual.x+" ,"+actual.y+")");
		assertEquals(pFinalEstimado, actual);
		assertEquals(60, aws.getVida());
		
	}
}