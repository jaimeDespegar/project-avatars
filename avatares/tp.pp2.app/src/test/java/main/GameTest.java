package main;

import object.Avatar;

import org.junit.Test;

import enums.Orientation;

public class GameTest {
	@Test
	public void gTest(){
		Avatar avatar= new Avatar(1, Orientation.RIGHT,1);
		Game g= new Game();
		g.initAvatares();
		g.getConfiguration();
		g.getMap();
		g.getAvatars();
		g.deleteAvatar(avatar);
		g.isFinish();
		g.getKeyboard();
	}
}
