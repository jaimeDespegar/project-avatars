package controls;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyFactory {

	private Map<Integer, Key> mapKeys;
	
	public KeyFactory() {
		this.mapKeys = new HashMap<Integer, Key>();
		this.loadValuesKeys();
	}
	
	private void loadValuesKeys() {
		this.mapKeys.put(KeyEvent.VK_W, new Key());
		this.mapKeys.put(KeyEvent.VK_S, new Key());
		this.mapKeys.put(KeyEvent.VK_A, new Key());
		this.mapKeys.put(KeyEvent.VK_D, new Key());
		this.mapKeys.put(KeyEvent.VK_C, new Key());
		this.mapKeys.put(KeyEvent.VK_V, new Key());
		this.mapKeys.put(KeyEvent.VK_SPACE, new Key());
		
		this.mapKeys.put(KeyEvent.VK_UP, new Key());
		this.mapKeys.put(KeyEvent.VK_DOWN, new Key());
		this.mapKeys.put(KeyEvent.VK_LEFT, new Key());
		this.mapKeys.put(KeyEvent.VK_RIGHT, new Key());
		this.mapKeys.put(KeyEvent.VK_K, new Key());
		this.mapKeys.put(KeyEvent.VK_L, new Key());
		this.mapKeys.put(KeyEvent.VK_ENTER, new Key());
	}

	public Key getKeyByCode(Integer keyCode) {
		return mapKeys.get(keyCode);
	}
	
}
