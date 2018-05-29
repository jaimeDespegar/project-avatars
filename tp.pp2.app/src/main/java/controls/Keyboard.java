package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
//	public Key up = new Key(); aca tenia todas las teclas, al fin de cuenta no las necesitaba .. mm ver igual sino imp si solo eran Keys
	
	private KeyFactory keyFactory = new KeyFactory();
	
	public void keyPressed(KeyEvent e) {
		
		Key keyPressed = buildKeyOfEvent(e);
		keyPressed.pressedKey();
		
// 		ver este caso ! 
//		case KeyEvent.VK_ESCAPE:
//			System.exit(0);

	}

	public void keyReleased(KeyEvent e) {
		Key keyReleased = buildKeyOfEvent(e);
		keyReleased.releasedKey();
	}

	public void keyTyped(KeyEvent e) {
		// ?
	}
	
	private Key buildKeyOfEvent(KeyEvent e) {
		Integer keyCodePressed = e.getKeyCode();
		Key key = this.keyFactory.getKeyByCode(keyCodePressed);
		return key;
	}
}