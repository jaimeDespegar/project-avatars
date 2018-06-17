package criteriaOfAcceptance2;

import static org.junit.Assert.*; 

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;
import object.Turns;

import org.junit.Before;
import org.junit.Test;

import control.ControlColissionShoot;
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
	
	@Before
	public void UserStory5(){
	
	a= new Avatar(100, Orientation.RIGHT);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.LEFT);
	
	aPoint= new Point(1,1);
	awsPoint= new Point(3,1); 
	
	a.setPosition(aPoint);
	aws.setPosition(awsPoint);
	
	rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	
	map.getBoard().addBoxGameObject(aPoint, a);
	map.getBoard().addBoxGameObject(awsPoint, aws);	
	
	map.printMap();
	
	turno= new Turns(); //le toca al player1
	}
	
	@Test
	public void controlTurnsTest(){
		
		System.out.println("\nPRIMER DISPARO AVATAR!!");
		
		ControlColissionShoot ac= new ControlColissionShoot(a, map, bazooka1);
		System.out.println("\ncantDisparos0: "+ac.getCantDisparos());
		System.out.println("arma Activo (antes): "+ ac.isDisparoRealizado());
		Integer cantShootingRange=0;
		cantShootingRange= ac.disparar(aws);
		System.out.println("arma Activo (disparo): "+ ac.isDisparoRealizado());
		boolean huboChoque= ac.isColission(cantShootingRange);
		System.out.println("huboChoque: "+huboChoque);
		ac.actualizarDisparoRealizado();
		System.out.println("arma Activo (despues): "+ ac.isDisparoRealizado());
		
		System.out.println("cantDisparosPlayer1: "+ac.getCantDisparos());
		System.out.println("vida aws: "+aws.getVida());
		assertEquals(aws.getVida(),60);
		turno.actualizarTurno(); //le toca al player2
		//
		System.out.println("\nPRIMER DISPARO AVATAR WITH SHIELD!!");
		
		ControlColissionShoot awsc= new ControlColissionShoot(aws, map, escopeta);
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
		assertEquals(a.getVida(),30);
		turno.actualizarTurno(); //le toca al player1
		//
		
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
		assertEquals(aws.getVida(),20);
	}
}