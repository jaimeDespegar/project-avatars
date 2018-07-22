package json;

import org.json.simple.JSONObject;

import main.Constants;
import tablero.Board;

public class CreateJson {
	private JSONObject globalJSON;
	private LoadDataJson loadDataJson;
	
	public CreateJson(Board board) {
		this.globalJSON = new JSONObject();
		this.loadDataJson = new LoadDataJson(globalJSON, board);
	}
	
	public void createNewJson() {
		loadDataJson.chargeBoard();
		WriteFile.writeJson(globalJSON, Constants.ROUTE_JSON);
	}

	public JSONObject getGlobalJSON() {
		return globalJSON;
	}

	public LoadDataJson getLoadDataJson() {
		return loadDataJson;
	}
}

//private JSONObject getObjectJSON(final String routeCodeJSON){
//	JSONParser lector = new JSONParser();
//	JSONObject objetoJSON = null;
//	try{
//		Object recuperado = lector.parse(routeCodeJSON);
//		objetoJSON = (JSONObject) recuperado;
//	}catch(ParseException e){
//	}
//	return objetoJSON;
//}