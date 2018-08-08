package json;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Test;

import tablero.Box;

public class SaveDataJsonTest {

	@Test
	public void chargeBoardTest() {
		JSONObject globalJSON = new JSONObject();
		List<Box> boxes = new ArrayList<>();
		List<Point> points = new ArrayList<>();
		SaveDataJson loadDataJson = new SaveDataJson(globalJSON, boxes, points);
		loadDataJson.chargeBoard();
		assertNotNull(loadDataJson);
	}
}
