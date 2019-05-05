package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNull(null);
		//fail("Not yet implemented");
	}
	@Test
	public void test1() {
		assertNotNull(null);
		//fail("Not yet implemented");
	}

}
