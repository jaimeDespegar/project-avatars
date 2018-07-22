package json;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.json.simple.JSONObject;
import org.junit.Test;

import tablero.Board;

public class LoadDataJsonTest {

	@Test
	public void chargeBoardTest() {
		JSONObject globalJSON = new JSONObject();
		Board board = new Board(new Point(2,2));
		LoadDataJson loadDataJson = new LoadDataJson(globalJSON, board);
		loadDataJson.chargeBoard();
		assertNotNull(loadDataJson.getBoard());
	}
}
