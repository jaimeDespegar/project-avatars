package json;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.Test;

import tablero.Board;

public class CreateJsonTest {

	@Test
	public void newCreateJson() {
		Board board = new Board(new Point(2,2));
		CreateJson createJson = new CreateJson(board);
		createJson.createNewJson();
		assertNotNull(createJson.getGlobalJSON());
		assertNotNull(createJson.getSaveDataJson());
	}
}
