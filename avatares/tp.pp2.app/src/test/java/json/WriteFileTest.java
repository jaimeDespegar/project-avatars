package json;

import static org.junit.Assert.assertTrue;
import java.io.File;
import org.json.simple.JSONObject;
import org.junit.Test;

public class WriteFileTest {

	@Test
	public void writeJsonTest() {
		JSONObject globalJSON = new JSONObject();
		WriteFile.writeJson(globalJSON, "C:\\\\ProgramData\\\\prueba2.json");
		File file = new File("C:\\\\ProgramData\\\\prueba2.json");
		assertTrue(file.exists());
	}
}
