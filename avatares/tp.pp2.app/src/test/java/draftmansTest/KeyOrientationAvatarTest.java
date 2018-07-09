package draftmansTest;

import org.junit.Test;

import draftmans.KeyOrientationAvatar;
import enums.Orientation;

public class KeyOrientationAvatarTest {
	@Test
	public void koaTest(){
		KeyOrientationAvatar k= new KeyOrientationAvatar(1, Orientation.RIGHT);
		
		k.equals(k);
		k.hashCode();
	}
}
