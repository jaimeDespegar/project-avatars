package json;

import org.json.simple.JSONObject;

import main.Constants;
import tablero.Board;

public class CreateJson {
	private JSONObject globalJSON;
	private SaveDataJson saveDataJson;
	
	public CreateJson(Board board) {
		this.globalJSON = new JSONObject();
		this.saveDataJson = new SaveDataJson(globalJSON, board);
	}
	
	public void createNewJson() {
		saveDataJson.chargeBoard();
		WriteFile.writeJson(globalJSON, Constants.ROUTE_JSON);
	}

	public JSONObject getGlobalJSON() {
		return globalJSON;
	}

	public SaveDataJson getSaveDataJson() {
		return saveDataJson;
	}
}