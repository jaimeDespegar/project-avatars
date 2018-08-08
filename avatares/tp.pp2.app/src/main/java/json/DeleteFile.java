package json;

import java.io.File;

public class DeleteFile {

	/**Con esto se borra el objeto, de la ruta ingresada.*/
	public static void writeJson(String routeJson) {
		File file = new File(routeJson);
		file.deleteOnExit();//.delete();
	}
	
	public static void main(String[] args) {
		DeleteFile.writeJson("C:\\ProgramData\\test.txt");
	}
}
