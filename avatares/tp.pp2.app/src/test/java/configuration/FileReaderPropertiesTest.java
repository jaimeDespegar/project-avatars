package configuration;

import org.junit.Test;
import configuration.Constans;

public class FileReaderPropertiesTest {
	
	@Test
	public void fileTest(){
		FileReaderProperties f= new FileReaderProperties(Constans.RUTA_PROPERTIES_MAP);
		f.getFileConfiguration();
	}
}
