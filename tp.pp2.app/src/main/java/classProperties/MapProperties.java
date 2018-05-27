package classProperties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import main.Constants;

public class MapProperties {
	private Properties properties;
	private ElectionMap electionMap;
	
	public MapProperties () {
		this.properties = new Properties();
		loadProperties();
	}
	
	private void loadProperties() {
		try {
			this.properties.load(new FileReader(Constants.ROUTE_PROPERTIES));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//traer los datos, del properties y guardarlos en ElectionMap

	public ElectionMap getElectionMap() {
		return electionMap;
	}
}
