package classProperties;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.junit.Test;

public class ElectionMapTest {
	@Test
	public void electionMap()throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, AWTException{
		MapProperties k= new MapProperties();
		
		ElectionMap e= new ElectionMap(k.getElectionMap().getMapSize(), k.getElectionMap().getRectangle1() ,k.getElectionMap().getRectangle2()
				,k.getElectionMap().getLine1() ,k.getElectionMap().getLine2());
		
		//System.out.println("k.getElectionMap().getMapSize().x: "+k.getElectionMap().getMapSize().x);
		assertTrue(10 == k.getElectionMap().getMapSize().x);
	}
}
