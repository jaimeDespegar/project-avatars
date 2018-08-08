package json;

import java.awt.Point;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tablero.Box;

@SuppressWarnings("unchecked")
public class SaveDataJson {
	private JSONObject globalJSON;
	private List<Box> boxes;
	private List<Point> points;

	public SaveDataJson(JSONObject globalJSON, List<Box> boxes, List<Point> points) {
		this.globalJSON = globalJSON;
		this.boxes = boxes;
		this.points = points;
	}
	
	/**puedo traer del properties, puede ser lo mejor*/
	public void chargeDimensionsOfBoard(double width, double heigth) {
		globalJSON.put("Width", width);
		globalJSON.put("Heigth", heigth);
	}
	
	public void chargeBoard() {
		updateJson("Boxes", getListStringOfBoxes());
		updateJson("Points", getListStringOfPoints());
	}
	
	private JSONArray getListStringOfPoints() {
		JSONArray listStringOfPoints = new JSONArray();
		for (Point point: points) {
			listStringOfPoints.add("(" + point.getX() + "," + point.getY() + ")");
		}
		return listStringOfPoints;
	}

	private JSONArray getListStringOfBoxes() {
		JSONArray listStringOfBoxes = new JSONArray();
		for (Box box: boxes) {
			if(box==null) {
				listStringOfBoxes.add("object.Fondo");
			}else{	
				listStringOfBoxes.add(box.getObjectGraphic().getClass().getName());
			}
		}
		return listStringOfBoxes;
	}
	
	/***con esto se anaden los distintos datos al globalJSON*/
	public void updateJson(String nameOfList, JSONArray dates) {
		globalJSON.put(nameOfList, dates);
	}
}
