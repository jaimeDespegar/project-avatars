package json;

import java.awt.Point;
import java.util.List;

import main.Constants;
import tablero.Box;

public class ControllerUpdateBoxes {

	public ControllerUpdateBoxes(){
		
	}
	
	public void makeUpdate(List<Box> boxes, List<Point> points) {
		DeleteFile.writeJson(Constants.ROUTE_JSON_UPDATE);
		CreateJson createbox = new CreateJson(boxes, points);
	}
}
