package tablero;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class TestCreateMap {
	private CreateMap createMap;
	
	@Before
	public void init() {
		createMap = new CreateMap();
	}
	
	@Test
	public void testMapNull() {
		assertNull(createMap.getMap());
	}

	@Test
	public void testCreateMap() {
		createMap.createMap();
		assertNotNull(createMap.getMap());
	}
}
