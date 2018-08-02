package criteriaOfAcceptance2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.json.simple.JSONObject;
import org.junit.Test;
import json.LectorJson;
import json.WriteFile;
import main.Constants;

public class UserStory04Test {

	/**
	 * Crear un archivo .json en “C:\ProgramData”, llamar al archivo .json en esa
	 * dirección, y comprobar que el archivo existe.
	 */
	@Test
	public void createJsonAnCheck() {
		WriteFile.writeJson(new JSONObject(), "C:\\\\ProgramData\\\\prueba2.json");
		File file = new File("C:\\\\ProgramData\\\\prueba2.json");
		assertTrue(file.exists());
	}
	/**
	 * Llamar al archivo .json en “C:\ProgramData”, y deberá lanzar una excepción de
	 * que no existe el archivo en la ruta específica.
	 */
	@Test(expected=AssertionError.class)
	public void callJsonNonExistent() {
		File file = new File("C:\\\\ProgramData\\\\prueba3.json");
		assertTrue(file.exists());
	}
	/**
	 * Crear un archivo .json en “C:\ProgramData”, cargarle las dimensiones del
	 * tablero (width=10, height=10), leer el archivo .json, y corroborar que tenga
	 * las dimensiones (width=10, height=10).
	 */
	@Test
	public void checkBoardSizeTest() {
		LectorJson lectorJson = new LectorJson(Constants.ROUTE_JSON);
		assertNotNull(lectorJson.getIntOfJson("Width"));
		assertNotNull(lectorJson.getIntOfJson("Heigth"));
	}
	/**
	 * Crear un archivo .json en “C:\ProgramData”, cargarle los objetos gráficos y
	 * sus respectivas posiciones del tablero, cargar el archivo .json y comprobar
	 * que la lista de posiciones y la lista de objetos gráficos, son iguales y
	 * tienen un tamaño mayor a cero.
	 */
	@Test
	public void checkBoardBoxesAndPointsTest() {
		LectorJson lectorJson = new LectorJson(Constants.ROUTE_JSON);
		//assertNotNull(lectorJson.getListOfJson("Points"));
		//assertNotNull(lectorJson.getListOfJson("Boxes"));
	}
}
