package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void test() {
		assertEquals("test key", "13588487926", Utility.generateKey());
	}
}
