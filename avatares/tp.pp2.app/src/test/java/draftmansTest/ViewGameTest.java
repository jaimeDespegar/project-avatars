package draftmansTest;

import java.awt.Point;

import object.Avatar;
import object.AvatarWithShield;
import object.Rectangle;
import object.Structure;
import org.junit.Before;
import org.junit.Test;
import tablero.Builder;
import tablero.Map;
import draftmans.Draw;
import draftmans.ViewGame;
import enums.Orientation;
import enums.TypeOfStructure;

public class ViewGameTest {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private Map map;
	private Avatar a;
	private AvatarWithShield aws;
	
	

	@Before
	public void UserStory5(){
	a= new Avatar(100, Orientation.RIGHT,1);
	aws= new AvatarWithShield(100, Orientation.LEFT);
	a.setPosition(new Point(0,0));
	aws.setPosition(new Point(3,0));
	Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(2, 2),new Structure(TypeOfStructure.ACERO));
	map = new Builder(new Point(4, 4)).withStructureRectangle(rectangle).build();
	map.addBox(new Point(0,0), a);
	map.addBox(new Point(3,0), aws);	
	}
	@Test
	public void vgTest(){
		Draw d= new Draw(map.getBoard());
		
		ViewGame vg= new ViewGame(d);
		
		vg.configureView(d);
	}
}
