package json;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tablero.Box;

public class CreateJsonTest {

	@Test
	public void newCreateJson() {
		List<Box> boxes = new ArrayList<>();
		List<Point> points = new ArrayList<>();
		CreateJson createJson = new CreateJson(boxes, points);
		createJson.createNewJson();
		assertNotNull(createJson.getGlobalJSON());
		assertNotNull(createJson.getSaveDataJson());
	}
}
