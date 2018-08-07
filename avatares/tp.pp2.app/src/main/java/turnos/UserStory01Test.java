package turnos;

import static org.junit.Assert.*;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import control.AvatarController;
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
	
	@Before
	public void UserStory5(){
	
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	
	aPoint= new Point(1,1);
	awsPoint= new Point(3,1); 
	
	a.setPosition(aPoint);
	aws.setPosition(awsPoint);
	
	rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	
	map.addBox(aPoint, a);
	map.addBox(awsPoint, aws);	
	
	map.printMap();
	}
	
	@Test
	public void controlTurnsTest(){
		
//		AvatarController ac= new AvatarController(a, map, bazooka1);
//		System.out.println("\ncantDisparos0: "+ac.getCantDisparos());
//		
//		System.out.println("\nPRIMER DISPARO!!");
//		System.out.println("arma Activo (antes): "+ ac.controlDisparoRealizado());
//		Integer cantShootingRange=0;
//		cantShootingRange= ac.disparar(aws);
//		System.out.println("arma Activo (disparo): "+ ac.controlDisparoRealizado());
//		boolean huboChoque= ac.isColission(cantShootingRange);
//		System.out.println("huboChoque: "+huboChoque);
//		ac.actualizarDisparoRealizado();
//		System.out.println("arma Activo (despues): "+ ac.controlDisparoRealizado());
//		
//		System.out.println("cantDisparos1: "+ac.getCantDisparos());
//		System.out.println("vida aws: "+aws.getVida());
//		assertEquals(aws.getVida(),60);
//		
//		System.out.println("\nSEGUNDO DISPARO!!");
//		System.out.println("arma Activo (antes): "+ ac.controlDisparoRealizado());
//		cantShootingRange=0;
//		cantShootingRange= ac.disparar(aws);
//		System.out.println("arma Activo (disparo): "+ ac.controlDisparoRealizado());
//		huboChoque= ac.isColission(cantShootingRange);
//		System.out.println("huboChoque: "+huboChoque);
//		ac.actualizarDisparoRealizado();
//		System.out.println("arma Activo (despues): "+ ac.controlDisparoRealizado());
//		
//		System.out.println("cantDisparos2: "+ac.getCantDisparos());
//		System.out.println("vida aws: "+aws.getVida());
//		assertEquals(aws.getVida(),20);
	}
}
