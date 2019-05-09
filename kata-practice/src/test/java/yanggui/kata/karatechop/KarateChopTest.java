package yanggui.kata.karatechop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import karatechop.KarateChop;

public class KarateChopTest {
	@Test
	public void ChopArrayTest() {

		assertEquals(-1, KarateChop.chopByIterate(3, Arrays.asList()));
		assertEquals(-1, KarateChop.chopByIterate(3, Arrays.asList(1)));
		assertEquals(2, KarateChop.chopByIterate(3, Arrays.asList(1, 2, 3)));
		assertEquals(1, KarateChop.chopByIterate(3, Arrays.asList(2, 3)));

	}
}
