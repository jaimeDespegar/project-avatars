package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tablero.Board;

@SuppressWarnings("unchecked")
public class SaveDataJson {
	private JSONObject globalJSON;
	private Board board;
	
	public SaveDataJson(JSONObject globalJSON, Board board) {
		this.globalJSON = globalJSON;
		this.board = board;
	}
	
	public void chargeBoard() {
		globalJSON.put("Width", board.getLimitsBoard().getX());
		globalJSON.put("Heigth", board.getLimitsBoard().getY());
		updateJson("Boxes", getListStringOfBoxes());
		updateJson("Points", getListStringOfPoints());
	}
	
	private JSONArray getListStringOfPoints() {
		JSONArray listStringOfPoints = new JSONArray();
		for (int y = 0; y < board.getBoxes()[0].length; y++) {
			for (int x = 0; x < board.getBoxes().length; x++) {
				listStringOfPoints.add("(" + x + "," + y + ")");
			}
		}
		return listStringOfPoints;
	}

	private JSONArray getListStringOfBoxes() {
		JSONArray listStringOfBoxes = new JSONArray();
		for (int y = 0; y < board.getBoxes()[0].length; y++) {
			for (int x = 0; x < board.getBoxes().length; x++) {
				if(board.getBoxes()[x][y]==null) {
					listStringOfBoxes.add("object.Fondo");
				}else{	
					listStringOfBoxes.add(board.getBoxes()[x][y].getObjectGraphic().getClass().getName());
				}
			}
		}
		return listStringOfBoxes;
	}
	
	/***con esto se anaden los distintos datos al globalJSON*/
	public void updateJson(String nameOfList, JSONArray dates) {
		globalJSON.put(nameOfList, dates);
	}

	public Board getBoard() {
		return board;
	}
}
