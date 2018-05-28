package classProperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import main.Constants;


public class KeyAvatarProperties {
	private Properties properties;
	private ElectionKeyAvatar electionKeyAvatar;

	public KeyAvatarProperties() {
		this.properties = new Properties();
		loadProperties();
		loadDataProperties();
	}

	private void loadDataProperties() {
		
		Integer keyUp= Integer.parseInt(properties.getProperty("up"));
		Integer keyDown= Integer.parseInt(properties.getProperty("down"));
		Integer keyLeft= Integer.parseInt(properties.getProperty("left"));
		Integer keyRight= Integer.parseInt(properties.getProperty("right"));
		Integer keyShoot= Integer.parseInt(properties.getProperty("shoot"));
		Integer keyPower1= Integer.parseInt(properties.getProperty("power1"));
		Integer keyPower2= Integer.parseInt(properties.getProperty("power2"));
		
		this.electionKeyAvatar= new ElectionKeyAvatar(keyUp, keyDown, keyLeft, keyRight, keyShoot, keyPower1, keyPower2);
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
}
