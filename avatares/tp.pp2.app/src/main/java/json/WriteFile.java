package json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class WriteFile {
	
	/**Con esto se crea el archivo en escritorio, por lo tanto, se tiene que terminar de a�adir 
	 * todas las variables o datos al globalJSON*/
	public static void writeJson(JSONObject globalJSON, String routeJson) {
		try {
			FileWriter file = new FileWriter(routeJson);
			file.write(globalJSON.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			//manejar error
		}
	}
}
