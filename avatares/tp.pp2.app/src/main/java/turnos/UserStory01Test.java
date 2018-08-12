package turnos;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.event.KeyEvent;

import main.Constants;
import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import classProperties.KeyAvatarProperties;
import control.AvatarController;
import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class UserStory01Test {

//	Map map;
//	private Rectangle rectangle;
//	Avatar a;
//	AvatarWithShield aws;
//	Point aPoint;
//	Point awsPoint;
//	Ax hacha;
//	Bazooka bazooka1;
//	Shotgun escopeta;
//	
//	@Before
//	public void UserStory5(){
//	
//	a= new Avatar(100, Orientation.RIGHT);
//	aws= new AvatarWithShield(100, Orientation.LEFT);
//	
//	hacha= new Ax(90, 1, Orientation.RIGHT);
//	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
//	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
//	
//	aPoint= new Point(0,0);
//	awsPoint= new Point(2,0); 
//	
//	a.setPosition(aPoint);
//	aws.setPosition(awsPoint);
//	
//	rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
//	map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
//	
//	map.addBox(aPoint, a);
//	map.addBox(awsPoint, aws);	
//	
//	map.printMap();
//	}
//	
//	@SuppressWarnings("unused")
//	@Test
//	public void controlTurnsTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
//		AvatarController ac= new AvatarController(a, map, bazooka1);
//		System.out.println("\ncantDisparos0: "+ac.getCantDisparos());
//		
//		
//		System.out.println("\nPRIMER DISPARO!!");
//		System.out.println("arma Activo (antes): "+ ac.isDisparoRealizado());
//		Integer cantShootingRange=0;
//		ac.controlAvatar(aPoint, KeyEvent.VK_T, aws); 
//		cantShootingRange= ac.getCantShootingRange();
//		System.out.println("arma Activo (disparo): "+ ac.isDisparoRealizado());
//		boolean huboChoque= ac.isColission();
//		System.out.println("huboChoque: "+huboChoque);
//		ac.actualizarDisparoRealizado();
//		System.out.println("arma Activo (despues): "+ ac.isDisparoRealizado());
//	
//		System.out.println("cantDisparos1: "+ac.getCantDisparos());
//		System.out.println("vida aws: "+aws.getVida());
//		assertEquals(60,aws.getVida());
//	}
		
	
	
	@Test
	public void controlTurns2Test()throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		
		Avatar a= new Avatar(100, Orientation.RIGHT);
		AvatarWithShield aws= new AvatarWithShield(100, Orientation.LEFT);
		
		Ax hacha= new Ax(90, 1, Orientation.RIGHT);
		Bazooka bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
		Shotgun escopeta= new Shotgun(70, 3, Orientation.RIGHT);
		
		Point aPoint= new Point(0,0);
		Point awsPoint= new Point(2,0); 
		
		a.setPosition(aPoint);
		aws.setPosition(awsPoint);
		
		Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
		Map map = new Builder(new Point(3, 3)).withStructureRectangle(rectangle).build();
		
		map.addBox(aPoint, a);
		map.addBox(awsPoint, aws);	
		
		map.printMap();
		
		
		
		AvatarController ac= new AvatarController(a, map, bazooka1);
		System.out.println("\ncantDisparos0: "+ac.getCantDisparos());
		
		System.out.println("\nPRIMER DISPARO!!");
		System.out.println("arma Activo (antes): "+ ac.isDisparoRealizado());
		Integer cantShootingRange=0;
		System.out.println("vida aws1: "+aws.getVida());
		ac.controlAvatar(aPoint, KeyEvent.VK_T, aws); 
		cantShootingRange= ac.getCantShootingRange();
		System.out.println("arma Activo (disparo): "+ ac.isDisparoRealizado());
		boolean huboChoque= ac.isColission();
		System.out.println("huboChoque: "+huboChoque);
		ac.actualizarDisparoRealizado();
		System.out.println("arma Activo (despues): "+ ac.isDisparoRealizado());
		
		System.out.println("cantDisparos1: "+ac.getCantDisparos());
		System.out.println("vida aws: "+aws.getVida());
		assertEquals(60,aws.getVida());
		
		
		
		System.out.println("\nSEGUNDO DISPARO!!");
		AvatarController ac2= new AvatarController(a, map, bazooka1);
		System.out.println("arma Activo (antes): "+ ac2.isDisparoRealizado());
		cantShootingRange=0;
		System.out.println("vida aws: "+aws.getVida());
		ac2.controlAvatar(aPoint, KeyEvent.VK_T, aws); 
		//ac.getControlColissionShoot().disparar(aws);
		cantShootingRange= ac2.getCantShootingRange();
		System.out.println("arma Activo (disparo): "+ ac2.isDisparoRealizado());
		huboChoque= ac2.isColission();
		System.out.println("huboChoque: "+huboChoque);
		ac2.actualizarDisparoRealizado();
		System.out.println("arma Activo (despues): "+ ac2.isDisparoRealizado());
		
		System.out.println("cantDisparos2: "+ac2.getCantDisparos());
		System.out.println("vida aws: "+aws.getVida());
		assertEquals(20,aws.getVida());
	}
}
