package draftmansTest;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import object.Avatar;
import object.AvatarWithShield;
import object.Ax;
import object.Bazooka;
import object.Rectangle;
import object.Shotgun;
import object.Structure;

import org.junit.Before;
import org.junit.Test;

import draftmans.Draw;
import tablero.Box;
import tablero.Builder;
import tablero.Map;
import enums.Orientation;
import enums.TypeOfStructure;

public class DrawTest extends Canvas{
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	private Ax hacha;
	private Bazooka bazooka1;
	private Shotgun escopeta;
	

	@Before
	public void UserStory5(){
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
	hacha= new Ax(90, 1, Orientation.RIGHT);
	bazooka1= new Bazooka(80, 2, Orientation.RIGHT);
	escopeta= new Shotgun(70, 3, Orientation.RIGHT);
	Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}
	
	@Test
	public void drawImagesTest(){
		Draw d= new Draw(map.getBoard());
		
		try{
			d.DrawImages();
		}catch(Exception e){}
		
		List<Box> lb =new ArrayList<Box>();
		lb.add(map.getBox(new Point(0,0)));
		lb.add(map.getBox(new Point(3,0)));
		
		List<Point> lc =new ArrayList<Point>();
		lc.add(new Point(0,0));
		lc.add(new Point(3,3));
		
		try{
		d.drawBoxes(lb, lc);
		}catch(Exception e){}
		
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			try{
			createBufferStrategy(3);
			}catch(Exception e){}
			return;
		}
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		for (int i = 0; i < map.getBoard().size(); i++) {
			try{
			d.drawBox(g,lb.get(i), new Point(lc.get(i).x*40,lc.get(i).y*40));
			}catch(Exception e){}
		}
		g.dispose();
		
		
		
	}
	
}
