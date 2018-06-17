package configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileReaderProperties {
	private Properties properties;

	public FileReaderProperties(String filePath) {
		this.properties = new Properties();
		loadFile(filePath);
	}

	private void loadFile(String filePath) {
		try {
			this.properties.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getFileConfiguration() {
		return properties;
	}
}
