package json;

import java.awt.Point;
import java.util.List;

import org.json.simple.JSONObject;

import main.Constants;
import tablero.Box;

public class CreateJson {
	private JSONObject globalJSON;
	private SaveDataJson saveDataJson;
	
	public CreateJson(List<Box> boxes, List<Point> points) {
		this.globalJSON = new JSONObject();
		this.saveDataJson = new SaveDataJson(globalJSON, boxes, points);
	}

	public void createNewJsonWhitLimitBoard(double width, double heigth) {
		saveDataJson.chargeDimensionsOfBoard(width, heigth);
		saveDataJson.chargeBoard();
		WriteFile.writeJson(globalJSON, Constants.ROUTE_JSON);
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