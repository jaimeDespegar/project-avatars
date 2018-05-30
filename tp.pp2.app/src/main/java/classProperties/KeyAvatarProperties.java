package classProperties;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import main.Constants;


public class KeyAvatarProperties {
	private Properties properties;
	private ElectionKeyAvatar electionKeyAvatar;

	public KeyAvatarProperties() throws AWTException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		this.properties = new Properties();
		loadProperties();
		loadDataProperties();
	}

	private void loadDataProperties() throws AWTException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Robot bot = new Robot();
		
		String keyUp= properties.getProperty("up");
		String keyDown= properties.getProperty("down");
		String keyLeft= properties.getProperty("left");
		String keyRight= properties.getProperty("right");
		String keyShoot= properties.getProperty("shoot");
		String keyPower1= properties.getProperty("power1");
		String keyPower2= properties.getProperty("power2");
		
		this.electionKeyAvatar= new ElectionKeyAvatar(writeKeyboard(bot, keyUp), writeKeyboard(bot, keyDown), 
				writeKeyboard(bot, keyLeft), writeKeyboard(bot, keyRight), writeKeyboard(bot, keyShoot), 
				writeKeyboard(bot, keyPower1), writeKeyboard(bot, keyPower2));
	}

	private void loadProperties() {
		try {
			this.properties.load(new FileReader(Constants.ROUTE_PROPERTIES_Avatar));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ElectionKeyAvatar getElectionKeyAvatar() {
		return electionKeyAvatar;
	}
	
	
	//conviert una letra en un KeyEvent
	public static int writeKeyboard(Robot bot, String st) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException { 
		String upperCase = st.toUpperCase();
		int keyEvent = 0;
		for(int i = 0; i < upperCase.length(); i++) { 
			String letter = Character.toString(upperCase.charAt(i)); 
			String code = "VK_" + letter;
			Field f = KeyEvent.class.getField(code); 
			keyEvent = f.getInt(null); bot.keyPress(keyEvent); bot.keyRelease(keyEvent); 
		}
		return keyEvent;
	} 
}
